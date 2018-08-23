// build.sc
import $file.TuubesCore.build
import TuubesCore.build.{TuubesModule, JUnitTesting}
import mill._, scalalib._

val core = TuubesCore.build.core

// Implementation of the game's content (1 module for everything)
object game extends TuubesModule {
  def moduleDeps = Seq(core)
  object test extends Tests with JUnitTesting
}

// Network packets, utils and handlers for each version of Minecraft
object protocol extends TuubesModule {
  // Common things + 1 Module per version
  object common extends TuubesModule {
    def moduleDeps = Seq(game)
    object test extends Tests with JUnitTesting
  }
  trait ProtocolModule extends TuubesModule {
    def moduleDeps = Seq(common)
  }
  object v1_12_2 extends ProtocolModule
}
