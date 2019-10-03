package com.scala.objectadvanced

/**
 * apply的使用
 */
object Pig {

  def apply(name:String,age:Int): Pig = new Pig(name,10)

  def main(args: Array[String]): Unit = {
    val pig = Pig("佩奇",10)
    println(pig.age)
  }
}

class Pig(inName:String,inAge:Int){
  var name:String=inName
  var age:Int=inAge


}