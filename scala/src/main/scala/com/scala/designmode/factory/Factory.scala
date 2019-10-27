package com.scala.designmode.factory

trait Factory {
   def  getSoftSweets:SoftSweets
   def  getHardSweets:HardSweets
}

/**
 * 大白兔车间
 */
class WhiteRabbitFactory extends Factory {

  override def getSoftSweets: SoftSweets = {
    new WhiteRabbitSoftSweets()
  }

  override def getHardSweets: HardSweets = {
    new WhiteRabbitHardSweets()
  }
}

class ALPENLIEBEFactory extends Factory{

  override def getSoftSweets: SoftSweets = {
    new ALPENLIEBESoftSweets
  }

  override def getHardSweets: HardSweets = {
    new ALPENLIEBEtHardSweets
  }
}



trait Sweets{
    def taste()
}


trait SoftSweets extends Sweets {}

trait HardSweets extends Sweets{}

class WhiteRabbitSoftSweets() extends SoftSweets {
  override def taste(): Unit = {
    println("甜甜的软软的")
  }
}

class WhiteRabbitHardSweets() extends HardSweets{
  override def taste():Unit={
    println("酸的硬的")
  }
}

class ALPENLIEBESoftSweets() extends SoftSweets{
  override def taste(): Unit = {
    println("阿尔卑斯软糖")
  }
}


class ALPENLIEBEtHardSweets() extends HardSweets{
  override def taste(): Unit = {
    println("阿尔卑斯硬糖")
  }
}