package org.tuubes.craft

import java.nio.channels.SocketChannel

import com.electronwill.niol.network.tcp.{ClientAttach, ServerChannelInfos, TcpListener}

class CraftTcpListener(protocol: MinecraftProtocol) extends TcpListener[MinecraftProtocol] {
  override def onAccept(cc: SocketChannel, sc: ServerChannelInfos[MinecraftProtocol]): ClientAttach[MinecraftProtocol] = {
    new CraftAttach(sc, cc, protocol)
  }

  override def onDisconnect(clientAttach: ClientAttach[MinecraftProtocol]): Unit = {
    // TODO disconnect the player with TuubesCore
  }
}
