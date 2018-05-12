package org.tuubes.craft

import com.electronwill.niol.NiolInput
import com.electronwill.utils.IntBijection
import com.electronwill.collections.ArrayMap
import org.tuubes.core.blocks.BlockType
import org.tuubes.core.entities.EntityType
import org.tuubes.core.items.ItemType
import org.tuubes.core.network.{Packet, PacketObj, Protocol}
import org.tuubes.craft.{CraftAttach => C}

abstract class MinecraftProtocol extends Protocol[C] {
  private val packetIds = new ArrayMap[PacketObj[C, Packet[C]]](100, null)

  override def registerPacket(packet: PacketObj[C, Packet[C]]): Unit = {
    packetIds(packet.id) = packet
  }

  override def readPacket(in: NiolInput): Packet[C] = {
    val packetId: Int = in.getVarint()
    val packetObj = packetIds.get(packetId)
    packetObj match {
      case Some(obj) => obj.read(in)
      case None => null// TODO logger.error(s"Unknown packet id $packetId")
    }
  }

  override def blockFunction: IntBijection[BlockType] = ???

  override def itemFunction: IntBijection[ItemType] = ???

  override def entityFunction: IntBijection[EntityType] = ???
}
