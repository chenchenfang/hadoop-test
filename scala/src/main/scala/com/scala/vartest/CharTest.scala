package com.scala.vartest

object CharTest {
  /**
   * 文档注释
   *
   * @param args 参数
   */
  def main(args: Array[String]): Unit = {
    //直接这么赋值可以 编译器只会检查变量的范围
    var char1: Char = 99
    //不能计算 这样编译器会报错  编译器会检查 变量类型以及变量的范围
    //var char2: Char = 99+1
  }

  def throwException: Nothing = {
    throw new Exception("www")
  }
}
