package com.scala.objectadvanced

object KidsSum {
  var sum=0

  def main(args: Array[String]): Unit = {
    new KidsSum("chenchen")
    new KidsSum("fang")
    println(KidsSum.sum)
  }
}

class KidsSum(val name:String){
  KidsSum.sum+=1
}
