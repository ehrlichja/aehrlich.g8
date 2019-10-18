package $package$

package object log {
  
  import zio._

  def info(msg: String): ZIO[Log, Throwable, Unit] = {
    ZIO.accessM[Log]((log: Log) => log.log.info(msg))
  }

}
