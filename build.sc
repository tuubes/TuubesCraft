// build.sc
import $file.TuubesCore.build
import TuubesCore.build.{TuubesModule, JUnitTesting, core}
import mill._, scalalib._

object common extends TuubesModule {
  def scalaVersion = "2.12.6"
  def ivyDeps = super.ivyDeps() ++ Agg(ivy"com.electronwill.night-config:nbj:3.0.0")
  def moduleDeps = Seq(core)
  object test extends Tests with JUnitTesting
}

trait CraftModule extends TuubesModule {
  def moduleDeps = Seq(common)
}

object mc1_12 extends CraftModule {}
