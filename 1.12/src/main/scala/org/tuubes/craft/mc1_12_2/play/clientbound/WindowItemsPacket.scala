package org.tuubes.craft.mc1_12_2.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import WindowItemsPacketBuilder._
import org.tuubes.craft.CraftAttach
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class WindowItemsPacket(var windowId: Int, var slotData: Array[AnyRef]) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putInt(windowId)
    out.putShort(slotData.length)
    var i_slotData = 0
    while (i_slotData < slotData.length) {
      // TODO write slotData(i_slotData)
      i_slotData += 1
    }
  }
	
  override def id = WindowItemsPacket.id

	
}
object WindowItemsPacket extends PacketObj[CraftAttach, WindowItemsPacket] {
  override val id = 20
	
  override def read(in: NiolInput): WindowItemsPacket = {
    val windowId = in.getUnsignedByte()
    val slotDataLength = in.getShort()
    var i_slotData = 0
    val slotData = new Array[AnyRef](slotDataLength)
    while (i_slotData < slotDataLength) {
      // TODO read slotData(i_slotData)
      i_slotData += 1
    }
    new WindowItemsPacket(windowId, slotData)
  }
}
/** Packet builder auto-generated by DataTractor */
final class WindowItemsPacketBuilder[P <: WindowItemsPacket] extends PacketBuilder[WindowItemsPacket, P =:= Complete] {
  private[this] var windowId: Int = _
  private[this] var slotData: Array[AnyRef] = _

  def withWindowId(windowId: Int): WindowItemsPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[WindowItemsPacketBuilder[P with WindowId]]
  }

  def withSlotData(slotData: Array[AnyRef]): WindowItemsPacketBuilder[P with SlotData] = {
    this.slotData = slotData
    this.asInstanceOf[WindowItemsPacketBuilder[P with SlotData]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new WindowItemsPacket(windowId, slotData)
  }
}
object WindowItemsPacketBuilder {
  sealed trait WindowId
  sealed trait SlotData
  type Complete = WindowItemsPacket with WindowId with SlotData
}