package org.tuubes.craft

import org.tuubes.core.plugins.PluginDescription

abstract class BaseDescription(val minecraftVersion: String) extends PluginDescription {
  override val name: String = s"TuubesCraft_$minecraftVersion"
  override val optionalDeps: Seq[String] = Nil
  override val requiredDeps: Seq[String] = Nil
}
