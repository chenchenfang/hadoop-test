package com.fang7.java.jvm;

public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[55000*1024];
        allocation2 = new byte[9000 * 1024];
    }
}
