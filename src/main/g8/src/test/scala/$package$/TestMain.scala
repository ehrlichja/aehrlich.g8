package $package$

import zio._
import zio.test._
import zio.test.Assertion._
import $package$.log.LogTest
import $package$.conf.{Conf, Config}
import scala.util.Success


trait ConfTest extends Conf {
  val conf = new Conf.Service[Any] {
    def load: ZIO[Any, Throwable, Config] = ZIO.fromTry(Success(Config("myTestValue")))
  }
}

object TestMain {

  val testEnv = new ConfTest with LogTest

  val suite1 = suite("Test main") {
    testM("log the output of the config") {
      for {
        _      <- Main.prog.provide(testEnv)
      } yield assert(testEnv.q.toSeq, equalTo(Seq("myTestValue")))
    }
  }

}

object TestMainSpec extends DefaultRunnableSpec(suite("All tests")(TestMain.suite1))

