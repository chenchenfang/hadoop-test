package com.scala.designmode.observer

import scala.collection.mutable.ArrayBuffer

object Observer {

  def main(args: Array[String]): Unit = {
    val observer = new ConcreteObserver("陈狗子")
    val observer2 = new ConcreteObserver("陈呵呵")
    val observer3 = new ConcreteObserver("陈翔")
    val subject = new ConcreteSubject
    subject.addObserver(observer)
    subject.addObserver(observer2)
    subject.addObserver(observer3)

    subject.notify("我更新pixiv了!")
  }
}

/**
 * 观察者
 */
trait Observer{
  def update(massage:String): Unit
}

/**
 * 具体的观察者
 */
class ConcreteObserver(name: String) extends  Observer {
  override def update(massage: String): Unit = {
    println(name+"   "+massage)
  }
}

/**
 * 被观察者
 */
trait Subject{
  def addObserver(observer: Observer)
  def removeObserver(observer: Observer)
  def notify(string: String)
}

/**
 * 具体被观察者
 */
class ConcreteSubject extends Subject {
  private val observers = new ArrayBuffer[Observer]()
  override def addObserver(observer: Observer): Unit = {
    observers +=observer
  }

  override def removeObserver(observer: Observer): Unit ={
    observers -=observer
  }

  override def notify(string: String): Unit = {
    observers.foreach(_.update(string))
  }
}


