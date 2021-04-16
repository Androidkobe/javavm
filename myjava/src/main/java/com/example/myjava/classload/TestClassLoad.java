package com.example.myjava.classload;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

class TestClassLoad {
    public static void main(String[] args) {
//        new Enclosingone.InsideOne();//静态内部类直接声明使用//相当于外部类
//        System.out.println("-------------");
//        new Enclosingone().new InsideOne2();
//        System.out.println("--------------");
        new Enclosingonechild().name();
        System.out.println("--------------");
        new Enclosingonechild().age();
        System.gc();//调用gc回收，触发finalize方法;
    }
}
