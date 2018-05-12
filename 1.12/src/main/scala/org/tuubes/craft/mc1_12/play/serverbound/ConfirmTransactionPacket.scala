package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import ConfirmTransactionPacketBuilder._

/** Packet class auto-generated by DataTractor */
final class ConfirmTransactionPacket(var windowId: Byte, var actionNumber: Short, var accepted: Boolean) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putByte(windowId)
    out.putShort(actionNumber)
    out.putBoolean(accepted)
  }
	
  override def obj = ConfirmTransactionPacket

	
}
object ConfirmTransactionPacket extends PacketObj[CraftAttach, ConfirmTransactionPacket] {
  override val id = 6
	
  override def read(in: NiolInput): ConfirmTransactionPacket = {
    val windowId = in.getByte()
    val actionNumber = in.getShort()
    val accepted = in.getBoolean()
    new ConfirmTransactionPacket(windowId, actionNumber, accepted)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ConfirmTransactionPacketBuilder[P <: ConfirmTransactionPacket] extends PacketBuilder[ConfirmTransactionPacket, P =:= Complete] {
  private[this] var windowId: Byte = _
  private[this] var actionNumber: Short = _
  private[this] var accepted: Boolean = _

  def withWindowId(windowId: Byte): ConfirmTransactionPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[ConfirmTransactionPacketBuilder[P with WindowId]]
  }

  def withActionNumber(actionNumber: Short): ConfirmTransactionPacketBuilder[P with ActionNumber] = {
    this.actionNumber = actionNumber
    this.asInstanceOf[ConfirmTransactionPacketBuilder[P with ActionNumber]]
  }

  def withAccepted(accepted: Boolean): ConfirmTransactionPacketBuilder[P with Accepted] = {
    this.accepted = accepted
    this.asInstanceOf[ConfirmTransactionPacketBuilder[P with Accepted]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ConfirmTransactionPacket(windowId, actionNumber, accepted)
  }
}
object ConfirmTransactionPacketBuilder {
  sealed trait WindowId
  sealed trait ActionNumber
  sealed trait Accepted
  type Complete = ConfirmTransactionPacket with WindowId with ActionNumber with Accepted
}
