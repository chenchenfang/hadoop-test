package com.scala.data.structure

import scala.collection.mutable.ListBuffer

object MyList {
  def main(args: Array[String]): Unit = {
    mutableList()
  }

  def immutableList(): Unit ={
    //不可变list
    val ints = List(1,2,3)
    println(ints)

    val nil = Nil
    println(nil)

    val intList2 = ints :+ 5
    val list3 = 100 +: ints
    println(intList2)
    println(list3)
    println(ints)

    //向集合中添加数据 最后边一个必须是list
    val list = 3 :: 4 :: 5:: list3
    println(list)
    //以下等价上边
    val ints1 = 3 :: 4 :: 5:: list3 ::: Nil
    println(ints1)
  }

  def mutableList(): Unit ={
    val strings = new ListBuffer[String]()

    strings.append("wiwi","rrr","wqq")
    strings+="34"
    strings.append("486")
    println(strings)

    val strings1 = strings:+"546"
    println(strings1)

    strings++=strings
    println(strings)

    strings.remove(0)
    println(strings)
  }

}
