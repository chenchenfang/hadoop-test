package com.scala.designmode.factory

class GetSweets {

}
object GetSweets{
  def main(args: Array[String]): Unit = {
    val white = new WhiteRabbitFactory
    val alpenliebe = new ALPENLIEBEFactory
    val hard = white.getHardSweets
    val soft = alpenliebe.getSoftSweets
    println(hard.taste())
    println(soft.taste())
  }
}
