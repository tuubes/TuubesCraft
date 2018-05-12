package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import CloseWindowPacketBuilder._

/** Packet class auto-generated by DataTractor */
final class CloseWindowPacket(var windowId: Int) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putInt(windowId)
  }
	
  override def obj = CloseWindowPacket

	
}
object CloseWindowPacket extends PacketObj[CraftAttach, CloseWindowPacket] {
  override val id = 18
	
  override def read(in: NiolInput): CloseWindowPacket = {
    val windowId = in.getUnsignedByte()
    new CloseWindowPacket(windowId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class CloseWindowPacketBuilder[P <: CloseWindowPacket] extends PacketBuilder[CloseWindowPacket, P =:= Complete] {
  private[this] var windowId: Int = _

  def withWindowId(windowId: Int): CloseWindowPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[CloseWindowPacketBuilder[P with WindowId]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new CloseWindowPacket(windowId)
  }
}
object CloseWindowPacketBuilder {
  sealed trait WindowId
  type Complete = CloseWindowPacket with WindowId
}
