package com.scala.fortest

/**
 * 暂时的结论是 能用for用for
 * while能不用就不用
 */
object WhileTest {
  def main(args:Array[String]):Unit={
    test2()
  }

  def test1():Unit={
    var i :Int=5
    while (i>0){

      println("wowoow")

      i-=1
    }
  }

  def test2():Unit={

    var i=1
    while(i<=100){
      if(i%3==0){
        println(i)
      }

      i+=1
    }
  }


}
