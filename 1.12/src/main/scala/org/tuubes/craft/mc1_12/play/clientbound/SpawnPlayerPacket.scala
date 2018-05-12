package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import SpawnPlayerPacketBuilder._
import org.tuubes.craft.CraftAttach
import java.util.UUID
import org.tuubes.core.network._
import com.electronwill.utils.{Pi2, InvPi2}

/** Packet class auto-generated by DataTractor */
final class SpawnPlayerPacket(var entityId: Int, var playerUuid: UUID, var x: Double, var y: Double, var z: Double, var yaw: Byte, var pitch: Byte, var metadata: AnyRef) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(entityId)
    out.putLong(playerUuid.getMostSignificantBits); out.putLong(playerUuid.getLeastSignificantBits)
    out.putDouble(x)
    out.putDouble(y)
    out.putDouble(z)
    out.putByte(yaw)
    out.putByte(pitch)
    // TODO write metadata
  }
	
  override def obj = SpawnPlayerPacket

  def radYaw: Float = {
    yaw * Pi2 / 256f
  }
  def radPitch: Float = {
    pitch * Pi2 / 256f
  }	
}
object SpawnPlayerPacket extends PacketObj[CraftAttach, SpawnPlayerPacket] {
  override val id = 5
	
  override def read(in: NiolInput): SpawnPlayerPacket = {
    val entityId = in.getVarint()
    val playerUuid = new UUID(in.getLong(), in.getLong())
    val x = in.getDouble()
    val y = in.getDouble()
    val z = in.getDouble()
    val yaw = in.getByte()
    val pitch = in.getByte()
    // TODO read metadata
    new SpawnPlayerPacket(entityId, playerUuid, x, y, z, yaw, pitch, metadata)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SpawnPlayerPacketBuilder[P <: SpawnPlayerPacket] extends PacketBuilder[SpawnPlayerPacket, P =:= Complete] {
  private[this] var entityId: Int = _
  private[this] var playerUuid: UUID = _
  private[this] var x: Double = _
  private[this] var y: Double = _
  private[this] var z: Double = _
  private[this] var yaw: Byte = _
  private[this] var pitch: Byte = _
  private[this] var metadata: AnyRef = _

  def withEntityId(entityId: Int): SpawnPlayerPacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with EntityId]]
  }

  def withPlayerUuid(playerUuid: UUID): SpawnPlayerPacketBuilder[P with PlayerUuid] = {
    this.playerUuid = playerUuid
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with PlayerUuid]]
  }

  def withX(x: Double): SpawnPlayerPacketBuilder[P with X] = {
    this.x = x
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with X]]
  }

  def withY(y: Double): SpawnPlayerPacketBuilder[P with Y] = {
    this.y = y
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Y]]
  }

  def withZ(z: Double): SpawnPlayerPacketBuilder[P with Z] = {
    this.z = z
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Z]]
  }

  def withYaw(yaw: Byte): SpawnPlayerPacketBuilder[P with Yaw] = {
    this.yaw = yaw
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Yaw]]
  }

  def withYaw(angle: Float): SpawnPlayerPacketBuilder[P with Yaw] = {
    this.yaw = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Yaw]]
  }

  def withPitch(pitch: Byte): SpawnPlayerPacketBuilder[P with Pitch] = {
    this.pitch = pitch
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Pitch]]
  }

  def withPitch(angle: Float): SpawnPlayerPacketBuilder[P with Pitch] = {
    this.pitch = (angle * InvPi2 * 256f).toByte  
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Pitch]]
  }

  def withMetadata(metadata: AnyRef): SpawnPlayerPacketBuilder[P with Metadata] = {
    this.metadata = metadata
    this.asInstanceOf[SpawnPlayerPacketBuilder[P with Metadata]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new SpawnPlayerPacket(entityId, playerUuid, x, y, z, yaw, pitch, metadata)
  }
}
object SpawnPlayerPacketBuilder {
  sealed trait EntityId
  sealed trait PlayerUuid
  sealed trait X
  sealed trait Y
  sealed trait Z
  sealed trait Yaw
  sealed trait Pitch
  sealed trait Metadata
  type Complete = SpawnPlayerPacket with EntityId with PlayerUuid with X with Y with Z with Yaw with Pitch with Metadata
}
