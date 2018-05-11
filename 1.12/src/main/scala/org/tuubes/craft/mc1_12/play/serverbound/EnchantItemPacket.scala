package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class EnchantItemPacket(var windowId: Byte, var enchantment: Byte) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putByte(windowId)
    out.putByte(enchantment)
  }
	
  override def id = EnchantItemPacket.id

	
}
object EnchantItemPacket extends PacketObj[EnchantItemPacket] {
  override val id = 7
	
  override def read(in: NiolOutput): EnchantItemPacket {
    val windowId = in.getByte()
    val enchantment = in.getByte()
    new EnchantItemPacket(windowId, enchantment)
  }
}
/** Packet builder auto-generated by DataTractor */
final class EnchantItemPacketBuilder[P <: EnchantItemPacket] extends PacketBuilder[EnchantItemPacket, Complete] {
  private[this] var windowId: Byte = _
  private[this] var enchantment: Byte = _

  def withWindowId(windowId: Byte): EnchantItemPacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[EnchantItemPacketBuilder[P with WindowId]]
  }

  def withEnchantment(enchantment: Byte): EnchantItemPacketBuilder[P with Enchantment] = {
    this.enchantment = enchantment
    this.asInstanceOf[EnchantItemPacketBuilder[P with Enchantment]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new EnchantItemPacket(windowId, enchantment)
  }
}
object EnchantItemPacketBuilder {
  sealed trait WindowId
  sealed trait Enchantment
  type Complete = EnchantItemPacketBuilder with WindowId with Enchantment
}
