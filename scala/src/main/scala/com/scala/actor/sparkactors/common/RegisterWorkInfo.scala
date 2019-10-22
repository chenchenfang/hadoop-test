package com.scala.actor.sparkactors.common

//work返回给master的信息
case class RegisterWorkInfo(id:String,cpu:Int,ram:Int)

//保存到Master中的信息
case class WorkInfo(id:String,cpu:Int,ram:Int)

case class RegisteredWorkerInfo()
