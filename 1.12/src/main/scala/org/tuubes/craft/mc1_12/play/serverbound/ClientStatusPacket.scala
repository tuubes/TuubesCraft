package org.tuubes.craft.mc1_12.play.serverbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}

/** Packet class auto-generated by DataTractor */
final class ClientStatusPacket(var actionId: Int) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(actionId)
  }
	
  override def obj = ClientStatusPacket

	
}
object ClientStatusPacket extends PacketObj[ClientStatusPacket] {
  override val id = 4
	
  override def read(in: NiolOutput): ClientStatusPacket = {
    val actionId = in.getVarint()
    new ClientStatusPacket(actionId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ClientStatusPacketBuilder[P <: ClientStatusPacket] extends PacketBuilder[ClientStatusPacket, Complete] {
  private[this] var actionId: Int = _

  def withActionId(actionId: Int): ClientStatusPacketBuilder[P with ActionId] = {
    this.actionId = actionId
    this.asInstanceOf[ClientStatusPacketBuilder[P with ActionId]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ClientStatusPacket(actionId)
  }
}
object ClientStatusPacketBuilder {
  sealed trait ActionId
  type Complete = ClientStatusPacketBuilder with ActionId
}
