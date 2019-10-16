package com.scala.matchtest

/**
 * 样例类
 * 提供了 apply和unapply
 * 构造器每个参数都是val
 * 自动生成了 toString equals hashCode copy方法
 *
 */
object MatchCaseObjectTest {

  /**
   * match 用来提取 类中的参数
   * @param args
   */
  def main(args: Array[String]): Unit = {
    matchCopy()
  }
  def matchCaseObject(): Unit ={
    for(amt <- Array(Dollar(1000.0),Currency(200.0,"RMB"),NoAmount)){
      val result= amt match {
        case Dollar(v) => "$"+v
        case Currency(v,u) => v + " "+ u
        case NoAmount =>"空"
      }
      println(result)
    }
  }

  def matchCopy(): Unit ={
    val currency = Currency(200.0,"人民币")
    val currency1 = currency.copy(value = 300.0)
    val currency2 = currency.copy(unit = "英镑")

    println(currency)
    println(currency1)
    println(currency2)
  }
}

/**
 * sealed 使得子类不能再别处定义  只能在当前的源文件中
 */
abstract sealed class Amount{}

case class Dollar(value:Double) extends Amount{}

case class Currency(value:Double,unit:String) extends Amount{}

case object NoAmount extends Amount{}
