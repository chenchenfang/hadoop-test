package com.scala.vartest

import scala.io.StdIn

object InPutTest {
  def main(args :Array[String]): Unit ={
    println("请输入:")
    var str1 :String =StdIn.readLine()
    println(str1)
  }

}
