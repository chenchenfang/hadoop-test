package com.scala.data
import scala.collection.parallel.CollectionConverters._
/**
 * 异步计算
 */
object ParallelTest {
  def main(args: Array[String]): Unit = {
    (1 to 5).foreach(println(_))
    println()
    (1 to 5).par.foreach(println(_))

    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}
    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}
    println(result1)
    println(result2)

  }

}
