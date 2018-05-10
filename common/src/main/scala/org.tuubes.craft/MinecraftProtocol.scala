package org.tuubes.craft

import com.electronwill.niol.NiolInput
import com.electronwill.utils.IntBijection
import com.electronwill.collections.ArrayMap
import org.tuubes.core.blocks.BlockType
import org.tuubes.core.entities.EntityType
import org.tuubes.core.items.ItemType
import org.tuubes.core.network.{Packet, PacketObj, Protocol}

abstract class MinecraftProtocol extends Protocol {
  private val packetIds = new ArrayMap[PacketObj[_]](100, null)

  override def registerPacket(packet: PacketObj[_]): Unit = {
    packetIds(packet.id) = packet
  }

  override def readPacket(in: NiolInput): Packet = {
    val packetId: Int = in.getVarint()
    val packetObj = packetIds.get(packetId)
    packetObj match {
      case Some(obj: PacketObj[_]) => obj.read(in)
      case None => null// TODO logger.error(s"Unknown packet id $packetId")
    }
  }

  override def blockFunction: IntBijection[BlockType] = ???

  override def itemFunction: IntBijection[ItemType] = ???

  override def entityFunction: IntBijection[EntityType] = ???
}
