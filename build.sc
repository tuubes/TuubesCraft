// build.sc
import $file.TuubesCore.build
import TuubesCore.{build => coreBuild}
import mill._, scalalib._

object common extends coreBuild.TuubesModule {
  def scalaVersion = "2.12.6"
  def ivyDeps = super.ivyDeps() ++ Agg(ivy"com.github.TheElectronWill:NBJ:3.0")
  def moduleDeps = Seq(coreBuild.core)
  object test extends Tests with coreBuild.JUnitTesting
}

trait CraftModule extends coreBuild.TuubesModule {
  def moduleDeps = Seq(common)
}

object mc1_12 extends CraftModule {}
