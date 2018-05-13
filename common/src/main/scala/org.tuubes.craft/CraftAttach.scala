package org.tuubes.craft

import java.nio.channels.SocketChannel

import com.electronwill.niol.NiolInput
import com.electronwill.niol.network.tcp.{ClientAttach, ServerChannelInfos}
import org.slf4j.LoggerFactory

class CraftAttach(sci: ServerChannelInfos[CraftAttach],
                  chan: SocketChannel,
                  var protocol: MinecraftProtocol)

    extends ClientAttach(sci, chan) {

  private[this] val logger = LoggerFactory.getLogger("TuubesCraft.CraftAttach")

  // Handles incomplete packet headers
  private[this] val maxBytes = 5
  private[this] var shift = 0
  private[this] var partialResult = 0

  private def tryGetVarint(in: NiolInput): Int = {
    val maxShift = maxBytes * 7
    var read: Byte = 0
    try {
      do {
        read = in.getByte()
        partialResult |= ((read & 0x7F) << shift)
        if (shift > maxShift) {
          throw new RuntimeException(s"VarInt too big: it should take at most $maxBytes bytes")
        }
        shift += 7
      } while ((read & 0x80) != 0)
      shift = 0
      val res = partialResult
      partialResult = 0
      res
    } catch {
      case e: Exception => -1
    }
  }

  /**
   * Reads the packet's size.
   */
  override protected def readHeader(buffer: NiolBuffer): Int = {
    val packetLength = tryGetVarint(buffer)
    if (packetLength >= 0) {
      logger.debug(s"Header read: packet size $packetLength")
    }
    packetLength
  }

  /**
   * Handles the packet's data.
   *
   * @param buffer the buffer, transformed (ie easily readable) and without the packet's size
   */
  override protected def handleData(buffer: NiolBuffer): Unit = {
    // TODO logger.debug(s"Handling incoming packet data of size $buffer.readAvail")
    val packet = protocol.readPacket(buffer)
    // TODO logger.debug(s"Packet read: $packet")
    packet.obj.handle(packet, this)
  }
}
