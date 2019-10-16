package com.scala.matchtest

object CaseMiddleExpression {

  def main(args: Array[String]): Unit = {
    matchCaseCase()
  }

  /**
   * 匹配列表
   */
  def matchList(): Unit = {
    List(1, 2, 3, 5) match {
      case first :: second :: rest => println(s"first:$first  second=$second  ${rest.length}")
      case _ => println("匹配不到")
    }
  }

  def matchCaseCase(): Unit = {
    abstract class Item // 项
    case class Book(description: String, price: Double) extends Item
    //Bundle 捆 ， discount: Double 折扣 ， item: Item* ,
    case class Bundle(description: String, discount: Double, item: Item*) extends Item

    val sale = Bundle("书籍", 10, Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))

    val res = sale match {
      case Bundle(_, _, Book(desc, _), _*) => desc
    }
    println(res)

    val result2=sale match {
      case Bundle(_,_,art @ Book(_,_),rest @ _*) => (art,rest)
    }
    println(result2)


    val result3=sale match {
      case Bundle(_,_,art @ Book(_,_),rest) => (art,rest)
    }
    println(result3)
  }

}
