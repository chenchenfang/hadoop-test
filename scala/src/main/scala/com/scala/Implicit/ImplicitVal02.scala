package com.scala.Implicit

object ImplicitVal02 {
  def main(args: Array[String]): Unit = {
    // 隐式变量（值）
    implicit val name: String = "Scala"
    //implicit val name1: String = "World"

    def hello(implicit content: String = "jack"): Unit = {
      println("Hello " + content)
    } //调用hello
    hello
  }
}
//【案例演示+小结】
