import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zsq on 2019-05-24.
 */
public class Main1{

    public static void main(String[] args){
        AtomicInteger num = new AtomicInteger();
        Pattern pattern = Pattern.compile("^\\[(.+)\\]\\s?(\\S+)$");
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        Matcher matcher = pattern.matcher(inStr);
        if(matcher.find()){
            String[] arr = matcher.group(1).split(" ");
            String str = matcher.group(2);

            List<Word> list = new ArrayList<>();
            Stream.of(arr).forEach(s->{
                int idx = -1,weight = 0;
                while((idx=str.indexOf(s,idx+1)) != -1){
                    weight++;
                    num.incrementAndGet();
                }
                if(weight > 0){
                    list.add(new Word(s,s.length(),weight));
                }
            });
            List<Word> newList = list.stream().sorted(Comparator.comparing(Word::getLen).reversed()).collect(Collectors.toList());
            System.out.println(newList);

//            StringBuilder sb = new StringBuilder(str);
//            newList.stream().forEach(o->{
//                num.incrementAndGet();
//                for(int idx=sb.indexOf(o.str);idx!=-1;idx++){
//                    sb.delete(idx,idx+o.len-1);
//                }
//                System.out.println(sb);
//            });

            int len = newList.size();
            String newStr = str;
            for(int i=0;i<len;i++){
                num.incrementAndGet();
                newStr = newStr.replace(newList.get(i).getStr(),"");
            }

            if("".equals(newStr)){
                System.out.println("true" +" "+ num.get());
            }else{
                System.out.println("false" +" "+ num.get());
            }
        }
    }

    static class Word{
        private String str;
        private int len;
        private int weight;

        public Word(String str,int len,int weight){
            this.str = str;
            this.len = len;
            this.weight = weight;
        }

        public String getStr(){
            return str;
        }

        public void setStr(String str){
            this.str = str;
        }

        public int getLen(){
            return len;
        }

        public void setLen(int len){
            this.len = len;
        }

        public int getWeight(){
            return weight;
        }

        public void setWeight(int weight){
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "Word{" + "str='" + str + '\'' + ", len=" + len + ", weight=" + weight + '}';
        }
    }

}
