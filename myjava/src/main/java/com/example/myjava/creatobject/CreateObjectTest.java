package com.example.myjava.creatobject;

import java.lang.reflect.Constructor;

import androidx.annotation.NonNull;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

class CreateObjectTest {

    public static void main(String[] args) {
        new classCreateFromClassName().createFromClassNameTest();
    }

    public static class classCreateFromClassName {

        public void createFromClassNameTest() {
//            try {
//                Class hello = Class.forName("com.example.myjava.creatobjectcom.example.myjava.creatobject
//                .CreateObjectTest.classCreateFromClassName.Hello");
//                System.out.println(hello.getClass().getPackage() + hello.getClass().getName());
//            }catch (Exception e){
//                System.out.println(e.toString());
//            }
//            }
            try {
                Class helloClass = Class.forName(
                        "com.example.myjava.creatobjectcom.example.myjava.creatobject"
                                + ".CreateObjectTest$classCreateFromClassName$Hello");
                Constructor constructor = helloClass.getConstructor();
                Hello hello = (Hello) constructor.newInstance();
                System.out.println(hello.getClass().getPackage() + hello.getClass().getName());
            } catch (Exception e) {

            }
        }

        class Hello {


        }
    }


    /**
     * java 对象深拷贝 java 对象浅拷贝
     */
    public static class classCloneTest {
        public void cloneTest() {
            //克隆方式创建
            AnimalFamily animalFamilyParent = new AnimalFamily();
            System.out.println("parent class info = " + animalFamilyParent.toString());
            try {
                AnimalFamily animalFamilychildren = (AnimalFamily) animalFamilyParent.clone();
                System.out.println("children class info = " + animalFamilychildren.toString());
            } catch (Exception e) {
                System.out.println("children class clone error = " + e.toString());
            }
        }

        class AnimalFamily implements Cloneable {
            String familyName = "one by";
            private Dog mDog = new Dog();

            @Override
            public String toString() {
                return "AnimalFamily{" +
                        "familyName='" + familyName + '\'' +
                        ", mDog=" + mDog +
                        '}';
            }

            @NonNull
            @Override
            protected Object clone() throws CloneNotSupportedException {
                mDog = (Dog) mDog.clone();
                return super.clone();
            }
        }

        class Dog implements Cloneable {
            String name = "max";

            @NonNull
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }
    }

}
