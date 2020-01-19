package com.scala.viewbounds

/**
 * 视图界定 的简单使用
 * 已经废弃了
 *
 */
object TestViewBounds {
  def main(args: Array[String]): Unit = {
    implicit def person2OrderedPerson(person: PersonNew): Ordered[PersonNew] = {
      new Ordered[PersonNew] {
        override def compare(that: PersonNew): Int = {
          person.age - that.age
        }
      }
    }

    val geater = new CompareCommon(new PersonNew("ziang",23),new PersonNew("chhc",22)).geater
    println(geater)

  }
}

class PersonNew(val name: String, val age: Int) {

  override def toString = s"Person($name, $age)"
}

class CompareCommon[T](obj1: T, obj2: T)(implicit ev$1: T => Ordered[T]) {
  def geater: T = if (obj1 > obj2) obj1 else obj2
}