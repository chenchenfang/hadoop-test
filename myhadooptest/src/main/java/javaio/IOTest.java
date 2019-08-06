package javaio;

import java.io.*;

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


    public  void test4() throws IOException {
        byte[] bytes = {12,2,1,33,43,22};
        FileOutputStream fileoutputS = new FileOutputStream(new File("d:\\iooutput.txt"));
        fileoutputS.write(bytes);
        fileoutputS.close();
    }

    public void test5() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\iooutput.txt"));
        byte[] bytes = new byte[4];
        while (fileInputStream.read(bytes, 0, bytes.length)!=-1){

            for (byte bbb:
                    bytes) {
                System.out.println(bbb);
            }
            bytes=new byte[4];
        }
    }

    public void test6() throws IOException {
        FileInputStream in = new FileInputStream("D:\\75509677_p0.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("D:\\pp.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        byte[] bytes = new byte[1024];
        int len=0;
        while((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

        out.close();
        bufferedInputStream.close();
        in.close();

    }

}
