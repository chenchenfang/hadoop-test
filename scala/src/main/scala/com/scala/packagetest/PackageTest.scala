package com.chenchenfang.packtest {

  //包对象
  package  object sonpackage{
    var chencheng :String ="chenchen"

    def sayHello():Unit={
      println("黑喂狗")
    }
  }


  package sonpackage {
    //声明一个类
    class Persion() {
      var name: String = _

      def talk(): Unit = {
        println("i am your friend")
      }
    }

    object Persion {
      def main(args: Array[String]): Unit = {
        //类的使用
        val persion = new Persion
        persion.name = "wowoow"
        println(s"persion.name=${persion.name}")

        //包对象的使用
        sayHello()
        println(chencheng)
        chencheng="fang"
        println(chencheng)

      }
    }

  }


}

