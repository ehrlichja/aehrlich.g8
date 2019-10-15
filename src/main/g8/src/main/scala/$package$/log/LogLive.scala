package com.aehrlich.aehrlichtest.log

import zio._
import org.slf4j.{Logger, LoggerFactory}

object LogLive extends Log {

  val logback: Logger = LoggerFactory.getLogger(this.getClass)

  override val log = new Log.Service[Any] {
    def info(msg: String): ZIO[Any, Throwable, Unit] = ZIO.effect(logback.info(msg))
  }

}
