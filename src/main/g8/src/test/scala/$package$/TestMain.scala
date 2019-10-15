package $package$

import org.scalatest._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks


class TestMain extends FlatSpec with Matchers with ScalaCheckPropertyChecks {

  "An example test" should "pass" in {
    1 should equal (1)
  }

  "A property based test" should "pass" in {

    forAll { (first: Int, second: Int) =>
      first + second should equal (first + second)
    }

  }

}
