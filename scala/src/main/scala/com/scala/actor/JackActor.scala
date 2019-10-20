package com.scala.actor
import akka.actor.{Actor, ActorSystem, Props}
class JackActor extends Actor {
  override def receive: Receive = {
    case "去吃屎" => println("我是jack,我才不去,反手给你一巴掌")
    case "明天休息" => println("明天休息可以玩猛汉王!!")
  }
}
