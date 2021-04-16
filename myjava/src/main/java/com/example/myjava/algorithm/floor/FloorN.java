package com.example.myjava.algorithm.floor;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

class FloorN {

    public static void main(String[] args) {
        long start =  System.currentTimeMillis();
        System.out.println(jumpStepFibonacci(45));
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start)+"ms");
        System.out.println("/************************/");
        long start1 =  System.currentTimeMillis();
        System.out.println(jumpStepTempFibonacci(45));
        long end1 = System.currentTimeMillis();
        System.out.println("time:"+(end1-start1)+"ms");
    }


    /**上台阶问题,递归求解**/
    public static int jumpStepFibonacci(int n) {
        if(n<0) return -1;
        if(n<=2) return n;
        return jumpStepFibonacci(n-1)+jumpStepFibonacci(n-2);
    }

    /**记录路径 迭代**/
    public static int jumpStepTempFibonacci(int n){
       if(n==0 || n== 1 || n == 2){
           return n;
       }
       int[] mem = new int[n];
       mem[0] = 1;
       mem[1] = 2;
       for(int i = 2; i < n;i++){
            mem[i] = mem[i-1]+mem[i-2];
       }
        return mem[n-1];
    }
}
