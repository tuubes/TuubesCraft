package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class PrepareCraftingGridPacket(var windowId: Byte, var actionNumber: Short, var arraySize: Short, var item: AnyRef, var craftingSlot: Byte, var playerSlot: Byte, var arraySize: Short, var item: AnyRef, var craftingSlot: Byte, var playerSlot: Byte) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putByte(windowId)
    out.putShort(actionNumber)
    out.putShort(arraySize)
    // TODO write item
    out.putByte(craftingSlot)
    out.putByte(playerSlot)
    out.putShort(arraySize)
    // TODO write item
    out.putByte(craftingSlot)
    out.putByte(playerSlot)
  }
	
  override def id = PrepareCraftingGridPacket.id

	
}
object PrepareCraftingGridPacket extends PacketObj[PrepareCraftingGridPacket] {
  override val id = 1
	
  override def read(in: NiolOutput): PrepareCraftingGridPacket {
    val windowId = in.getByte()
    val actionNumber = in.getShort()
    val arraySize = in.getShort()
    // TODO read item
    val craftingSlot = in.getByte()
    val playerSlot = in.getByte()
    val arraySize = in.getShort()
    // TODO read item
    val craftingSlot = in.getByte()
    val playerSlot = in.getByte()
    new PrepareCraftingGridPacket(windowId, actionNumber, arraySize, item, craftingSlot, playerSlot, arraySize, item, craftingSlot, playerSlot)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PrepareCraftingGridPacketBuilder[P <: PrepareCraftingGridPacket] extends PacketBuilder[PrepareCraftingGridPacket, Complete] {
  private[this] var windowId: Byte = _
  private[this] var actionNumber: Short = _
  private[this] var arraySize: Short = _
  private[this] var item: AnyRef = _
  private[this] var craftingSlot: Byte = _
  private[this] var playerSlot: Byte = _
  private[this] var arraySize: Short = _
  private[this] var item: AnyRef = _
  private[this] var craftingSlot: Byte = _
  private[this] var playerSlot: Byte = _

  def withWindowId(windowId: Byte): PrepareCraftingGridPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with WindowId]]
  }

  def withActionNumber(actionNumber: Short): PrepareCraftingGridPacketBuilder[P with ActionNumber] = {
    this.actionNumber = actionNumber
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with ActionNumber]]
  }

  def withArraySize(arraySize: Short): PrepareCraftingGridPacketBuilder[P with ArraySize] = {
    this.arraySize = arraySize
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with ArraySize]]
  }

  def withItem(item: AnyRef): PrepareCraftingGridPacketBuilder[P with Item] = {
    this.item = item
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with Item]]
  }

  def withCraftingSlot(craftingSlot: Byte): PrepareCraftingGridPacketBuilder[P with CraftingSlot] = {
    this.craftingSlot = craftingSlot
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with CraftingSlot]]
  }

  def withPlayerSlot(playerSlot: Byte): PrepareCraftingGridPacketBuilder[P with PlayerSlot] = {
    this.playerSlot = playerSlot
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with PlayerSlot]]
  }

  def withArraySize(arraySize: Short): PrepareCraftingGridPacketBuilder[P with ArraySize] = {
    this.arraySize = arraySize
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with ArraySize]]
  }

  def withItem(item: AnyRef): PrepareCraftingGridPacketBuilder[P with Item] = {
    this.item = item
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with Item]]
  }

  def withCraftingSlot(craftingSlot: Byte): PrepareCraftingGridPacketBuilder[P with CraftingSlot] = {
    this.craftingSlot = craftingSlot
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with CraftingSlot]]
  }

  def withPlayerSlot(playerSlot: Byte): PrepareCraftingGridPacketBuilder[P with PlayerSlot] = {
    this.playerSlot = playerSlot
    this.asInstanceOf[PrepareCraftingGridPacketBuilder[P with PlayerSlot]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new PrepareCraftingGridPacket(windowId, actionNumber, arraySize, item, craftingSlot, playerSlot, arraySize, item, craftingSlot, playerSlot)
  }
}
object PrepareCraftingGridPacketBuilder {
  sealed trait WindowId
  sealed trait ActionNumber
  sealed trait ArraySize
  sealed trait Item
  sealed trait CraftingSlot
  sealed trait PlayerSlot
  sealed trait ArraySize
  sealed trait Item
  sealed trait CraftingSlot
  sealed trait PlayerSlot
  type Complete = PrepareCraftingGridPacketBuilder with WindowId with ActionNumber with ArraySize with Item with CraftingSlot with PlayerSlot with ArraySize with Item with CraftingSlot with PlayerSlot
}