package com.fang7.java.lambda;

import java.util.HashMap;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i,"val"+i);
        }
        map.computeIfPresent(3, (num,val)-> val+num);
        map.forEach((id,val)-> System.out.println(val));
        map.getOrDefault(44,"not found");

    }
}
