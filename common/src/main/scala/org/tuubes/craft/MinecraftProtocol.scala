package org.tuubes.craft

import com.electronwill.niol.NiolInput
import com.electronwill.utils.IntBijection
import com.electronwill.collections.ArrayMap
import org.slf4j.LoggerFactory
import org.tuubes.core.blocks.BlockType
import org.tuubes.core.engine.GameObject
import org.tuubes.core.entities.EntityType
import org.tuubes.core.items.ItemType
import org.tuubes.core.network.{Packet, PacketObj, Protocol}
import org.tuubes.craft.{CraftAttach => C}

abstract class MinecraftProtocol extends Protocol[C] {
  private val logger = LoggerFactory.getLogger("TuubesCraft.MinecraftProtocol")
  private val packetIds = new ArrayMap[PacketObj[C, _ <: Packet]](100, null)

  override def registerPacket[A <: Packet](packet: PacketObj[CraftAttach, A]): Unit = {
    packetIds(packet.id) = packet
  }

  override def detectPacket[A <: Packet](in: NiolInput): PacketObj[C, A] = {
    val packetId: Int = in.getVarint()
    val packetObj = packetIds(packetId).asInstanceOf[PacketObj[CraftAttach, A]]
    logger.debug(s"Detected packet $packetId: ${packetObj.getClass.getSimpleName}")
    packetObj
  }

  override def blockFunction: IntBijection[BlockType] = ???

  override def itemFunction: IntBijection[ItemType] = ???

  override def entityFunction: IntBijection[EntityType] = ???

  override def spawn(obj: GameObject): Unit = ???

  override def despawn(obj: GameObject): Unit = ???
}
