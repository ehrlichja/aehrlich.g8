package $package$.conf

import zio._
import pureconfig._
import pureconfig.generic.auto._
import scala.util.Try


case class Config(testValue: String)

object Conf {

  def load: Task[Config] = ZIO.fromTry(Try(ConfigSource.default.loadOrThrow[Config]))

}
