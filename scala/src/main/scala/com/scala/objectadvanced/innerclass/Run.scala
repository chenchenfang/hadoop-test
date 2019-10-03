package com.scala.objectadvanced.innerclass

object Run {
  def main(args: Array[String]): Unit = {
    val clazz = new ScalaOuterClass3
    val clazz2 = new ScalaOuterClass3

    val innerClass = new clazz.ScalaInnerClass3
    val innerClass2 = new clazz2.ScalaInnerClass3

    innerClass.test(innerClass)
    //可以传递其他外部类对象创建的内部类对象
    innerClass.test(innerClass2)
  }
}

/**
 * 里边包含了一个内部类
 */
class ScalaOuterClass3 {
  myOuter =>
  class ScalaInnerClass3 { //成员内部类
    //类型投影表示当前参数 忽略内部类外部类对象之前的关系 从而和java中一样
    def test(ic: ScalaOuterClass3#ScalaInnerClass3): Unit = {
      System.out.println(ic)
    }
  }
}


