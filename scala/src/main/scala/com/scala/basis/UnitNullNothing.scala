package com.scala.basis

object UnitNullNothing {
  def main(args: Array[String]): Unit = {
    var test = new MyTest
    test = null
    println(test)

    println(returnUnit())

    returnNothing()



  }


  def returnNothing():Nothing={
    throw new Exception("我来抛异常了 ")
  }
  def returnUnit(): Unit = {

  }
}


class MyTest {
  var mm: Int = 1
}
