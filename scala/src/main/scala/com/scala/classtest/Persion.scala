package com.scala.classtest

object Persion {

  def main(args: Array[String]): Unit = {
    val persion:Persion = new Persion("ziang",12)
    persion.name="www"
      println(persion)
  }

}

class Persion(nameIn:String, ageIn:Int){
  var name:String=nameIn
  var age :Int=ageIn
  var address:String=_



  override def toString: String = {
    name+" "+age+" "+address
  }
}