package com.scala.data


object AdvanceDefExpansion {
  def main(args: Array[String]): Unit = {
    listZip()
  }

  /**
   * 两个list合并成1个list
   */
  def listZip(): Unit ={
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    val tuples = list1.zip(list2)
    println(tuples)
  }


}
