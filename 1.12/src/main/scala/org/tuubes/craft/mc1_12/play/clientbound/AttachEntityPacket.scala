package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import AttachEntityPacketBuilder._

/** Packet class auto-generated by DataTractor */
final class AttachEntityPacket(var attachedEntityId: Int, var holdingEntityId: Int) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putInt(attachedEntityId)
    out.putInt(holdingEntityId)
  }
	
  override def obj = AttachEntityPacket

	
}
object AttachEntityPacket extends PacketObj[CraftAttach, AttachEntityPacket] {
  override val id = 60
	
  override def read(in: NiolInput): AttachEntityPacket = {
    val attachedEntityId = in.getInt()
    val holdingEntityId = in.getInt()
    new AttachEntityPacket(attachedEntityId, holdingEntityId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class AttachEntityPacketBuilder[P <: AttachEntityPacket] extends PacketBuilder[AttachEntityPacket, P =:= Complete] {
  private[this] var attachedEntityId: Int = _
  private[this] var holdingEntityId: Int = _

  def withAttachedEntityId(attachedEntityId: Int): AttachEntityPacketBuilder[P with AttachedEntityId] = {
    this.attachedEntityId = attachedEntityId
    this.asInstanceOf[AttachEntityPacketBuilder[P with AttachedEntityId]]
  }

  def withHoldingEntityId(holdingEntityId: Int): AttachEntityPacketBuilder[P with HoldingEntityId] = {
    this.holdingEntityId = holdingEntityId
    this.asInstanceOf[AttachEntityPacketBuilder[P with HoldingEntityId]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new AttachEntityPacket(attachedEntityId, holdingEntityId)
  }
}
object AttachEntityPacketBuilder {
  sealed trait AttachedEntityId
  sealed trait HoldingEntityId
  type Complete = AttachEntityPacket with AttachedEntityId with HoldingEntityId
}
