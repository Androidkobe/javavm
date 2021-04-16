package com.example.myjava.classload;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */


class Enclosingonechild extends Enclosingone {
    static {
        System.out.println("Enclosingonechild.enclosing_method():子类静态代码块");
    }

    public Enclosingonechild() {
        {
            System.out.println("Enclosingonechild.Enclosingonechild():子类构造函数");
        }
    }

    {
        System.out.println("Enclosingonechild.enclosing_method():子类构造代码块");
    }
}