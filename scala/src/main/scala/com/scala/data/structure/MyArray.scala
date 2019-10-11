package com.scala.data.structure

import scala.collection.mutable.ArrayBuffer

/**
 * 定长数组与变长数组
 *
 */
object MyArray {
  def main(args: Array[String]): Unit = {
    scalaArrayToJavaArray()

  }

  /**
   * 定长数组
   */
  def immutableArray():Unit={
    //第一种定义数组方式
    val strings:Array[String] = new Array[String](10)
    strings(1)="wowowo"
    strings.foreach( x => println(x))

    println()

    //第二种定义数组方式
    val array = Array(1,2,"www")
    for(i <- array){
      println(i)
    }
  }

  /**
   * 变长数组
   */
  def mutableArray():Unit={
    val buffer = ArrayBuffer[Any](3,2,5)
    buffer.append(44)
    for(i <- buffer){
      println(i)
    }
    println(buffer.length)
    println(buffer.hashCode())
    println()
    //修改
    buffer(0)=100
    buffer.foreach( x => println(x))
    println()
    //删除
    buffer.remove(0)
    buffer.foreach( x => println(x))
  }

  /**
   * 变长数组转化成定长数组
   */
  def immutableToMutable(): Unit ={

    val strings = ArrayBuffer[String]()
    strings.append("www","eee","rrr")
    println(strings)

    val array = strings.toArray
    println(array)
  }

  /**
   * 对维数组的定义与使用
   */
  def twoArray(): Unit ={
    val array = Array.ofDim[Int](3,4)

    array(0)(0)=1
    array.foreach(x => {
      x.foreach(y => print(y+" "))
      println()
    })
  }

  /**
   * ArrayBuffer javalist
   * 之间的相互转换
   */
  def scalaArrayToJavaArray(): Unit ={
    val ints = ArrayBuffer[Int]()
    ints.append(1,2,4)
    import scala.collection.JavaConverters

    val arrayList = JavaConverters.bufferAsJavaList(ints)
    println(arrayList)
    val arrayBuffer = JavaConverters.asScalaBuffer(arrayList)
    println(arrayBuffer)
  }

}
