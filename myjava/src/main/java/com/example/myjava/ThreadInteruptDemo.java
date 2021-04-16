package com.example.myjava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock可中断锁的效果
 */
public class ThreadInteruptDemo {
    ReentrantLock lock1=new ReentrantLock();
    /**
     * ReentrantLock响应中断
     * @throws Exception
     */
    public void exeInterupt() throws Exception{
        Thread t1=new Thread(new DemoThread(lock1));
        Thread t2=new Thread(new DemoThread(lock1));
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        System.out.println(t2.getName()+"开始中断"+System.currentTimeMillis());
        //主线程睡眠1秒，避免线程t1直接响应run方法中的睡眠中断
        t2.interrupt();
        //阻塞主线程，避免所有线程直接结束，影响死锁效果
        Thread.sleep(10000);
    }


    /**
     * ReentrantLock实现死锁
     */
    static class DemoThread implements Runnable{

        ReentrantLock lock1;

        public DemoThread(ReentrantLock lock1){
            this.lock1=lock1;
        }

        @Override
        public void run() {
            try {
                //可中断的获取锁
                lock1.lockInterruptibly();
                //lock1.lock();
                //睡眠200毫秒，保证两个线程分别已经获取到两个锁，实现相互的锁等待
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("线程"+Thread.currentThread().getName()+"执行完成");
                //lock2.lock();
                //可中断的获取锁
            } catch (InterruptedException e) {
                System.out.println("线程"+Thread.currentThread().getName()+"中断完成"+System.currentTimeMillis());
                e.printStackTrace();
            }finally {
                lock1.unlock();
            }

        }
    }

    /**
     * Synchronized实现死锁
     */
    static class DemoThread1 implements Runnable{

        Object lock1;
        Object lock2;

        public DemoThread1(Object lock1,Object lock2){
            this.lock1=lock1;
            this.lock2=lock2;
        }

        @Override
        public void run() {
            try {
                synchronized (lock1){
                    //睡眠200毫秒，再获取另一个锁，
                    //保证两个线程分别已经获取到两个锁，实现相互的锁等待
                    TimeUnit.MILLISECONDS.sleep(200);
                    synchronized (lock2){
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("线程"+Thread.currentThread().getName()+"正常结束");
            }

        }
    }
}