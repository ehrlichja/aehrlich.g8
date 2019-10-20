package $package$.conf

import zio._
import pureconfig._
import pureconfig.generic.auto._
import scala.util.Try

trait ConfLive extends Conf {

  override val conf = new Conf.Service[Any] {
    def load: ZIO[Any, Throwable, Config] = ZIO.fromTry(Try(ConfigSource.default.loadOrThrow[Config]))
  }

}

