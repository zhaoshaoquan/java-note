package com.redtide;

import java.util.*;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zsq on 2019-04-12.
 */
public class CyclicBarrierDemo1{
    private Random random = new Random();

    public static void main(String[] args){
        try{
            new CyclicBarrierDemo1().barrier();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void barrier(){
        int num = 5;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            List<Integer> val = new ArrayList<>();
            for(int j=0;j<random.nextInt(10)+1;j++){
                val.add(random.nextInt(100));
            }
            list.add(val);
        }
        System.out.println(list);


        List<Integer> result = new ArrayList<>();
        final CyclicBarrier barrier = new CyclicBarrier(num);
        for(int i=0;i<num;i++){
            new Thread(new Sum(list.get(i),result,barrier)).start();
        }
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                System.out.println(result);
            }
        },0,500);
    }

    class Sum implements Runnable{
        private int sum;
        private final List<Integer> val;
        private final List<Integer> result;
        private final CyclicBarrier barrier;

        public Sum(final List<Integer> val,final List<Integer> result,final CyclicBarrier barrier){
            this.val = val;
            this.result = result;
            this.barrier = barrier;
        }

        @Override
        public void run(){
            try{
                int size = val.size();
                for(int i=0;i<size;i++){
                    sum += val.get(i);
                    System.out.println(Thread.currentThread().getName()+" -> 当前统计第 "+i+" 个数据，当前总合是 "+sum);
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName()+" -> 统计执行完成，等待处理中..."+sum);
                barrier.await();
                result.add(sum);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
