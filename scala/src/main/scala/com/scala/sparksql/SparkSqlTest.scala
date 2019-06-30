package com.scala.sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSqlTest {
  def main (args :Array[String]) : Unit ={
    val conf = new SparkConf().setAppName("sparkSqlTest").setMaster("local[*]")
    val session = SparkSession.builder().config(conf).getOrCreate()
    val df = session.read.json("D:\\sparkTest\\json.txt")
    df.show()

    df.createTempView("people")

    df.select("age").show()

    session.sql("select * from people").show()

  }
}
