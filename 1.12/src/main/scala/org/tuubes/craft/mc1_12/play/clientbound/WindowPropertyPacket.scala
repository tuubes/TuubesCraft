package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import WindowPropertyPacketBuilder._
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class WindowPropertyPacket(var windowId: Int, var property: Short, var value: Short) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putInt(windowId)
    out.putShort(property)
    out.putShort(value)
  }
	
  override def obj = WindowPropertyPacket

	
}
object WindowPropertyPacket extends PacketObj[CraftAttach, WindowPropertyPacket] {
  override val id = 21
	
  override def read(in: NiolInput): WindowPropertyPacket = {
    val windowId = in.getUnsignedByte()
    val property = in.getShort()
    val value = in.getShort()
    new WindowPropertyPacket(windowId, property, value)
  }
}
/** Packet builder auto-generated by DataTractor */
final class WindowPropertyPacketBuilder[P <: WindowPropertyPacket] extends PacketBuilder[WindowPropertyPacket, P =:= Complete] {
  private[this] var windowId: Int = _
  private[this] var property: Short = _
  private[this] var value: Short = _

  def withWindowId(windowId: Int): WindowPropertyPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[WindowPropertyPacketBuilder[P with WindowId]]
  }

  def withProperty(property: Short): WindowPropertyPacketBuilder[P with Property] = {
    this.property = property
    this.asInstanceOf[WindowPropertyPacketBuilder[P with Property]]
  }

  def withValue(value: Short): WindowPropertyPacketBuilder[P with Value] = {
    this.value = value
    this.asInstanceOf[WindowPropertyPacketBuilder[P with Value]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new WindowPropertyPacket(windowId, property, value)
  }
}
object WindowPropertyPacketBuilder {
  sealed trait WindowId
  sealed trait Property
  sealed trait Value
  type Complete = WindowPropertyPacket with WindowId with Property with Value
}
