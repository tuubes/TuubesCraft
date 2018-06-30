package org.tuubes.craft.mc1_12_2.handlers

import org.tuubes.craft.CraftAttach
import org.tuubes.craft.mc1_12_2.handshaking.serverbound.HandshakePacket

class HandshakeHandler extends ((HandshakePacket, CraftAttach) => Unit) {
  override def apply(packet: HandshakePacket, client: CraftAttach): Unit = {
    import org.tuubes.craft.mc1_12_2.login.LoginProtocol
    import org.tuubes.craft.mc1_12_2.status.StatusProtocol

    packet.nextState match {
      case 1 => // status
        client.protocol = StatusProtocol
      case 2 => // login
        if (packet.protocolVersion != 340) {
          client.channel.close()
        } else {
          client.protocol = LoginProtocol
        }
    }
  }
}
