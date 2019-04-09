package com.redtide.P0110;

import java.util.stream.Stream;

/**
 * lambda表达式异常处理
 * Created by zsq on 2019-04-05.
 */
public class LambdaException{

    public static void main(String[] args){
        try{
            new LambdaException().test();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void test(){
        System.out.println("11");
        Stream.of("aa","bb","cc","dd").forEach(o->{
            try{
                System.out.println(o);
                throw new Exception();
            }catch(Exception e){
                BizException.doThrow(e);
            }
        });
        System.out.println("22");
    }

    static class BizException extends Exception{
        public static <E extends Exception> void doThrow(Exception e)throws E{
            throw (E)e;
        }
    }
}
