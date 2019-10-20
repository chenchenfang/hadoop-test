package com.scala.actor
import akka.actor.{Actor, ActorSystem, Props}
class TomActor extends Actor{
  override def receive: Receive = {

    case "去吃翔" => println("我要去吃翔了!!!")
    case "明天不用上课" =>println("明天不用上课,所以明天可以去逛街了")
  }
}
