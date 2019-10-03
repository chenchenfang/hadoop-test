package com.scala.objectadvanced

/**
 * 叠加特质的具体使用
 */
trait Operate {

  def insert():Unit

}

trait Data extends Operate {
  println("data")
  override def insert(): Unit = {
    println("data insert")

  }
}

trait  DB extends Data{
  println("db")

  override def insert(): Unit = {
    println("db insert")
    super.insert()
  }
}

trait File extends Data{
  println("File")

  override def insert(): Unit = {
    println("file insert")
    super.insert()
  }
}

class Mysql{

}

object File{
  def main(args: Array[String]): Unit = {
    val mysql = new Mysql() with DB with File
    mysql.insert()

    println()
    val mysql1 = new Mysql with File with DB
    mysql1.insert()
  }
}
