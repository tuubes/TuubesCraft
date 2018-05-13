package org.tuubes.craft.mc1_12_2.handlers

import java.util.UUID

import org.tuubes.craft.CraftAttach
import org.tuubes.craft.mc1_12_2.login.clientbound.LoginSuccessPacket
import org.tuubes.craft.mc1_12_2.login.serverbound.LoginStartPacket
import org.tuubes.craft.mc1_12_2.play.PlayProtocol

class LoginHandler extends ((LoginStartPacket, CraftAttach) => Unit) {
  override def apply(packet: LoginStartPacket, client: CraftAttach): Unit = {
    val playerId = UUID.fromString(packet.name)
    val success = new LoginSuccessPacket(playerId.toString, packet.name)
    client.send(success, 128, () => client.protocol = PlayProtocol)
  }
}
