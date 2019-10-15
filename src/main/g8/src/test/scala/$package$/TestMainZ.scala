package $package$

import zio.test._
import zio.test.environment.TestConsole
import zio.test.Assertion._


object TestMainZ extends DefaultRunnableSpec (
  suite("Main suite")(
    testM("Hello World test") {
      for {
        _      <- Main.prog
        output <- TestConsole.output
      } yield {
        assert(output, equalTo(Vector("ok")))
      }
    }

  )

)
