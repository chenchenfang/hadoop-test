package com.scala.objectadvanced

object AbstractOverride {

  def main(args: Array[String]): Unit = {
    val cat = new PigAndCat with Cat with Pig10
    cat.cry()
  }
}

trait Animal {
  def cry()
}


trait Pig10 extends Animal {
  abstract override def cry(): Unit = {
    println("pig cry")
    super.cry()
  }
}

trait Cat extends Animal{
  override def cry(): Unit ={
    println("cat cry")
  }
}

class PigAndCat{

}