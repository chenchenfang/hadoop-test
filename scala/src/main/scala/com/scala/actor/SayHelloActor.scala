package com.scala.actor

import akka.actor.{Actor, ActorSystem, Props}

object SayHelloActor {
  def main(args: Array[String]): Unit = {
    val actorFactory = ActorSystem("actorFactory")
    val sayHelloActorRef = actorFactory.actorOf(Props[SayHelloActor], "SayHelloActor")
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "ok"
    sayHelloActorRef ! "exit"
  }
}

class SayHelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("我接受到了hello")
    case "ok" => println("我接受到了ok")
    case _ => {
      println("接受结束")
      context.stop(self)
      context.system.terminate()
    }

  }
}
