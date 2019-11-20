package com.fang7.java.api;

/**
 * 死锁案例
 */
public class ClickTest {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (o1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("get o2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println(Thread.currentThread()+" get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("get o1");
                }
            }
        },"线程2").start();
    }
}
