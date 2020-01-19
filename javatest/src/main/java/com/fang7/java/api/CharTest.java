package com.fang7.java.api;

public class CharTest {
    public static void main(String[] args) {
        String ss="\uD801\uDC37";
        System.out.println(ss);
        try {
            int i=10/0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
