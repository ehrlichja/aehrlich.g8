package $package$

import zio._
import zio.console._
import org.slf4j.LoggerFactory


object Main extends App {

  val log = LoggerFactory.getLogger(this.getClass)

  val prog: ZIO[Console, Throwable, Unit] = for {
    msg <- Task.succeed("Hello world")
    _   <- putStrLn(msg)
  } yield ()

  def run(args: List[String]) = prog.fold(
    e => {
      log.info("logger works")
      println("error running program")
      println(e.getMessage)
      1
    },
    _ => {
      1
    }
  )

}
