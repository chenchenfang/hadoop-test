package com.scala.objectoriented.abstracttest

object Computer {
  def main(args: Array[String]): Unit = {
    val pc = new PC("i7","8G","1T","联想")
    println(pc.getDetails())
  }
}

abstract class Computer(InCpu:String,InRAM:String,InhardDesk:String){
  var cpu:String=InCpu
  var RAM:String=InRAM
  var hardDisk:String =InhardDesk

  def getDetails(): String ={
    return s"$cpu\t$RAM\t$hardDisk"

  }
}

class PC(InCpu:String,InRAM:String,InhardDesk:String,InBrand:String) extends Computer(InCpu ,InRAM,InhardDesk ){
  var brand:String=InBrand

  override def getDetails(): String = {
    return super.getDetails()+s"\t$brand"
  }
}
