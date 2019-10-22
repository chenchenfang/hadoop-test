package com.scala.actor.actorcs

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.scala.actor.actorcs.common.{ClientMsg, ServerMsg}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

object Client extends App {

  val (host, port, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
        """.stripMargin)
  val clientActorSystem = ActorSystem("client", config)
  private val client: ActorRef = clientActorSystem.actorOf(Props(new Client(serverHost,serverPort)), "client")

  client ! "start"

  while(true){
    val str = StdIn.readLine()
    client ! str
  }

}

class Client(serverHost: String, serverPort: Int) extends Actor {
  var serverActorRefer: ActorSelection = _
  override def preStart(): Unit = {
    this.serverActorRefer  = context.actorSelection(s"akka.tcp://serverActorSystem@${serverHost}:${serverPort}/user/server")

  }

  override def receive: Receive = {
    case "start" => println("客户端已经可以使用了")
    case ServerMsg(msg) => println(msg)
    case msg:String =>
      serverActorRefer ! ClientMsg(msg)
  }
}
