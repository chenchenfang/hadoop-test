package com.scala.basis
/**
  * 强制类型转换
 */
object ForcedTypeConversion {
   def main (aegs :Array[String]) : Unit = {
     var short :Short =10
     var byte : Byte =4
     short=(short-2).toShort
     val d :Double = (short-2).toDouble
     println(d)
   }
}
