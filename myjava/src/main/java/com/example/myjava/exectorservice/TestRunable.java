package com.example.myjava.exectorservice;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

class TestRunable implements Runnable{
    int i = 0;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
