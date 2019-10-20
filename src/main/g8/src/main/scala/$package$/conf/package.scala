package $package$

package object conf {

  import zio._

  def load = {
    ZIO.accessM[Conf](_.conf.load)
  }
}
