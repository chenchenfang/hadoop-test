package com.scala.actor
import akka.actor.{Actor, ActorSystem, Props}
object SayMessage {

  def main(args: Array[String]): Unit = {
    val actorFactory = ActorSystem("actorFactory")
    val tomActorRef = actorFactory.actorOf(Props[TomActor],"tomActor")
    val jackActorRef = actorFactory.actorOf(Props[JackActor],"jackActor")

    tomActorRef.!("去吃翔")
    jackActorRef ! "去吃屎"

  }
}
