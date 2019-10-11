package com.scala.data.structure

import scala.collection.mutable.Queue

object MyQueue {

  def main(args: Array[String]): Unit = {
    mutable()
  }

  def mutable(): Unit ={
    val ints = new  Queue[Int]
    //进队列 出队列
    ints.enqueue(1,2,3,4,5)
    val i = ints.dequeue()
    println(i)
    println(ints)

    ints +=100
    println(ints)


  }
}
