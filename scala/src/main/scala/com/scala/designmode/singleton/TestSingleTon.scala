package com.scala.designmode.singleton

/**
 * 单例模式
 * 懒汉式
 */
object TestSingleTon extends App {
  val singleTon = SingleTon.getInstance
  val singleTon2 = SingleTon.getInstance
  println(singleTon.hashCode() + " " + singleTon2.hashCode())
}

//将SingleTon的构造方法私有化
class SingleTon private() {}

object SingleTon {
  private var s: SingleTon = _

  def getInstance: SingleTon = {
    if (s == null) {
      s = new SingleTon
    }
    s
  }
}
