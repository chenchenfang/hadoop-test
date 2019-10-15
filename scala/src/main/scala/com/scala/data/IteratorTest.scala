package com.scala.data

object IteratorTest {
  def main(args: Array[String]): Unit = {
    val ints = List[Int](1,2,3,4,5)
    for(i <- ints.iterator){
      println(i)
    }
  }
}
