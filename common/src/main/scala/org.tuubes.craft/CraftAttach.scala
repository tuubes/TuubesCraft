package org.tuubes.craft

import java.nio.channels.SocketChannel

import com.electronwill.niol.buffer.NiolBuffer
import com.electronwill.niol.network.tcp.{ClientAttach, ServerChannelInfos}

class CraftAttach(sci: ServerChannelInfos[MinecraftProtocol],
                  chan: SocketChannel,
                  p: MinecraftProtocol)

    extends ClientAttach[MinecraftProtocol](sci, p, chan) {

  /**
   * Reads the packet's size.
   */
  override protected def readHeader(buffer: NiolBuffer): Int = {
    val packetLength = buffer.getVarint()
    // TODO logger.debug(s"Header read: packet size $packetLength")
    packetLength
  }

  /**
   * Handles the packet's data.
   *
   * @param buffer the buffer, transformed (ie easily readable) and without the packet's size
   */
  override protected def handleData(buffer: NiolBuffer): Unit = {
    // TODO logger.debug(s"Handling incoming packet data of size $buffer.readAvail")
    val packet = infos.readPacket(buffer)
    // TODO logger.debug(s"Packet read: $packet")
    // TODO handle the packet: apply its effects with a PacketHandler?
  }
}
