package com.fang7.java.api;

import java.util.ArrayList;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);

        objects.iterator().forEachRemaining(x -> System.out.println(x));
    }
}
