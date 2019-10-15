package com.scala.data

/**
 * view用于懒加载
 */
object ViewTest {
  def main(args: Array[String]): Unit = {

    val ints = (1 to 100).filter(int => int.toString.equals(int.toString.reverse))
    println(ints)

    val viewInts = (1 to 100).view.filter(int => int.toString.equals(int.toString.reverse))
    println(viewInts)
    for(i <-viewInts){
      println(i)
    }
  }
}
