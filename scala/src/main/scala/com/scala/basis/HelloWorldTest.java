package com.scala.basis;

public class HelloWorldTest {
    public static void main(String[] args) {
        HelloWorldTest$.MODULE$.main(args);
    }
}

final class HelloWorldTest${
    public static final HelloWorldTest$ MODULE$;
    static {
        MODULE$=new HelloWorldTest$();
    }

    public   void  main(String[] args){
        System.out.println("HelloWold,scala!");
    }

}
