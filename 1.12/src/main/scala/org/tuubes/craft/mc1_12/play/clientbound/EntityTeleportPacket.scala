package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import com.electronwill.utils.{Pi2, InvPi2}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class EntityTeleportPacket(var entityId: Int, var x: Double, var y: Double, var z: Double, var yaw: Byte, var pitch: Byte, var onGround: Boolean) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(entityId)
    out.putDouble(x)
    out.putDouble(y)
    out.putDouble(z)
    out.putByte(yaw)
    out.putByte(pitch)
    out.putBoolean(onGround)
  }
	
  override def id = EntityTeleportPacket.id

  def radYaw: Float = {
    yaw * Pi2 / 256f
  }
  def radPitch: Float = {
    pitch * Pi2 / 256f
  }	
}
object EntityTeleportPacket extends PacketObj[EntityTeleportPacket] {
  override val id = 75
	
  override def read(in: NiolOutput): EntityTeleportPacket {
    val entityId = in.getVarint()
    val x = in.getDouble()
    val y = in.getDouble()
    val z = in.getDouble()
    val yaw = in.getByte()
    val pitch = in.getByte()
    val onGround = in.getBoolean()
    new EntityTeleportPacket(entityId, x, y, z, yaw, pitch, onGround)
  }
}
/** Packet builder auto-generated by DataTractor */
final class EntityTeleportPacketBuilder[P <: EntityTeleportPacket] extends PacketBuilder[EntityTeleportPacket, Complete] {
  private[this] var entityId: Int = _
  private[this] var x: Double = _
  private[this] var y: Double = _
  private[this] var z: Double = _
  private[this] var yaw: Byte = _
  private[this] var pitch: Byte = _
  private[this] var onGround: Boolean = _

  def withEntityId(entityId: Int): EntityTeleportPacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[EntityTeleportPacketBuilder[P with EntityId]]
  }

  def withX(x: Double): EntityTeleportPacketBuilder[P with X] = {
    this.x = x
    this.asInstanceOf[EntityTeleportPacketBuilder[P with X]]
  }

  def withY(y: Double): EntityTeleportPacketBuilder[P with Y] = {
    this.y = y
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Y]]
  }

  def withZ(z: Double): EntityTeleportPacketBuilder[P with Z] = {
    this.z = z
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Z]]
  }

  def withYaw(yaw: Byte): EntityTeleportPacketBuilder[P with Yaw] = {
    this.yaw = yaw
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Yaw]]
  }

  def withYaw(angle: Float): EntityTeleportPacketBuilder[P with Yaw] = {
    this.yaw = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Yaw]]
  }

  def withPitch(pitch: Byte): EntityTeleportPacketBuilder[P with Pitch] = {
    this.pitch = pitch
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Pitch]]
  }

  def withPitch(angle: Float): EntityTeleportPacketBuilder[P with Pitch] = {
    this.pitch = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[EntityTeleportPacketBuilder[P with Pitch]]
  }

  def withOnGround(onGround: Boolean): EntityTeleportPacketBuilder[P with OnGround] = {
    this.onGround = onGround
    this.asInstanceOf[EntityTeleportPacketBuilder[P with OnGround]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new EntityTeleportPacket(entityId, x, y, z, yaw, pitch, onGround)
  }
}
object EntityTeleportPacketBuilder {
  sealed trait EntityId
  sealed trait X
  sealed trait Y
  sealed trait Z
  sealed trait Yaw
  sealed trait Pitch
  sealed trait OnGround
  type Complete = EntityTeleportPacketBuilder with EntityId with X with Y with Z with Yaw with Pitch with OnGround
}
