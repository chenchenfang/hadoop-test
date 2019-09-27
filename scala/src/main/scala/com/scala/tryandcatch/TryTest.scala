package com.scala.tryandcatch

object TryTest {
  def main(args:Array[String]):Unit ={
    try {
      val r: Int = 10 / 0
    } catch {
      case exception: ArithmeticException => println("捕获了除数为零的算术异常")
      case exception: Exception => println("捕获了异常")
    } finally {
      println("scala finally")
    }

  }

}
