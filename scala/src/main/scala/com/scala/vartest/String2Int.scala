package com.scala.vartest

object String2Int {
  def main(args: Array[String]): Unit = {

    var str1: String ="12.5"
    //这个会报错
    println(str1.toInt)
    //这个不会报错
    println(math.round(str1.toDouble))
  }
}
