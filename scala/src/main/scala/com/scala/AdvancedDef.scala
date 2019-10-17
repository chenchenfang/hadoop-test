package com.scala

object AdvancedDef {
  def main(args: Array[String]): Unit = {
    advancedDefReturnDef()
  }

  /**
   * 偏函数使用
   * 使用构建特质的实现类(使用的方式是PartialFunction的匿名子类)
   * PartialFunction 是个特质(看源码)
   * 构建偏函数时，参数形式   [Any, Int]是泛型，第一个表示参数类型，第二个表示返回参数
   * 当使用偏函数时，会遍历集合的所有元素，编译器执行流程时先执行isDefinedAt()如果为true ,就会执行 apply, 构建一个新的Int 对象返回
   * 执行isDefinedAt() 为false 就过滤掉这个元素，即不构建新的Int对象.
   * map函数不支持偏函数，因为map底层的机制就是所有循环遍历，无法过滤处理原来集合的元素
   * collect函数支持偏函数
   */
  def  partialDef(): Unit ={
    val list = List(1,2,3,"www")
    val result=list.collect(new PartialFunction[Any,Int] {
      override def isDefinedAt(x: Any): Boolean = {
        if(x.isInstanceOf[Int]) true else false
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int]+10
      }
    })
    println(result)
  }

  /**
   * 简化partial  case可以自动转化成partialfunction
   */
  def partialDefSimple1(): Unit ={
    val list = List(1,2,3,"www")
    def f1():PartialFunction[Any,Int]={
      case i:Int =>i+1
    }
    list.collect(f1())
  }

  /**
   * 再次化简 直接使用 case来过滤
   */
  def partialDefSimple2(): Unit ={
    val list = List(1,2,3,4,"www")
    val ints = list.collect{case i:Int =>i+100}
    println(ints)
  }

  /**
   * 匿名的方法
   */
  def  anonymityDef(): Unit ={
    val doubleToDouble =  (x:Double) => x*x
    println(doubleToDouble(10.0))
  }

  /**
   * 高阶函数
   */
  def advancedDef(): Unit ={
    def test(f1:Double =>Double ,n1:Double): Unit ={
      f1(n1)
    }

    def sum(double: Double): Double ={
      double+10
    }
    val unit = test(sum,10)
    println(unit)
  }

  def advancedDefReturnDef(): Unit ={
    def test(x:Double) ={
      (y:Double) => y+x
    }

    val d = test(10.0)(20.0)
    println(d)
  }


}
