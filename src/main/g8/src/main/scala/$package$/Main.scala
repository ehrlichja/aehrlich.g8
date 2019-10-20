package $package$

import zio._
import $package$.log
import $package$.log.{LogLive, Log}
import $package$.conf
import $package$.conf.{ConfLive, Conf}


object Main extends App {

  val prog: ZIO[Conf with Log, Throwable, Unit] = for {
    config <- conf.load
    _      <- log.info(config.testValue)
  } yield ()
 
  def run(args: List[String]): ZIO[Environment, Nothing, Int] = {
    val progLive = prog.provide(new ConfLive with LogLive {})
    progLive.fold(
      e => {
        println("error running program")
        println(e.getMessage)
        1
      },
      _ => {
        0
      }
    )
  }

}
