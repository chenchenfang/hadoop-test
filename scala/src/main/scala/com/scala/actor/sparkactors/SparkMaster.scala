package com.scala.actor.sparkactors

import akka.actor.{Actor, ActorSystem, Props}
import com.scala.actor.sparkactors.common.{RegisterWorkInfo, RegisteredWorkerInfo, WorkInfo}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable

object SparkMaster {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10001
            """.stripMargin)
    val actorSystem = ActorSystem("sparkMasterActorSystem",config)
    val sparkMasterActor = actorSystem.actorOf(Props[SparkMaster],"sparkMasterActor")
    sparkMasterActor ! "start"
  }
}

class SparkMaster extends Actor {
  private val map: mutable.HashMap[String, WorkInfo] = collection.mutable.HashMap[String, WorkInfo]()

  override def receive: Receive = {
    case "start" => println("开始工作")
    case RegisterWorkInfo(id, cpu, ram) =>
      if (!map.contains(id)) {
        map.put(id, WorkInfo(id, cpu, ram))
      }
      sender() ! RegisteredWorkerInfo()
  }
}
