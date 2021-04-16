package com.example.myjava;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

public class InnerA {

    public void testA(){
       String a =  new InnerB().name;
       String c = new InnerC().name;
    }

    class InnerB{
        private String name = "";
//        static Stirng age = "";
    }
    static class InnerC{
        private String name = "";
    }
}
