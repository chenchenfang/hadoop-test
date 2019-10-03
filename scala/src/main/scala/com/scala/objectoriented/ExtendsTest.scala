package com.scala.objectoriented

object ExtendsTest {
  def main(args: Array[String]): Unit = {
    val b = new B
    println(b.sal)
  }


}

//以下是错误的不能继承一个var的变量
/*
class AAAA {
  var name: String = ""
}
class BBBB extends AAAA {
  override  val name: String = "jj"
}*/

class A {
  def sal(): Int = {
    return 10
  }}

class B extends A {
  override val sal : Int = 0
}
