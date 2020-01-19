package com.fang7.java.api.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("456");
        strings.add("789");
        strings.add("444");
        strings.add("443");
        strings.add("134");

        System.out.println(strings.toString());
        Collections.reverse(strings);
        System.out.println(strings);

        System.out.println();

        System.out.println(strings.toString());
        Collections.shuffle(strings);
        System.out.println(strings);

        System.out.println();

        System.out.println(strings.toString());
        Collections.sort(strings);
        System.out.println(strings);

        System.out.println();

        System.out.println(strings.toString());
        Collections.rotate(strings,3);
        System.out.println(strings);

        //统计出现的次数
        int frequency = Collections.frequency(strings, "134");
        System.out.println(frequency);

        System.out.println();

        //查找第一次出现当前list的索引
        ArrayList<String> subList = new ArrayList<>();
        subList.add("123");
        subList.add("134");
        int i = Collections.indexOfSubList(strings, subList);
        System.out.println(i);

        Collections.replaceAll(strings,"123","***");
        System.out.println(strings);



    }
}
