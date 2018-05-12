package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import org.tuubes.core.network._
import SpawnPositionPacketBuilder._
import com.electronwill.utils.Vec3i

/** Packet class auto-generated by DataTractor */
final class SpawnPositionPacket(var location: Long) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putLong(location)
  }
	
  override def obj = SpawnPositionPacket

  def vecLocation: Vec3i = {
    val x = location >> 38
    val y = (location >> 26) & 0xfff
    val z = location << 38 >> 38
    new Vec3i(x, y, z)
  }	
}
object SpawnPositionPacket extends PacketObj[CraftAttach, SpawnPositionPacket] {
  override val id = 69
	
  override def read(in: NiolInput): SpawnPositionPacket = {
    val location = in.getLong()
    new SpawnPositionPacket(location)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SpawnPositionPacketBuilder[P <: SpawnPositionPacket] extends PacketBuilder[SpawnPositionPacket, P =:= Complete] {
  private[this] var location: Long = _

  def withLocation(location: Long): SpawnPositionPacketBuilder[P with Location] = {
    this.location = location
    this.asInstanceOf[SpawnPositionPacketBuilder[P with Location]]
  }

  def withLocation(v: Vec3i): SpawnPositionPacketBuilder[P with Location] = {
    this.location = ((v.x & 0x3ffffff) << 38) | ((v.y & 0xfff) << 26) | (v.z & 0x3ffffff)
    this.asInstanceOf[SpawnPositionPacketBuilder[P with Location]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new SpawnPositionPacket(location)
  }
}
object SpawnPositionPacketBuilder {
  sealed trait Location
  type Complete = SpawnPositionPacket with Location
}
