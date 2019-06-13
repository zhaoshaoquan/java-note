import java.util.*;

/**
 * Created by zsq on 2019-05-25.
 */
public class Test{

    static int i = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        charge(inStr);
    }

    public static void charge(String s){
        String begin = s.substring(1,s.lastIndexOf("]"));
        String[] words = begin.split(" ");
        List<String> wordList = Arrays.asList(words);
        String compareWord = s.substring(s.lastIndexOf("]") + 1).trim();
        //<开始部分，剩下的部分>
        Map<String,String> map = new HashMap<>();
        map.put("",compareWord);
        boolean b = compare(compareWord,map,wordList);
        System.out.println(b);
        System.out.println(i);
    }


    private static boolean compare(String compareWord,Map<String,String> map,List<String> wordList){
        if(map.get(compareWord) != null){
            return true;
        }
        Map<String,String> newMap = new HashMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            String s = entry.getKey();
            String s2 = entry.getValue();
            for(String s1 : wordList){
                i++;
                if(s2.startsWith(s1)){
                    String start = s + s1;
                    String end = s2.substring(s1.length());
                    newMap.put(start,end);
                }
            }
            if(compare(compareWord,newMap,wordList)){
                return true;
            }
        }
        return false;
    }

}
