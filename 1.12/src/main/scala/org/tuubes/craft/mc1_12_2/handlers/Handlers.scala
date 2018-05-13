package org.tuubes.craft.mc1_12_2.handlers

import org.tuubes.craft.mc1_12_2.handshaking.serverbound.HandshakePacket
import org.tuubes.craft.mc1_12_2.login.serverbound.LoginStartPacket
import org.tuubes.craft.mc1_12_2.status.serverbound.{PingPacket, RequestPacket}

object Handlers {
  def registerAll(): Unit = {
    HandshakePacket.subscribe(new HandshakeHandler)
    LoginStartPacket.subscribe(new LoginHandler)
    PingPacket.subscribe(new PingHandler)
    RequestPacket.subscribe(new RequestHandler)
  }
}
