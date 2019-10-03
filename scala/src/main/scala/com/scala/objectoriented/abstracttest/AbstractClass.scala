package com.scala.objectoriented.abstracttest

abstract class AbstractClass {
  val age:Int=10
  var name :String
}

class ExtendAb extends AbstractClass{
  override var name: String = "www"
}

object AbstractClass{
  def main(args: Array[String]): Unit = {

  }
}
