package $package$

package object log {
  
  import zio._

  def info(msg: String): ZIO[Log, Throwable, Unit] = {
    ZIO.accessM[Log](_.log.info(msg))
  }

}
