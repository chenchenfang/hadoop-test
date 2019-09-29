package com.scala.deftest

object defParaTest {
  def main(args:Array[String]): Unit ={

    def f1="我我哦我"
    println(f1)
    sum(10,12)
  }
  def sum(args:Int*) :Unit={
    for (i <- 0 until args.size){
      println(args(i))
    }

  }


}
