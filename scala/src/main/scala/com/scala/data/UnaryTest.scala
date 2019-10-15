package com.scala.data

/**
 * 一元运算符 自定义
 */
object UnaryTest {

  def main(args: Array[String]): Unit = {
    val operate = new Operate
    !operate
  }
}

class Operate {
  // 声明前置运算符
  //unary ：一元运算符
  def unary_!(): Unit ={
    println("!!!!!!!")
  }
}

