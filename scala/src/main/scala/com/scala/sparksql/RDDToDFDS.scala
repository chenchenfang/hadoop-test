package com.scala.sparksql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession


object RDDToDFDS {
  def main(args : Array[String]) : Unit ={
    val conf = new SparkConf().setAppName("RDDToDFDS").setMaster("local[*]")

    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._


    val rdd = spark.sparkContext.textFile("D:\\sparkTest\\people.txt")

    val res1=rdd.map(x => {
      val strings = x.split(":")
      (strings(0),strings(1))
    }).toDF("name","age")

    res1.show()








  }
}
