package com.scala.fortest

/**
 * 打印
 * 金字塔
 */
object ForClassTest {

  def main(args: Array[String]): Unit = {
    printStar(5)
  }

  def printStar(lineNum:Int):Unit={
    val lastLineStars = 1+(lineNum-1)*2
    var start:Int = lastLineStars/2
    for (i <- 1 to lineNum){
      for (i <- 1 to start){
        print(" ")
      }

      if(i==1){
        println("*")
      }else{
        println("*"*(1+(i-1)*2))
      }
      start-=1
    }
  }
}
