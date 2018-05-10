package org.tuubes.craft

import org.tuubes.core.plugins.PluginDescription

abstract class BaseDescription extends PluginDescription {
  val minecraftVersion: String
  override val name: String = s"TuubesCraft_$minecraftVersion"
  override val optionalDeps: Seq[String] = Nil
  override val requiredDeps: Seq[String] = Nil
}
