package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import EntityLookAndRelativeMovePacketBuilder._
import org.tuubes.core.network._
import com.electronwill.utils.{Pi2, InvPi2}

/** Packet class auto-generated by DataTractor */
final class EntityLookAndRelativeMovePacket(var entityId: Int, var deltaX: Short, var deltaY: Short, var deltaZ: Short, var yaw: Byte, var pitch: Byte, var onGround: Boolean) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(entityId)
    out.putShort(deltaX)
    out.putShort(deltaY)
    out.putShort(deltaZ)
    out.putByte(yaw)
    out.putByte(pitch)
    out.putBoolean(onGround)
  }
	
  override def obj = EntityLookAndRelativeMovePacket

  def radYaw: Float = {
    yaw * Pi2 / 256f
  }
  def radPitch: Float = {
    pitch * Pi2 / 256f
  }	
}
object EntityLookAndRelativeMovePacket extends PacketObj[CraftAttach, EntityLookAndRelativeMovePacket] {
  override val id = 39
	
  override def read(in: NiolInput): EntityLookAndRelativeMovePacket = {
    val entityId = in.getVarint()
    val deltaX = in.getShort()
    val deltaY = in.getShort()
    val deltaZ = in.getShort()
    val yaw = in.getByte()
    val pitch = in.getByte()
    val onGround = in.getBoolean()
    new EntityLookAndRelativeMovePacket(entityId, deltaX, deltaY, deltaZ, yaw, pitch, onGround)
  }
}
/** Packet builder auto-generated by DataTractor */
final class EntityLookAndRelativeMovePacketBuilder[P <: EntityLookAndRelativeMovePacket] extends PacketBuilder[EntityLookAndRelativeMovePacket, P =:= Complete] {
  private[this] var entityId: Int = _
  private[this] var deltaX: Short = _
  private[this] var deltaY: Short = _
  private[this] var deltaZ: Short = _
  private[this] var yaw: Byte = _
  private[this] var pitch: Byte = _
  private[this] var onGround: Boolean = _

  def withEntityId(entityId: Int): EntityLookAndRelativeMovePacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with EntityId]]
  }

  def withDeltaX(deltaX: Short): EntityLookAndRelativeMovePacketBuilder[P with DeltaX] = {
    this.deltaX = deltaX
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with DeltaX]]
  }

  def withDeltaY(deltaY: Short): EntityLookAndRelativeMovePacketBuilder[P with DeltaY] = {
    this.deltaY = deltaY
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with DeltaY]]
  }

  def withDeltaZ(deltaZ: Short): EntityLookAndRelativeMovePacketBuilder[P with DeltaZ] = {
    this.deltaZ = deltaZ
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with DeltaZ]]
  }

  def withYaw(yaw: Byte): EntityLookAndRelativeMovePacketBuilder[P with Yaw] = {
    this.yaw = yaw
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with Yaw]]
  }

  def withYaw(angle: Float): EntityLookAndRelativeMovePacketBuilder[P with Yaw] = {
    this.yaw = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with Yaw]]
  }

  def withPitch(pitch: Byte): EntityLookAndRelativeMovePacketBuilder[P with Pitch] = {
    this.pitch = pitch
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with Pitch]]
  }

  def withPitch(angle: Float): EntityLookAndRelativeMovePacketBuilder[P with Pitch] = {
    this.pitch = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with Pitch]]
  }

  def withOnGround(onGround: Boolean): EntityLookAndRelativeMovePacketBuilder[P with OnGround] = {
    this.onGround = onGround
    this.asInstanceOf[EntityLookAndRelativeMovePacketBuilder[P with OnGround]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new EntityLookAndRelativeMovePacket(entityId, deltaX, deltaY, deltaZ, yaw, pitch, onGround)
  }
}
object EntityLookAndRelativeMovePacketBuilder {
  sealed trait EntityId
  sealed trait DeltaX
  sealed trait DeltaY
  sealed trait DeltaZ
  sealed trait Yaw
  sealed trait Pitch
  sealed trait OnGround
  type Complete = EntityLookAndRelativeMovePacket with EntityId with DeltaX with DeltaY with DeltaZ with Yaw with Pitch with OnGround
}
