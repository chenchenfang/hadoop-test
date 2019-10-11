package com.fang7.java.api;

import java.util.Collection;
import java.util.HashSet;

public class MyHashSet {
    public static void main(String[] args) {
        Collection<String> strings = new HashSet<>();
        strings.add("123");
        strings.add("www");
        strings.add("rgsd");
        strings.iterator().forEachRemaining(s -> {
            System.out.println(s);
        });

    }
}
