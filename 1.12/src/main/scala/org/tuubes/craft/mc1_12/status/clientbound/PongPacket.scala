package org.tuubes.craft.mc1_12.status.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class PongPacket(var payload: Long) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putLong(payload)
  }
	
  override def id = PongPacket.id

	
}
object PongPacket extends PacketObj[PongPacket] {
  override val id = 1
	
  override def read(in: NiolOutput): PongPacket {
    val payload = in.getLong()
    new PongPacket(payload)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PongPacketBuilder[P <: PongPacket] extends PacketBuilder[PongPacket, Complete] {
  private[this] var payload: Long = _

  def withPayload(payload: Long): PongPacketBuilder[P with Payload] = {
    this.payload = payload
    this.asInstanceOf[PongPacketBuilder[P with Payload]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new PongPacket(payload)
  }
}
object PongPacketBuilder {
  sealed trait Payload
  type Complete = PongPacketBuilder with Payload
}
