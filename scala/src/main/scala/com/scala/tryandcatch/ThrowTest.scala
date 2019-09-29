package com.scala.tryandcatch

object ThrowTest {
  def main(args:Array[String]):Unit ={

    /*val unit = test()
    println(unit.toString)*/


    throwsTest()
    /*try {
      throwsTest()
    } catch {
      case ex : Exception => println("报错")
    } finally {}*/
  }

  def test(): Unit ={
    throw new Exception("不对")
  }

  @throws(classOf[NumberFormatException])
  def throwsTest(): Unit ={
    "abc".toInt
  }

}
