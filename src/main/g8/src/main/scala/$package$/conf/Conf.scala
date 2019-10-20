package $package$.conf

import zio._


case class Config(testValue: String)

trait Conf {
  val conf: Conf.Service[Any]
}

object Conf {
  trait Service[R] {
    def load: ZIO[R, Throwable, Config]
  }
}

