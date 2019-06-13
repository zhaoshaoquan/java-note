import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 1 + 2^(1+1) * 2 /(1 + (4 - 3))
 *
 * Created by zsq on 2019-06-09.
 */
public class Calc{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("=> "+str);

        System.out.println(new Calc().calc(str));
    }

    public String calc(String str){
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str,"+-*/^%()",true);
        while(st.hasMoreTokens()){
            String s = st.nextElement().toString().trim();
            if(!"".equals(s)){
                list.add(s);
            }
        }

        System.out.println("=> "+list);

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack();
        for(String s : list){
            if(this.isNumber(s)){
                result.add(s);
            }else{
                if(s.equals("(")){
//                    stack.push(s);
                }else if(s.equals(")")){
                    while(!stack.isEmpty()){
                        String temp = stack.pop();
                        if(!temp.equals("(")){
                            result.add(temp);
                        }else{
                            break;
                        }
                    }
                }else{
                    if(stack.isEmpty()){
                        stack.push(s);
                    }else{
                        if(this.precedence(stack.firstElement()) >= this.precedence(s)){
                            while(!stack.isEmpty() && this.precedence(stack.firstElement()) >= this.precedence(s)){
                                result.add(stack.pop());
                            }
                        }
                        stack.push(s);
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        System.out.println("=> "+result);

        return this.calc(result);
    }


    public String calc(List<String> rpnList){
        try{
            Stack<String> numberStack = new Stack();

            int length = rpnList.size();
            for(int i = 0;i < length;i++){
                String temp = rpnList.get(i);
                if(isNumber(temp)){
                    numberStack.push(temp);
                }else{
                    BigDecimal tempNumber1 = new BigDecimal(numberStack.pop());
                    BigDecimal tempNumber2 = new BigDecimal(numberStack.pop());
                    BigDecimal tempNumber = new BigDecimal("0");

                    if(temp.equals("+")){
                        tempNumber = tempNumber2.add(tempNumber1);
                    }else if(temp.equals("-")){
                        tempNumber = tempNumber2.subtract(tempNumber1);
                    }else if(temp.equals("*")){
                        tempNumber = tempNumber2.multiply(tempNumber1);
                    }else if(temp.equals("/")){
                        tempNumber = tempNumber2.divide(tempNumber1,2,2);
                    }else if(temp.equals("^")){
//                        tempNumber = tempNumber2.pow(tempNumber1.intValue());
                    }
                    numberStack.push(tempNumber.toString());
                }
            }
            return numberStack.pop();
        }catch(ArithmeticException e){
            return "Float.nan";
        }
    }

    private int precedence(String str){
        switch(str.charAt(0)){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
            case '%':
                return 3;
            case '(':
            case ')':
            default:
                return 0;
        }
    }

    private boolean isNumber(String str){
        return Pattern.compile("^(-?\\d+)(\\.\\d+)?$").matcher(str).matches();
    }

}
