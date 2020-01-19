package com.fang7.java.api;

import java.io.*;

public class FileInputTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\a.txt")));
        String ss;
        while((ss=bufferedReader.readLine())!=null){
            System.out.println(ss);
        }


    }
}
