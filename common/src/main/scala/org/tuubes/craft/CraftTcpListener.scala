package org.tuubes.craft

import java.nio.channels.SocketChannel

import com.electronwill.niol.network.tcp.{ServerChannelInfos, TcpListener}

class CraftTcpListener(protocol: MinecraftProtocol) extends TcpListener[CraftAttach] {
  override def onAccept(cc: SocketChannel, sc: ServerChannelInfos[CraftAttach]): CraftAttach = {
    new CraftAttach(sc, cc, protocol)
  }

  override def onDisconnect(clientAttach: CraftAttach): Unit = {
    // TODO disconnect the player with TuubesCore
  }
}
