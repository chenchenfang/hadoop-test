package com.scala.vartest

object String2Int {
  def main(args: Array[String]): Unit = {
    //这个会报错
    var str1: String ="12.5";
    println(math.round(str1.toDouble))
  }
}
