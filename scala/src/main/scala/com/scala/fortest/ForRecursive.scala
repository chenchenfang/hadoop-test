package com.scala.fortest

/**
 * 动态规划实现打印
 */
object ForRecursive {

  var intArray :Array[Int] =new Array[Int](100)


  def main(args: Array[String]): Unit = {
    val i = getStarts(5)
    println(i)
  }

  def printStar(star:Int): Unit ={


  }

  def getStarts(num:Int): Int ={
    if(intArray(num-1)==0){
      if(num==1){
        intArray(num-1)=1
        return 1
      }else{
        getStarts(num-1)
        intArray(num-1)=intArray(num-2)+2
        return intArray(num-1)
      }
    }else {
      return intArray(num-1)
    }

  }
}
