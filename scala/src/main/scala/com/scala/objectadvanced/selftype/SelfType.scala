package com.scala.objectadvanced.selftype

/**
 * 自身类型
 * (解决类的循环继承问题, 要求必须继承了某个类或者特质才可以继承当前特质)
 */
object SelfType {

  def main(args: Array[String]): Unit = {
    val log = new Log
    println( log.getMessage)
  }
}

trait MyException {
  //声明当前特质是Exception的扩展 只有继承了Exception才可以使用这个特质
  //相当于 trait MyException extends Exception
  this :Exception =>

  override def getMessage: String = {
    "有报错!!!"
  }
}

//继承了 exception 再继承 MyException
class Log extends Exception  with MyException  {

}
