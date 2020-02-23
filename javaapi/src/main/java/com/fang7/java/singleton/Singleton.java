package com.fang7.java.singleton;

/**
 * 静态内部类实现单例模式
 */
class Singleton {
    private Singleton(){}

    private static class SingletonInner{
        private static final Singleton SINGLETON=new Singleton();
    }

    public static Singleton getSingleton(){
        return SingletonInner.SINGLETON;
    }

}