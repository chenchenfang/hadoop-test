package com.scala.objectadvanced

object FuTrait {

  def main(args: Array[String]): Unit = {
    val son = new MySon
    println(son.name)
  }
}


trait MyFather{
  var name:String ="我哦我"

}

class MySon extends MyFather {

  def cry(): Unit ={
    println("i will cry")
  }
}