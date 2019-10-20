package $package$.log

import zio._
import org.slf4j.{Logger, LoggerFactory}

trait LogLive extends Log {

  val logback: Logger = LoggerFactory.getLogger(this.getClass)

  override val log = new Log.Service[Any] {
    def info(msg: String): ZIO[Any, Throwable, Unit] = for {
      _ <- ZIO.effect(logback.info(msg))
    } yield ()
  }

}
