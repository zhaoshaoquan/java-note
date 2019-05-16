package com.redtide.P0110;

/**
 * HASH(0x61c88647)测试
 * Created by zsq on 2019-05-15.
 */
public class MagicHashCode{
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        hashCode(16); //初始化16
        hashCode(32); //后续2倍扩容
        hashCode(64);

        long l1 = (long) ((1L << 32) * (Math.sqrt(5) - 1)/2);
        System.out.println("as 32 bit unsigned: " + l1);
        int i1 = (int) l1;
        System.out.println("as 32 bit signed:   " + i1);
        System.out.println("MAGIC = " + 0x61c88647);
    }

    private static void hashCode(Integer length){
        int hashCode;
        for(int i=0; i< length; i++){
            // 每次递增HASH_INCREMENT
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print(hashCode & (length-1));
            System.out.print(" ");
        }
        System.out.println();
    }
}
