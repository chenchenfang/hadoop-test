package com.scala

import org.apache.spark.{SparkConf, SparkContext}

object CountWord {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")

    val context = new SparkContext(conf)

    val lines = context.textFile("D:\\spark.txt")

    val words = lines.flatMap(_.split(" "))


    val k2v = words.map((_,1))

    val result = k2v.reduceByKey(_ + _)

    result.foreach(println)

    context.stop()
  }
}
