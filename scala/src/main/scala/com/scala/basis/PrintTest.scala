package com.scala.basis

object PrintTest {
  def main ( args :Array[String]) : Unit = {
    var int1 : Int = 1
    var int2 : Int = 2
    var str : String = "字符串呦"
    println(int1+int2)

    printf("int1=%d,int2=%d \n",int1,int2)
    println(s"int1+int2=${int1+int2},srt=$str")

  }
}
