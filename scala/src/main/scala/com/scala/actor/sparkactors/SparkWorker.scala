package com.scala.actor.sparkactors

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.scala.actor.sparkactors.common.{HeartBeat, RegisterWorkInfo, RegisteredWorkerInfo, SendHeartbeat, WorkInfo}
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._
object SparkWorker {

  def main(args: Array[String]): Unit = {
    val workerName = "worker-01"
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10002
            """.stripMargin)
    val actorSystem = ActorSystem("sparkWorker", config)
    val workerActorRef = actorSystem.actorOf(Props(new SparkWorker), workerName)
    workerActorRef ! "start"

  }
}

class SparkWorker extends Actor{
  var sparkMasterActorRef:ActorSelection =_
  val workerId: String = UUID.randomUUID().toString
  override def preStart(): Unit = {
    sparkMasterActorRef = context.actorSelection("akka.tcp://sparkMasterActorSystem@127.0.0.1:10001/user/sparkMasterActor")
  }

  override def receive: Receive = {
    case "start" => println("work开始工作")
      sparkMasterActorRef ! RegisterWorkInfo(workerId,1,1024*1024*16)

    case _:RegisteredWorkerInfo =>
      println("注册到master完成")
      println("准备定时发送心跳")
      import scala.language.postfixOps
      import context.dispatcher
      //设置定时任务
      context.system.scheduler.schedule(0 millis,3000 millis,self,SendHeartbeat)
    //发送心跳
    case SendHeartbeat => sparkMasterActorRef ! HeartBeat(workerId)
  }
}
