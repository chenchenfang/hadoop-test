package com.scala.viewbounds

/**
 * 上下文语法糖
 */
object ContextBounds{
  def main(args: Array[String]): Unit = {
    //使用隐式参数
    implicit  val personComparetor: Ordering[Person] =new Ordering[Person]{
      def compare(p1:Person,p2:Person):Int={
        p1.age-p2.age
      }
    }

    val unit = new CompareComm[Person](new Person("zizi",100),new Person("aa",200))
    println(unit.geatter)
  }
}

//对比两个person
class CompareComm[T:Ordering](o1:T,o2:T){
  def geatter: T ={
    //获取有Ordering[T]类型的 隐式参数 并使用 语法糖
    val value = implicitly[Ordering[T]]
    if(value.compare(o1,o2)>0) o1 else o2

  }
}

//一个普通的Person类
class Person(val name: String, val age: Int) {
  override def toString: String = this.name + "\t" + this.age
}

