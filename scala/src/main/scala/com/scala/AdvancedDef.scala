package com.scala

object AdvancedDef {
  def main(args: Array[String]): Unit = {
    abstractControl()
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
    def test(x:Double):Double =>Double ={
      (y:Double) => y+x
    }

    val d = test(10.0)(20.0)
    println(d)
  }

  def advanceDefParagem(): Unit ={
    val ints = List(1,2,3)
    println(ints.map(_+1))
    println(ints.reduce(_+_))
  }

  def advanceDefMakeSuffix(): Unit ={
    def makeSuffix(suffix:String) ={
      (fileName:String) => fileName.endsWith(suffix)
    }
    val stringToBoolean = makeSuffix("jpg")
    println(stringToBoolean("fileName.jpg"))
  }

  /**
   * 函数柯里化
   * 一个函数可以传入多个参数 现在把他们拆成多个函数 每个函数传入一个参数
   *
   */
  def advanceDefTestEq(): Unit ={
    //这个是闭包
    def mulCurry(x:Int) ={
      (y:Int) => (x+1)*y
    }
    val intToInt = mulCurry(4)
    val i = intToInt(100)
    println(i)



    implicit class TestString(str1: String){
      def checkString(str2: String)(equalFunction: (String,Int)=>Boolean): Boolean ={
        equalFunction(str1.toString,str2.toInt)
      }
    }

    val functionToUnit = "200".checkString("200")(_.contains("200")&&_.toString.contains("200"))
    println(functionToUnit)
  }

  /**
   * 抽象控制
   * 参数是一个函数
   * 函数没有参数与返回值
   * 比如 breakable
   */
  def abstractControl(): Unit ={
    /**
     * 传入一个函数 然后开一个线程去跑
     * mainDef: ()=>Unit  参数也可以这么写 但是不是缩写
     * @param mainDef
     */
    def runThread(mainDef: =>Unit): Unit ={
      new Thread(){
        override def run(): Unit = {
          mainDef
        }
      }.start()
    }

    //直接在里边填写函数
    //当缩写后,就不需要有 () =>
    runThread{
      println("wowowo")
        println("woyoulaila")
    }

  }
}
