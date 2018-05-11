package org.tuubes.craft.mc1_12.play.clientbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}
import com.electronwill.utils.Vec3i

/** Packet class auto-generated by DataTractor */
final class BlockBreakAnimationPacket(var entityId: Int, var location: Long, var destroyStage: Byte) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(entityId)
    out.putLong(location)
    out.putByte(destroyStage)
  }
	
  override def obj = BlockBreakAnimationPacket

  def vecLocation: Vec3i = {
    val x = location >> 38
    val y = (location >> 26) & 0xfff
    val z = location << 38 >> 38
    new Vec3i(x, y, z)
  }	
}
object BlockBreakAnimationPacket extends PacketObj[BlockBreakAnimationPacket] {
  override val id = 8
	
  override def read(in: NiolOutput): BlockBreakAnimationPacket = {
    val entityId = in.getVarint()
    val location = in.getLong()
    val destroyStage = in.getByte()
    new BlockBreakAnimationPacket(entityId, location, destroyStage)
  }
}
/** Packet builder auto-generated by DataTractor */
final class BlockBreakAnimationPacketBuilder[P <: BlockBreakAnimationPacket] extends PacketBuilder[BlockBreakAnimationPacket, Complete] {
  private[this] var entityId: Int = _
  private[this] var location: Long = _
  private[this] var destroyStage: Byte = _

  def withEntityId(entityId: Int): BlockBreakAnimationPacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[BlockBreakAnimationPacketBuilder[P with EntityId]]
  }

  def withLocation(location: Long): BlockBreakAnimationPacketBuilder[P with Location] = {
    this.location = location
    this.asInstanceOf[BlockBreakAnimationPacketBuilder[P with Location]]
  }

  def withLocation(v: Vec3i): BlockBreakAnimationPacketBuilder[P with Location] = {
    this.location = ((v.x & 0x3ffffff) << 38) | ((v.y & 0xfff) << 26) | (v.z & 0x3ffffff)
    this.asInstanceOf[BlockBreakAnimationPacketBuilder[P with Location]]
  }

  def withDestroyStage(destroyStage: Byte): BlockBreakAnimationPacketBuilder[P with DestroyStage] = {
    this.destroyStage = destroyStage
    this.asInstanceOf[BlockBreakAnimationPacketBuilder[P with DestroyStage]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new BlockBreakAnimationPacket(entityId, location, destroyStage)
  }
}
object BlockBreakAnimationPacketBuilder {
  sealed trait EntityId
  sealed trait Location
  sealed trait DestroyStage
  type Complete = BlockBreakAnimationPacketBuilder with EntityId with Location with DestroyStage
}
