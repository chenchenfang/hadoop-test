package com.scala.objectoriented

/**
 * 测试 isInstanceOf 以及asInstanceOf  classOf
 */
object InstanceOfTest {
  def main(args: Array[String]): Unit = {

    //获取String.class
    val unit = classOf[String]
    println(unit)

    //是不是属于这个类型
    val s:String="ww"
    println(s.isInstanceOf[String])

    //强制类型转换
    var facher = new Facher("chenchen")
    //调用父类主构造器
    var son = new Son("fang")

    facher=son
    println(facher.name)

    println(facher.asInstanceOf[Son].name)




  }
}

class Facher(var myname:String) {
  val name:String="father"

}

class Son(studentName: String) extends Facher(studentName ){
  override val name:String="son"
}
