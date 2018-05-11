package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class SpawnExperienceOrbPacket(var entityId: Int, var x: Double, var y: Double, var z: Double, var count: Short) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(entityId)
    out.putDouble(x)
    out.putDouble(y)
    out.putDouble(z)
    out.putShort(count)
  }
	
  override def id = SpawnExperienceOrbPacket.id

	
}
object SpawnExperienceOrbPacket extends PacketObj[SpawnExperienceOrbPacket] {
  override val id = 1
	
  override def read(in: NiolOutput): SpawnExperienceOrbPacket {
    val entityId = in.getVarint()
    val x = in.getDouble()
    val y = in.getDouble()
    val z = in.getDouble()
    val count = in.getShort()
    new SpawnExperienceOrbPacket(entityId, x, y, z, count)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SpawnExperienceOrbPacketBuilder[P <: SpawnExperienceOrbPacket] extends PacketBuilder[SpawnExperienceOrbPacket, Complete] {
  private[this] var entityId: Int = _
  private[this] var x: Double = _
  private[this] var y: Double = _
  private[this] var z: Double = _
  private[this] var count: Short = _

  def withEntityId(entityId: Int): SpawnExperienceOrbPacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[SpawnExperienceOrbPacketBuilder[P with EntityId]]
  }

  def withX(x: Double): SpawnExperienceOrbPacketBuilder[P with X] = {
    this.x = x
    this.asInstanceOf[SpawnExperienceOrbPacketBuilder[P with X]]
  }

  def withY(y: Double): SpawnExperienceOrbPacketBuilder[P with Y] = {
    this.y = y
    this.asInstanceOf[SpawnExperienceOrbPacketBuilder[P with Y]]
  }

  def withZ(z: Double): SpawnExperienceOrbPacketBuilder[P with Z] = {
    this.z = z
    this.asInstanceOf[SpawnExperienceOrbPacketBuilder[P with Z]]
  }

  def withCount(count: Short): SpawnExperienceOrbPacketBuilder[P with Count] = {
    this.count = count
    this.asInstanceOf[SpawnExperienceOrbPacketBuilder[P with Count]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new SpawnExperienceOrbPacket(entityId, x, y, z, count)
  }
}
object SpawnExperienceOrbPacketBuilder {
  sealed trait EntityId
  sealed trait X
  sealed trait Y
  sealed trait Z
  sealed trait Count
  type Complete = SpawnExperienceOrbPacketBuilder with EntityId with X with Y with Z with Count
}
