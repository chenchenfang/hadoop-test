package javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest {
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        test3();
    }

    public static void test1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入:");
        char read = (char) bufferedReader.read();
        System.out.println("你输入的是:"+read);
    }

    public static void test2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一个字符 按q 结束");

        char c;
        do{
            c=(char) bufferedReader.read();
            if(c=='q'){
                break;
            }
            System.out.println("你数入的字符为"+c);
        }while (c!='q');

    }

    public static void test3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行");
        String s = bufferedReader.readLine();
        System.out.println("你输入的是:"+s);
    }
}
