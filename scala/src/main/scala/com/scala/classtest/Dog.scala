package com.scala.classtest

import scala.beans.BeanProperty

object Dog {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("wowoow", 12)
    dog.name = "fff"

    dog.setDead("wowow")

    println(s"dog.name=${dog.name}")


    val cat = new Cat("catName", 22)

    //以下报错
    //cat.name="newCatName"
  }

}


class Dog() {

  var name: String = "gougou"
  var age: Int = 33

  @BeanProperty var dead: String = "dead"

  def this(name: String, age: Int) {
    this()
    this.name = name
    this.age = age
  }

  def say(): Unit = {
    println("say")
  }
}

class Cat(val name: String, val age: Int) {

  def say(): Unit = {
    println("cat:say")
  }
}
