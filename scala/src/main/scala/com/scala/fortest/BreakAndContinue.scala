package com.scala.fortest

import util.control.Breaks._

/**
 *替换掉了break以及continue的方法
 */
object BreakAndContinue {

  def main(args:Array[String]):Unit={
    printNum()

  }

  /**
   * 简单的测试
   */
  def easyTest():Unit={
    var n=10
    breakable{
      while (n<=20){
        n+=1
        if(n==18){
          break()
        }
      }
    }
    println(s"n=$n")
  }

  def printNum():Unit={

    breakable{
      var sum=0
      for (i <- 1 to 100){
        sum+=i
        if(sum>20){
          println(s"sum:$sum i=$i")
          break()
        }

      }
    }
  }
}
