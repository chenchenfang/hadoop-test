package com.scala.generic

import com.scala.generic.SeasonEm.SeasonEm

/**
 * 泛型的简单应用
 */
object GenericUse2 {
  def main(args: Array[String]): Unit = {
    val englishClass = new EnglishClass[SeasonEm, String, String](SeasonEm.spring, "一年级", "一班")
    println(s"${englishClass.seasonEm}   ${englishClass.className}   ${englishClass.classType} ")
  }
}

class EnglishClass[A, B, C](val seasonEm: A, val className: B, val classType: C) {

}

object SeasonEm extends Enumeration {
  type SeasonEm = Value
  val spring, summer, winter, autumn = Value
}