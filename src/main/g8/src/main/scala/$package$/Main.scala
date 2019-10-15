package $package$

import zio._
import log._


object Main extends App {

  val prog: ZIO[Log, Throwable, Unit] = for {
    _   <- ZIO.accessM((log: Log) => log.log.info("hi"))
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
        1
      }
    )
  }

}
