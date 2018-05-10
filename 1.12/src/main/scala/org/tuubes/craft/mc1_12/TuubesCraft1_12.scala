package org.tuubes.craft.mc1_12

import org.tuubes.core.plugins.PluginDescription
import org.tuubes.craft.{BaseDescription, MinecraftProtocol, TuubesExtension}

final class TuubesCraft1_12 extends TuubesExtension {
  override val protocol: MinecraftProtocol = _ // TODO generate the protocol with DataTractor
  override val description: PluginDescription = TuubesCraft1_12
}

object TuubesCraft1_12 extends BaseDescription {
  override val minecraftVersion: String = "1.12"
  override val version: String = "0.1"
}
