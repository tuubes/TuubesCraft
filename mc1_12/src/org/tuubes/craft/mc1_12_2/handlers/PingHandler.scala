package org.tuubes.craft.mc1_12_2.handlers

import org.tuubes.craft.CraftAttach
import org.tuubes.craft.mc1_12_2.status.clientbound.PongPacket
import org.tuubes.craft.mc1_12_2.status.serverbound.PingPacket

class PingHandler extends ((PingPacket, CraftAttach) => Unit) {
  override def apply(packet: PingPacket, client: CraftAttach): Unit = {
    val response = new PongPacket(packet.payload)
    client.send(response, 16)
  }
}
