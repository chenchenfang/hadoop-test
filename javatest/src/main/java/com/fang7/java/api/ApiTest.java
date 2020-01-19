package com.fang7.java.api;

import java.util.Arrays;
import java.util.Comparator;

public class ApiTest {
    public static void main(String[] args) {
        arraySort();
    }
    public static void arrayEquals(){
        int[] ints1 = {1,2,3,4,5};
        int[] ints2 = {1,2,3,4,5};

        boolean equals = Arrays.equals(ints1, ints2);
        System.out.println(equals);
    }

    public static void arraySort(){
        MyComparator myComparator = new MyComparator();
        Integer[] ints = {2, 5, 3, 1, 6, 7};
        Arrays.sort(ints,myComparator);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.binarySearch(ints, 0));
    }

}
class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>o2){
            return 1;
        }else if(o1<o2){
            return -1;
        }
        else {
            return 0;
        }

    }

}
