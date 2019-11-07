import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 1 + 2^(1+1) * 2 /(1 + (4 - 3))
 * 转换为逆波兰表达式为：1 2 1 1 + ^ 2 * 1 4 3 - + / +
 * Created by zsq on 2019-06-09.
 */
public class Calc{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("=> "+str);
        System.out.println("result = "+new Calc().calc(str));
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

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack();
        for(String s : list){
            if(this.isNumber(s)){
                result.add(s);
            }else{
                if("(".equals(s)){
                    stack.push(s);
                }else if(")".equals(s)){
                    while(!stack.isEmpty()){
                        String temp = stack.pop();
                        if(!"(".equals(temp)){
                            result.add(temp);
                        }else{
                            break;
                        }
                    }
                }else{
                    if(stack.isEmpty()){
                        stack.push(s);
                    }else{
                        while(!stack.isEmpty() && this.precedence(stack.lastElement()) >= this.precedence(s)){
                            result.add(stack.pop());
                        }
                        stack.push(s);
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        System.out.println("RPN => "+result);
        return this.calc(result);
    }


    public String calc(List<String> rpnList){
        try{
            Stack<String> numStack = new Stack();
            int len = rpnList.size();
            for(int i = 0;i < len;i++){
                String operation = rpnList.get(i);
                if(isNumber(operation)){
                    numStack.push(operation);
                }else{
                    BigDecimal num1 = new BigDecimal(numStack.pop());
                    BigDecimal num2 = new BigDecimal(numStack.pop());
                    BigDecimal num0 = new BigDecimal("0");

                    if("+".equals(operation)){
                        num0 = num2.add(num1);
                    }else if("-".equals(operation)){
                        num0 = num2.subtract(num1);
                    }else if("*".equals(operation)){
                        num0 = num2.multiply(num1);
                    }else if("/".equals(operation)){
                        num0 = num2.divide(num1,2,BigDecimal.ROUND_DOWN);
                    }else if("^".equals(operation)){
                        num0 = num2.pow(num1.intValue());
                    }
                    numStack.push(num0.toString());
                }
            }
            return numStack.pop();
        }catch(ArithmeticException e){
            return "Float.nan";
        }
    }

    private boolean isNumber(String str){
        return Pattern.compile("^(-?\\d+)(\\.\\d+)?$").matcher(str).matches();
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

}
