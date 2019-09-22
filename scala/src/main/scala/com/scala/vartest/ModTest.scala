package com.scala.vartest

/**
 * 取模测试
 */
object ModTest {
  def main(args: Array[String]): Unit = {

    println(10 % 3) // 1
    println(-10 % 3) // -1
    println(-10 % -3) // -1
    println(10 % -3) // 1

    val huashi= 232.5
    val sheshi =5.0/9 *(huashi -100)
    println(sheshi.formatted("%.2f"))
  }
}
