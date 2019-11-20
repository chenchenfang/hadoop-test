package com.fang7.java.api;

/**
 * 手写单例模式
 */
public class Singleton {
    private static final Object clock=new Object();
    private static Singleton singleton;
    public static Singleton getSingleton(){

        if(singleton==null){
            synchronized (clock){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args){
        Singleton singleton = getSingleton();
        System.out.println(singleton);
    }
}
