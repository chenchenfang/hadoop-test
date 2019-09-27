package com.scala.deftest

object LazyDef {

  def main(args:Array[String]):Unit={
    lazy val res=sum(10,20)
    println("-----------")
    println(s"res=$res")
  }

  def sum(args:Int*) :Unit={
    args.foreach(myInt =>{
      println(myInt)
    })
    for (i <- 0 until args.size){
      println(args(i))
    }

  }
}
