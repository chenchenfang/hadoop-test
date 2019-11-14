package com.fang7.java.api.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        int a[] ={1,3,2,5,98,32,6,5};
        Arrays.sort(a);
        System.out.println();

        List<String> string = Arrays.asList("String", "123", "2");
        System.out.println(string);

        System.out.println(Arrays.toString(a));

        //复制 数组
        int[] ints = Arrays.copyOfRange(a, 2, 4);
        System.out.println(Arrays.toString(ints));
    }
}
