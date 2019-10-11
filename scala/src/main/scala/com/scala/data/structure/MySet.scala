package com.scala.data.structure


object MySet {

  def main(args: Array[String]): Unit = {
    mutableSet()
  }

  def immutable(): Unit ={
    val ints = Set(1,2,3)
    for(i <- ints){
      println(i)
    }
  }

  /**
   * 可变set
   */
  def mutableSet(): Unit ={
    import scala.collection.mutable.Set
    val set =Set[Int]()
    set.add(100)
    set.add(200)
    set.add(250)
    set.add(50)
    for(i <-set){
      println(i)
    }


  }
}
