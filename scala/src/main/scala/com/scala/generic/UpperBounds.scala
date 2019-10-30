package com.scala.generic

/**
 * 泛型的上界
 * 简单的测试
 */
object UpperBounds {
  def main(args: Array[String]): Unit = {
    val greater = new CompareComm[Integer](100,209).greater
    println(greater)

    val greater1 = new CompareComm[java.lang.Double](100.1,100.1).greater
    println(greater1)
  }
}

class CompareComm[T <: Comparable[T]](arg1:T,arg2:T){
  def greater: Boolean =arg1.equals(arg2)
}