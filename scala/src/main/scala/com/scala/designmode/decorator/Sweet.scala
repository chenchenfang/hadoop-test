package com.scala.designmode.decorator

/**
 * 装饰器模式
 * 通过继承同一个父类 装饰器的类中再添加一个被装饰的类对象 从而实现装饰的作用
 * new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream( "io.txt" )));
 */
object Sweet {
  def main(args: Array[String]): Unit = {
    val cake = new Cake
    val decorator = new FruitDecorator(cake)
    val decorator1 = new CandleDecorator(decorator)
    println(decorator1.cost)
  }
}

/**
 * 蛋糕和装饰器的父类
 */
trait Sweet {
  var desc: String = _

  def description()

  def cost: Double
}

class Cake extends Sweet {

  override def description(): Unit = {
    desc = "蛋糕"

  }

  override def cost: Double = {
    60
  }

}

/**
 * 装饰器
 */
trait Decorator extends Sweet {}

/**
 * 具体的装饰器
 * @param sweet
 */
class FruitDecorator(sweet: Sweet) extends Decorator {

  override def description(): Unit = {
    desc = "水果加钱"
  }


  override def cost: Double = 10 + sweet.cost
}

class CandleDecorator(sweet: Sweet) extends Decorator {
  override def description(): Unit = {
    desc = "蜡烛加钱"
  }

  override def cost: Double = 20 + sweet.cost
}