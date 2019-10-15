package com.scala.data

import scala.collection.mutable

/**
课后练习3-大数据中经典的wordcount案例
val lines = List("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")
使用映射集合，list中，各个单词出现的次数，并按出现次数排序

 */
object WordCount {
  def main(args: Array[String]): Unit = {
    test()
  }
  def myWordCount(): Unit ={
    val strings = List[String]("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")
    val list = strings.flatMap(a =>a.split(" "))

    def addWord(map: mutable.Map[String,Int],string: String): mutable.Map[String,Int] ={
      map + (string->(map.getOrElse(string,0)+1))
    }
    val stringToInt = list.foldLeft(mutable.Map[String,Int]())(addWord)
    stringToInt.foreach(x => println(x._1+"  "+x._2))
  }


  def test(): Unit ={
    val lines = List("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")

    val res1 = lines.flatMap(_.split(" "))
    println("res1=" + res1)
    // res1.map 说明
    //1. 使用map，返回对偶元组 形式为
    //List((hello,1), (tom,1), (hello,1), (jerry,1), (hello,1), (jerry,1), (hello,1), (kitty,1))
    val res2 = res1.map((_, 1))
    println("res2=" + res2)
    // res2.groupBy(_._1)
    //1. 分组的根据是以元素来分组
    //2. _._1 中的第一个 _ 表示取出的各个对偶元组比如 (hello,1)
    //3. _._1 中的_1, 表示对偶元组的第一个元素，比如 hello
    //4. 因此 _._1 表示我们分组的标准是按照对偶元组的第一个元素进行分组
    //5. 返回的形式为 Map(tom -> List((tom,1)), kitty -> List((kitty,1)), jerry -> List((jerry,1), (jerry,1)), hello -> List((hello,1), (hello,1), (hello,1), (hello,1)))
    val res3 = res2.groupBy(_._1)
    println("res3=" + res3)

    // x=>(x._1, x._2.size) 传入一个匿名函数，完成统计
    //1.x 表示传入的Map中的各个元素，比如 jerry -> List((jerry,1), (jerry,1))
    //2.x._1 表示 jerry
    //3.x._2.size，表示对 List((jerry,1), (jerry,1))求size,是多少就是多少
    //4.结果是 res4=Map(han -> 2, atguigu -> 2, hello -> 1)
    //5.到此结果就出来了，但是没有排序
    val res4 = res3.map(x=>(x._1, x._2.size))
    println("res4=" + res4 )

    // res4.toList.sortBy(_._2)
    //1. toList先将map转成 list,为了下一步排序
    //5. sortBy就是排序,以对偶元组的第二个值排序，就是大小排序
    println("res4.5=" + res4.toList)
    val res5 = res4.toList.sortBy(_._2)
    println("res5=" + res5)

    //如果希望从大到小排序，执行reverse即可
    val res6 = res5.reverse
    println("res6="+res6)

  }
}
