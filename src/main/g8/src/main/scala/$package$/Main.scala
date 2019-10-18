package $package$

import zio._
import log._
import conf._


object Main extends App {

  val prog: ZIO[Log, Throwable, Unit] = for {
    config <- Conf.load
    _      <- info(config.testValue)
  } yield ()
 
  def run(args: List[String]): ZIO[Environment, Nothing, Int] = {
    val progLive = prog.provide(LogLive)
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
