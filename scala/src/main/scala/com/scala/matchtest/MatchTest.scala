package com.scala.matchtest

/**
 * 设置match
 */
object MatchTest {
  def main(args: Array[String]): Unit = {
    matchFor()
  }

  def easyTest(): Unit = {
    val oper = "#"
    val n1 = 20
    val n2 = 30
    var result = 0

    oper match {
      case "+" => result = n1 + n2
      case "-" => result = n1 - n2
      case "*" => result = n1 * n2
      case "/" => result = n1 / n2
      case "#" => println("#")
      case _ => println("error")
    }
    println(result)
  }

  def daemonMatch(): Unit = {
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        case _ if ch.toString.equals("3") => digit = 3
        case _ => sign = 2
      }
      println(ch + " " + sign + " " + digit)
    }

  }

  def varMatch(): Unit = {
    val char = 'w'
    char match {
      case myChar => println(myChar)
      case _ => println("error")
    }

  }

  def matchAny(): Unit = {
    // 类型匹配, obj 可能有如下的类型
    val a = 4
    val obj = if (a == 1) 1
    else if (a == 2) "2"
    else if (a == 3) BigInt(3)
    else if (a == 4) Map("aa" -> 1)
    else if (a == 5) Map(1 -> "aa")
    else if (a == 6) Array(1, 2, 3)
    else if (a == 7) Array("aa", 1)
    else if (a == 8) Array("aa")

    val result = obj match {
      case a: Int => a
      case b: Map[String, Int] => "对象是一个字符串-数字的Map集合"
      case c: Map[Int, String] => "对象是一个数字-字符串的Map集合"
      case d: Array[String] => "对象是一个字符串数组"
      case e: Array[Int] => "对象是一个数字数组"
      case f: BigInt => Int.MaxValue
      case _ => "啥也不是"
    }
    println(result)

  }

  /**
   * 匹配数组
   */
  def matchArray(): Unit = {
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val result = arr match {
        case Array(0) => "0"
        case Array(x, y) => x + "=" + y
        case Array(0, _*) => "以0开头和数组"
        case _ => "什么集合都不是"
      }
      println("result = " + result)
    }

  }

  def matchList(): Unit = {
    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" //
        case x :: y :: Nil => x + " " + y //
        case 0 :: tail => "0 ..." //
        case _ => "something else"
      }
      println(result)
    }
  }

  /**
   * 匹配元组
   */
  def matchTuple(): Unit = {

    for (pair <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2))) {
      val result = pair match { //
        case (0, _) => "0 ..." //
        case (y, 0) => y //
        case _ => "other" //.
      }
      println(result)
    }
  }

  def matchObject(): Unit = {
    object Square {
      def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

      def apply(z: Double): Double = z * z
    }
    val d: Double = Square(36)
    println(d)
    val number: Double = 36.0
    number match {
      case Square(n) => println(n)
      case _ => println("nothing matched")
    }
  }

  def matchManyParaObject(): Unit = {
    object Square {
      def unapplySeq(str: String): Option[Seq[String]] = {
        if (str.contains(",")) {
          Some(str.split(","))
        } else {
          None
        }
      }
    }

    val namesString="Alice,Bob,Thomas"
    namesString match {
      case Square(first,second,third) => println(s"$first  $second   $third")
      case _ => println("error")
    }
  }

  /**
   * 用于定义变量
   */
  def matchCase(): Unit ={
    val (x, y) = (1, 2)
    val (q, r) = BigInt(10) /% 3  //说明  q = BigInt(10) / 3 r = BigInt(10) % 3
    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr // 提出arr的前两个元素
    println(first, second)
  }

  /**
   * match用于for中的过滤
   */
  def matchFor(): Unit ={
    val map =Map("A"->1,"B" ->0,"C"->2)
    for((k,v) <- map){
      println(s"key=$k  value=$v")
    }
    println()

    for ((k,0) <-map){
      println(s"key=$k  ")

    }

    println()
    for((k,v) <- map if v==0){
      println(s"key=$k  value=$v")
    }
  }




}
