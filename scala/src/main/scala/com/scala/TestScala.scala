package com.scala

import org.apache.spark.{SparkConf, SparkContext}

object TestScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TestScala").setMaster("local[*]")

    val sc = new SparkContext(conf)

   /* val arr = sc.makeRDD(Array(1,2,3,4,5,6))
    //map的使用
    val unit = arr.map(_+1)

    arr.mapPartitions()

    unit.foreach(println)*/

      val unit = sc.parallelize(Array(1,3,4,6,7))
    val rdd = unit.mapPartitions(x => Iterator(x.mkString("|")))

    rdd.foreach(println)

  }
}
