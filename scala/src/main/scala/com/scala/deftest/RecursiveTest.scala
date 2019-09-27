package com.scala.deftest

/**
 * 递归的简单实验
 */
object RecursiveTest {

  def main(args: Array[String]): Unit = {
    var i: Int = eat(10)
    println(i)

    for (jj <- 1 to 9) {
      i = i / 2 - 1
    }
    println(i)
  }

  def test(n: Int) {
    if (n > 2) {
      test(n - 1)
    }
    println("n=" + n) //
  }

  def test2(n: Int) {
    if (n > 2) {
      test2(n - 1)
    } else {
      println("n=" + n)
    }
  }

  /**
   * f(1)=3;
   * f(n) = 2*f(n-1)+1;
   */
  def sum(n: Int): Int = {
    if (n == 1) {
      return 3
    } else {
      return 2 * sum(n - 1) + 1
    }
  }

  /**
   * 有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
   * 以后每天猴子都吃其中的一半，然后再多吃一个。
   * 当到第十天时，想再吃时（还没吃），发现只有1个桃子了。
   * 问题：最初共多少个桃子？
   * 第n天还剩下1个桃子
   */
  def eat(n: Int): Int = {
    if (n == 1) {
      return 1;
    } else {
      return (eat(n - 1) + 1) * 2
    }
  }

}
