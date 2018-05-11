package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class ClickWindowPacket(var windowId: Int, var slot: Short, var button: Byte, var actionNumber: Short, var mode: Int, var clickedItem: AnyRef) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putInt(windowId)
    out.putShort(slot)
    out.putByte(button)
    out.putShort(actionNumber)
    out.putVarint(mode)
    // TODO write clickedItem
  }
	
  override def id = ClickWindowPacket.id

	
}
object ClickWindowPacket extends PacketObj[ClickWindowPacket] {
  override val id = 8
	
  override def read(in: NiolOutput): ClickWindowPacket {
    val windowId = in.getUnsignedByte()
    val slot = in.getShort()
    val button = in.getByte()
    val actionNumber = in.getShort()
    val mode = in.getVarint()
    // TODO read clickedItem
    new ClickWindowPacket(windowId, slot, button, actionNumber, mode, clickedItem)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ClickWindowPacketBuilder[P <: ClickWindowPacket] extends PacketBuilder[ClickWindowPacket, Complete] {
  private[this] var windowId: Int = _
  private[this] var slot: Short = _
  private[this] var button: Byte = _
  private[this] var actionNumber: Short = _
  private[this] var mode: Int = _
  private[this] var clickedItem: AnyRef = _

  def withWindowId(windowId: Int): ClickWindowPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[ClickWindowPacketBuilder[P with WindowId]]
  }

  def withSlot(slot: Short): ClickWindowPacketBuilder[P with Slot] = {
    this.slot = slot
    this.asInstanceOf[ClickWindowPacketBuilder[P with Slot]]
  }

  def withButton(button: Byte): ClickWindowPacketBuilder[P with Button] = {
    this.button = button
    this.asInstanceOf[ClickWindowPacketBuilder[P with Button]]
  }

  def withActionNumber(actionNumber: Short): ClickWindowPacketBuilder[P with ActionNumber] = {
    this.actionNumber = actionNumber
    this.asInstanceOf[ClickWindowPacketBuilder[P with ActionNumber]]
  }

  def withMode(mode: Int): ClickWindowPacketBuilder[P with Mode] = {
    this.mode = mode
    this.asInstanceOf[ClickWindowPacketBuilder[P with Mode]]
  }

  def withClickedItem(clickedItem: AnyRef): ClickWindowPacketBuilder[P with ClickedItem] = {
    this.clickedItem = clickedItem
    this.asInstanceOf[ClickWindowPacketBuilder[P with ClickedItem]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new ClickWindowPacket(windowId, slot, button, actionNumber, mode, clickedItem)
  }
}
object ClickWindowPacketBuilder {
  sealed trait WindowId
  sealed trait Slot
  sealed trait Button
  sealed trait ActionNumber
  sealed trait Mode
  sealed trait ClickedItem
  type Complete = ClickWindowPacketBuilder with WindowId with Slot with Button with ActionNumber with Mode with ClickedItem
}
