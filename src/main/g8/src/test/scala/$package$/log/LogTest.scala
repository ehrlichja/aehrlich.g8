package $package$.log

import zio._
import scala.collection.mutable.Queue


trait LogTest extends Log {
  val q = new Queue[String]()
  val log = new Log.Service[Any] {
    def info(msg: String): ZIO[Any, Throwable, Unit] = ZIO.effect(q += msg)
  }
}

