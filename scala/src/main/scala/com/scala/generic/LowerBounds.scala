package com.scala.generic

/**
 * 下界 如果是 泛型的子类 则按泛型传入
 * 如果是 泛型的父类 则按泛型的父类传入
 * 如果是 没有关系的类 那么就按Object传入
 */
object LowerBounds {
  def main(args: Array[String]): Unit = {

   biophony(Seq(new Bird,new Bird,new Moon)).foreach(x => println(x.toString))
   biophony(Seq(new Bird,new Bird)).foreach(_.sound())

  }

  def biophony[T >: Animal](seq: Seq[T]): Seq[T] =seq
}



class Earth { //Earth 类
  def sound(){ //方法
    println("hello !")
  }
}
class Animal extends Earth{
  override def sound(): Unit ={ //重写了Earth的方法sound()
    println("animal sound")
  }
}
class Bird extends Animal{
  override def sound(): Unit ={ //将Animal的方法重写
    println("bird sounds")
  }
}
class Moon {}
