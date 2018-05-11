package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class KeepAlivePacket(var keepAliveId: Int) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(keepAliveId)
  }
	
  override def id = KeepAlivePacket.id

	
}
object KeepAlivePacket extends PacketObj[KeepAlivePacket] {
  override val id = 31
	
  override def read(in: NiolOutput): KeepAlivePacket {
    val keepAliveId = in.getVarint()
    new KeepAlivePacket(keepAliveId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class KeepAlivePacketBuilder[P <: KeepAlivePacket] extends PacketBuilder[KeepAlivePacket, Complete] {
  private[this] var keepAliveId: Int = _

  def withKeepAliveId(keepAliveId: Int): KeepAlivePacketBuilder[P with KeepAliveId] = {
    this.keepAliveId = keepAliveId
    this.asInstanceOf[KeepAlivePacketBuilder[P with KeepAliveId]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new KeepAlivePacket(keepAliveId)
  }
}
object KeepAlivePacketBuilder {
  sealed trait KeepAliveId
  type Complete = KeepAlivePacketBuilder with KeepAliveId
}