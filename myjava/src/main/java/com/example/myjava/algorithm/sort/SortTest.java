package com.example.myjava.algorithm.sort;

import java.util.Arrays;

/**
 * (分治算法、动态规划算法、贪心算法、回溯法、分治界限法)
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

class SortTest {

    public static int[] arr = new int[]{9,8,1,3,4,6,2,7,5,20};
    public static void main(String[] args) {
//        quicksort(arr,0,arr.length-1);
        mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }




    //选择排序
    public static int[] selectionSort(int[] arr) {
        int minindex = 0;
        for(int i = 0;i<arr.length;i++){
            minindex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minindex]){
                    minindex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
        return arr;
    }


    //插入排序
    public static int[] insertionSort(int[] arr){
        int preIndex =0;
        int current = 0;
        for(int  i = 1;i<arr.length;i++){
            preIndex = i -1;
            current = arr[i];
            while (preIndex>=0 && arr[preIndex]>current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
       return arr;
    }

    //冒泡排序1
    public static int[] BubbleSort1(int[] arr) {
        for(int i = 0 ;i<arr.length;i++){
            for(int j = 0;j<=i;j++){
                int temp = arr[i];
                int temp2 = arr[j];
                if(temp<temp2){
                    arr[i] = temp2;
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    //冒泡排序2
    public static int[] BubbleSort2(int[] arr) {
        for(int i = 0 ;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                int temp = arr[j];
                int temp2 = arr[j+1];
                if(temp>temp2){
                    arr[j] = temp2;
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }


    //快排
    public static void quicksort(int [] a,int left,int right)
    {
        int low=left;
        int high=right;
        //下面两句的顺序一定不能混，否则会产生数组越界！！！very important！！！
        if(low>high)//作为判断是否截止条件
            return;
        int k=a[low];//额外空间k，取最左侧的一个作为衡量，最后要求左侧都比它小，右侧都比它大。
        while(low<high)//这一轮要求把左侧小于a[low],右侧大于a[low]。
        {
            while(low<high&&a[high]>=k)//右侧找到第一个小于k的停止
            {
                high--;
            }
            //这样就找到第一个比它小的了
            a[low]=a[high];//放到low位置
            while(low<high&&a[low]<=k)//在low往右找到第一个大于k的，放到右侧a[high]位置
            {
                low++;
            }
            a[high]=a[low];
        }
        a[low]=k;//赋值然后左右递归分治求之
        quicksort(a, left, low-1);
        quicksort(a, low+1, right);
    }

    //归并排序
    public static int[] mergeSort(int[] arr,int lfindex,int rigindex) {
        int len = arr.length;
        if(len <= 1) {
            return arr;
        }
        int middle = (lfindex+rigindex)/2;
        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle+1,rigindex);
        return merge(mergeSort(left,0,middle), mergeSort(right,middle+1,rigindex));
    }

    public static int[] merge(int [] left,int[] right){
        int[] temp = new int[]{};
        int i = 0;
      while (left.length>0 || right.length>0){
          int x = 0;
          int y = 0;
          if(left[x]<right[x]){
              temp[i] = left[y];
              left = Arrays.copyOfRange(left,1,left.length-1);
          }else{
              temp[i] = right[y];
              right = Arrays.copyOfRange(right,1,right.length-1);
          }
      }
      if(left.length == 1){
          temp[i+1] = left[left.length-1];
      }
        if(right.length == 1){
            temp[i+1] = left[left.length-1];
        }
        return temp;
    }

}
