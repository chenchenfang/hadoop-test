package com.scala.deftest

/**
 * 递归的简单实验
 */
object RecursiveTest {

  def main (args:Array[String]):Unit={
    test2(4)
  }
  def test (n: Int) {
    if (n > 2) {
      test (n - 1)
    }
    println("n=" + n) //
  }

  def test2 (n: Int) {
    if (n > 2) {
      test2 (n - 1)
    }else {
      println("n=" + n)
    }
  }


}
