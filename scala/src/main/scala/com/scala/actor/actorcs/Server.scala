package com.scala.actor.actorcs

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.scala.actor.actorcs.common.{ClientMsg, ServerMsg}
import com.typesafe.config.ConfigFactory

object Server extends  App {
  val host = "127.0.0.1" //服务端ip地址
  val port = 9999
  //创建config对象,指定协议类型，监听的ip和端口
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
        """.stripMargin)
  val serverActorSystem = ActorSystem("serverActorSystem",config)

  private val server: ActorRef = serverActorSystem.actorOf(Props[Server],"server")

  server ! "start"


}

class Server extends Actor {


  override def receive: Receive = {
    case "start" => println("开始执行程序")
    case ClientMsg(msg) =>
      msg match {
        case "学费" => sender() ! ServerMsg("1000元")
        case "地址" => sender() ! ServerMsg("你的心里")
      }
  }
}
