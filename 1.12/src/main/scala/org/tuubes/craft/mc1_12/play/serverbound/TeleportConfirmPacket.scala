package org.tuubes.craft.mc1_12.play.serverbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}

/** Packet class auto-generated by DataTractor */
final class TeleportConfirmPacket(var teleportId: Int) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(teleportId)
  }
	
  override def obj = TeleportConfirmPacket

	
}
object TeleportConfirmPacket extends PacketObj[TeleportConfirmPacket] {
  override val id = 0
	
  override def read(in: NiolOutput): TeleportConfirmPacket = {
    val teleportId = in.getVarint()
    new TeleportConfirmPacket(teleportId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class TeleportConfirmPacketBuilder[P <: TeleportConfirmPacket] extends PacketBuilder[TeleportConfirmPacket, Complete] {
  private[this] var teleportId: Int = _

  def withTeleportId(teleportId: Int): TeleportConfirmPacketBuilder[P with TeleportId] = {
    this.teleportId = teleportId
    this.asInstanceOf[TeleportConfirmPacketBuilder[P with TeleportId]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new TeleportConfirmPacket(teleportId)
  }
}
object TeleportConfirmPacketBuilder {
  sealed trait TeleportId
  type Complete = TeleportConfirmPacketBuilder with TeleportId
}
