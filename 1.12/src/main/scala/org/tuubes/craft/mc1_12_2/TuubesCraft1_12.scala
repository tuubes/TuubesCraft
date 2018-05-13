package org.tuubes.craft.mc1_12_2

import com.typesafe.scalalogging.Logger
import org.tuubes.core.plugins.PluginDescription
import org.tuubes.craft.mc1_12_2.handlers.Handlers
import org.tuubes.craft.mc1_12_2.handshaking.HandshakingProtocol
import org.tuubes.craft.{BaseDescription, MinecraftProtocol, TuubesExtension}

final class TuubesCraft1_12 extends TuubesExtension {
  override val defaultProtocol: MinecraftProtocol = HandshakingProtocol // TODO generate the protocol with DataTractor
  override val description: PluginDescription = TuubesCraft1_12

  override def onLoad(): Unit = {
    TuubesCraft1_12.logger = logger
    logger.info("Subscribing to the incoming packets")
    Handlers.registerAll()
    super.onLoad()
  }
}

object TuubesCraft1_12 extends BaseDescription("1.12.2") {
  override val version: String = "0.2.31"
  var logger: Logger = _
}
