package com.example.myjava.classload;

class Enclosingone {
    static final int a = 100;

    static {
        System.out.println("Enclosingone.enclosing_method():父类静态代码块");
    }

    public Enclosingone() {
        {
            System.out.println("Enclosingone.Enclosingone():父类构造函数");
        }
    }

    {
        System.out.println("Enclosingone.enclosing_method():父类构造代码块");
    }

    public static void age (){
        System.out.println("Enclosingone.enclosing_method():父类静态方法");
    }
    public void name() {
        {
            System.out.println("Enclosingone.name():父类普通代码块");
        }
    }

    public static class InsideOne {//静态内部类
        static {
            System.out.println("Enclosingone.InsideOne.enclosing_method():静态内部类");
        }
    }

    public class InsideOne2 {//内部类
        //静态内部类的加载不需要依附外部类，在使用时才加载。不过在加载静态内部类的过程中也会加载外部类
        //非静态内部类不能使用静态代码块(一般的非静态类可以有静态代码块)
        //因为非静态内部类相当于外部的非静态成员变量,如果外部类要调用非静态成员变量，则需要创建对象，
        //进行调用;而非静态内部类中有static代码块，那么在外部类加载的时候就会加载，不需要考虑外部状态
        //则与外部类的创建相驳论，所以静态内部类不能创建静态代码块
        static final int a = 200;//就近原则匹配a的值

        public InsideOne2() {
            System.out.println(a);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("最后一次a:" + a);
    }
}
