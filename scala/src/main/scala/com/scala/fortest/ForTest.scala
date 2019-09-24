package com.scala.fortest

/**
 * 关于for循环的测试
 * @author fang7
 */
object ForTest {
  def main(args: Array[String]): Unit = {
    test7()

  }
  def test1() :Unit ={
    //左闭右闭
    for(i <- 1 to 3){
      println(i)
    }

    println()

    //左闭右开
    for (i <- 1 until 3 ){
      println(i)
    }
  }

  def test2():Unit = {
    //循环守卫
    //相当于 continue
    for (i <- 1 to 3 if i!=2){
      println(i)
    }

    println()

    //以上代码等价于
    for (i <- 1 to 3){
      if(i!=2){
        println(i)
      }
    }
  }

  def test3():Unit ={
    //添加初始化变量 j
    for (i <- 1 to 3 ; j=i+1){
      println(j)
    }

    println()

    //等价于上边的
    for (i <- 1 to 3){
      val j=i+1
      println(j)
    }
  }

  /**
   * 遍历生成新的集合
   */
  def test4():Unit={
    val ints = for (i <- 3 to 10) yield i
    println(ints)
  }

  def test5(): Unit ={
    for{
      i <- 3 to 6
      j=i+1
    }{
      println(j)
    }
  }

  /**
   * 打印9的倍数 以及总和
   */
  def test6():Unit={
    var sum :Int=0
    for (i <- 1 to 100){
      if(i%9==0){
        println(i)
        sum+=i
      }
    }
    println(s"总和为:$sum")
  }

  /**
   * 简单的打印
   */
  def test7():Unit={
    val end=6
    for (i <- 0 to end){
      val y=end-i
      println(s"$i + $y = ${i+y}")
    }
  }
}
