package com.scala.viewbounds

/**
 * 视图界定 的简单使用
 * 已经废弃了
 *
 */
object TestViewBounds {
  def main(args: Array[String]): Unit = {
    implicit def person2OrderedPerson(person: Person): Ordered[Person] = {
      new Ordered[Person] {
        override def compare(that: Person): Int = {
          person.age - that.age
        }
      }
    }

    val geater = new CompareCommon(new Person("ziang",23),new Person("chhc",22)).geater
    println(geater)

  }
}

class Person(val name: String, val age: Int) {

  override def toString = s"Person($name, $age)"
}

class CompareCommon[T](obj1: T, obj2: T)(implicit ev$1: T => Ordered[T]) {
  def geater: T = if (obj1 > obj2) obj1 else obj2
}