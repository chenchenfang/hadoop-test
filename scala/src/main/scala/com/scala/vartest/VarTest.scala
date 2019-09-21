package com.scala.vartest

/**
 * val 为不可变 会自动加上final
 * var 为可变变量
 */
object VarTest {
  def main(args: Array[String]): Unit = {
    var phoneNum: Int = 678
    val yourNum: Int = 233
    phoneNum = 100
    //这个会出错
    //yourNum = 133
    println(s"$phoneNum   $yourNum")
  }
}
