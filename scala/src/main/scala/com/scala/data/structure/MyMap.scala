package com.scala.data.structure

object MyMap {
  def main(args: Array[String]): Unit = {
    mutableMap()
  }

  /**
   * 不可变的数组
   */
  def immutableMap(): Unit ={
    import scala.collection.immutable
    val stringToInt = immutable.HashMap("alice"->100)
    for((key,value) <- stringToInt){
      println(key+"   "+value)
    }
    for (s <-stringToInt){
      println(s)
    }
  }

  def mutableMap(): Unit ={
    //声明
    import scala.collection.mutable
    val tuplesToStringToInt = new  mutable.HashMap[String,Int]

    tuplesToStringToInt += ("ann"->123)
    tuplesToStringToInt += (("bnn"->231),("cnn" ->432))
    //遍历
    for((key,value) <- tuplesToStringToInt){
      println(s"$key  $value")
    }
    //查看包含以及获取值
    if(tuplesToStringToInt.contains("ann")){
      //这个方法不推荐使用
      println(tuplesToStringToInt.get("ann").get)
      println(tuplesToStringToInt("ann"))
      //修改key对应的值
      tuplesToStringToInt("ann") =10000
      //删除key
      tuplesToStringToInt.remove("ann")
    }
    //带有默认值的获取
    println(tuplesToStringToInt.getOrElse("dnn","google"))

    //遍历
    for((key,value) <- tuplesToStringToInt){
      println(s"$key  $value")
    }



  }
}
