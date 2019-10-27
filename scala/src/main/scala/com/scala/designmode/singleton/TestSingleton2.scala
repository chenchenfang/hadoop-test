package com.scala.designmode.singleton

/**
 * 饿汉式
 * 出来直接 初始化 成员变量
 */
object TestSingleton2 extends  App {
  private val singleton: Singleton2 = Singleton2.getSingleton2
  private val singleton1: Singleton2 = Singleton2.getSingleton2
  println(singleton.hashCode())
  println(singleton1.hashCode())

}

class Singleton2 private(){

}

object Singleton2{
  //直接初始化
  private val singleton=new Singleton2()
  def getSingleton2: Singleton2 ={
    singleton
  }
}