package com.scala.data

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * 高级函数使用
 * map flatmap filter
 */
object AdvancedDef {

  def main(args: Array[String]): Unit = {
    test()
  }

  /**
   * map函数的使用
   */
  def listMap(): Unit ={
    val ints = new ListBuffer[Int]
    ints.append(1, 2, 3, 45)
    def f1(int: Int):Int={
      int+2
    }
    val ints1 = ints.map( x => x+2)

    val ints2 = ints.map(f1)
    println(ints1)
    println(ints2)
  }

  /**
   * flatMap  把一个值改为多个值 然后放到一个集合中
   */
  def listFlatMap(): Unit ={
    val ints = new ListBuffer[Int]
    ints.append(1,2,3,5)
    def getInts(int: Int): List[Int] ={
      val out = new ListBuffer[Int]
      out.append(int*10)
      out.append(int*12)
      out.append(int*13)
      out.append(int*14)

      out.toList
    }
    val ints1 = ints.flatMap(getInts)
    ints1.foreach(println)
  }

  def listFilter(): Unit ={
    val ints = new ListBuffer[Int]
    ints.append(1,2,3,4,5)

    val ints1 = ints.filter(x => x==1)
    ints1.foreach(println)


  }


  def listReduceLeft(): Unit ={
    val intsToInts = ListBuffer[Int](1,2,3,4,5)

    val i = intsToInts.reduceLeft((a,b) => a-b)
    println(i)
    val i1 = intsToInts.reduceRight((a,b) => a-b)
    println(i1)
    val i2 = intsToInts.reduce((a,b) => a-b)
    println(i2)

    //可以加初始值的计算
    val i3 = intsToInts.foldLeft(5)((a,b) => a-b)
    println(i3)
    //这个是上边的简化版
    val functionToInt = (5 /: intsToInts)((a,b) => a-b)
    println(functionToInt)
  }

  def listScanLeft(): Unit ={
    def minus( num1 : Int, num2 : Int ) : Int = {
      num1 - num2
    }
    //5 (1,2,3,4,5) =>(5,4,2,-1,-5,-10)
    val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
    println(i8)

  }

  def test(): Unit ={

    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    def charCount(map:mutable.Map[Char,Int],char: Char): mutable.Map[Char,Int] ={
      map + (char -> (map.getOrElse(char,0)+1))
    }
    val charToInt = sentence.foldLeft(mutable.Map[Char,Int]())(charCount)
    charToInt.foreach( x => println(x._1+"  "+x._2))

  }


  def advancedTest(): Unit ={

    def operateDouble(f1: Double => Double,myDouble :Double): Double ={
      f1(myDouble)
    }

    def add(double: Double): Double ={
      double+100
    }

    val d = operateDouble(add,200.00)
    println(d)
  }
}
