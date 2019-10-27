package com.scala.actor.sparkactors

import akka.actor.{Actor, ActorSystem, Props}
import com.scala.actor.sparkactors.common._
import com.typesafe.config.ConfigFactory
import scala.language.postfixOps
import scala.collection.mutable

object SparkMaster {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10001
            """.stripMargin)
    val actorSystem = ActorSystem("sparkMasterActorSystem", config)
    val sparkMasterActor = actorSystem.actorOf(Props[SparkMaster], "sparkMasterActor")
    sparkMasterActor ! "start"
  }
}

class SparkMaster extends Actor {
  private val map: mutable.HashMap[String, WorkInfo] = collection.mutable.HashMap[String, WorkInfo]()

  override def receive: Receive = {
    case "start" => println("开始工作")
      self ! StartTimeOutWorker

    case StartTimeOutWorker =>
      import context.dispatcher
      import scala.concurrent.duration._
      //每隔9秒检查一下
      context.system.scheduler.schedule(0 millis, 9000 millis, self, RemoveTimeOutWorker)

    case RemoveTimeOutWorker =>
      val currentTime = System.currentTimeMillis()
      map.values.filter(currentTime - _.lastHeartBeatTime > 6000)
        .foreach(workinfo => map.remove(workinfo.id))
      println("删除超时的worker完成")

    case RegisterWorkInfo(id, cpu, ram) =>
      if (!map.contains(id)) {
        map.put(id, WorkInfo(id, cpu, ram))
      }
      sender() ! RegisteredWorkerInfo()

    case HeartBeat(id) => {
      val workInfo = map(id)
      workInfo.lastHeartBeatTime = System.currentTimeMillis()
      println(s"更新$id 的心跳")

    }
  }

}
