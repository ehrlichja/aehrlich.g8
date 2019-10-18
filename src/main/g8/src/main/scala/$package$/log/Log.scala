package $package$.log

import zio._

trait Log { // Log module
  val log: Log.Service[Any]
}

object Log {
  trait Service[R] { // Log service
    def info(msg: String): ZIO[R, Throwable, Unit] // All functionalities should be zio effects
  }
}
