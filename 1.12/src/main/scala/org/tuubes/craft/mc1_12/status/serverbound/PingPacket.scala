package org.tuubes.craft.mc1_12.status.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class PingPacket(var payload: Long) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putLong(payload)
  }
	
  override def id = PingPacket.id

	
}
object PingPacket extends PacketObj[PingPacket] {
  override val id = 1
	
  override def read(in: NiolOutput): PingPacket {
    val payload = in.getLong()
    new PingPacket(payload)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PingPacketBuilder[P <: PingPacket] extends PacketBuilder[PingPacket, Complete] {
  private[this] var payload: Long = _

  def withPayload(payload: Long): PingPacketBuilder[P with Payload] = {
    this.payload = payload
    this.asInstanceOf[PingPacketBuilder[P with Payload]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new PingPacket(payload)
  }
}
object PingPacketBuilder {
  sealed trait Payload
  type Complete = PingPacketBuilder with Payload
}