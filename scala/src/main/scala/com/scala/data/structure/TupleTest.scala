package com.scala.data.structure

/**
 * 元组的使用
 * 最多能使用22个
 */
object TupleTest {
  def main(args: Array[String]): Unit = {
    val tuple = (1,"a","b",22,true)
    println(tuple._5)

    tuple.productIterator.foreach(x => println(x))
  }
}
