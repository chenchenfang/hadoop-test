package com.azhen



/**
 * 检查密码
 *
 * 密码长度至少8位；
 * 密码含有数字&字母；
 * 密码含有符号；
 * 含有字母大小写。
 * 规则：
 * 符合2项以上
 */
object Test extends App {
  var trueSum:Int=0
  checkPassword("23$A")
  if(trueSum>=2){
    println("密码正确")
  }


  /**
   * 检查密码
   * @param password
   */
  def checkPassword(password:String){
    //大于等于8
    if(password.length>=8){
      trueSum+=1
    }

    import scala.util.matching.Regex
    //必须包含数字&字母
    val numberLetterPattern: Regex = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$".r
    numberLetterPattern.findFirstMatchIn(password) match {
      case Some(_) => trueSum+=1
      case None => println("numberLetterPattern error")
    }

    if(trueSum>=2){
      return
    }

    //包含特殊符号
    val symbolPattern = "[^a-zA-Z0-9 ]".r
    symbolPattern.findFirstMatchIn(password) match {
      case Some(_) => trueSum+=1
      case None => println("symbolPattern error")
    }

    if(trueSum>=2){
      return
    }

    //必须包含字母大小写
    val capitalizationPattern: Regex = "^(?=.*[a-z])(?=.*[A-Z])$".r
    capitalizationPattern.findFirstMatchIn(password) match {
      case Some(_) => trueSum+=1
      case None => println("capitalizationPattern error")
    }

  }
}
