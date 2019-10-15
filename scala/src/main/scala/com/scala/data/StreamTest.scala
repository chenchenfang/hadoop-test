package com.scala.data

/**
 * 流总是懒加载
 * 只能从头开始获取元素
 */
object StreamTest {
  def main(args: Array[String]): Unit = {
    def numStream(n: BigInt): Stream[BigInt] = n #:: numStream(n + 1)
    val ints = numStream(10)
    println(ints)
    println(ints.tail)
  }
}
