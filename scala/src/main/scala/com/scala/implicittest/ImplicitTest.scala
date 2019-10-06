package com.scala.implicittest

object ImplicitTest {
  def main(args: Array[String]): Unit = {
    //隐式转换 声明
    implicit def f1(double: Double): Int ={
      double.toInt
    }
    var doubleToInt:Int=3.5
    println(doubleToInt)

    //给类添加新的功能而不修改源代码
    implicit def f2(mysql: Mysql): DB ={
      new DB()
    }
    val mysql = new Mysql
    mysql.delete()

    //隐式值
    implicit val string:String="String"
    mysql.insert

    //隐式类
    implicit class Oracle( mysql: Mysql){
      def update(): Unit ={
        println("update")
      }
    }
    //调用隐式类中的方法
    mysql.update()


  }

}

class Mysql {

  def insert(implicit tableName:String): Unit ={
    println(tableName)
  }
}

class DB {
  def delete(): Unit ={
    println("delete")
  }
}