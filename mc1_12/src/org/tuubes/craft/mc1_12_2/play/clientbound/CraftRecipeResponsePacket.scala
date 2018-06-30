package org.tuubes.craft.mc1_12_2.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import org.tuubes.core.network._
import CraftRecipeResponsePacketBuilder._

/** Packet class auto-generated by DataTractor */
final class CraftRecipeResponsePacket(var windowId: Byte, var recipe: Int) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putByte(windowId)
    out.putVarint(recipe)
  }
	
  override def id = CraftRecipeResponsePacket.id

	
}
object CraftRecipeResponsePacket extends PacketObj[CraftAttach, CraftRecipeResponsePacket] {
  override val id = 43
	
  override def read(in: NiolInput): CraftRecipeResponsePacket = {
    val windowId = in.getByte()
    val recipe = in.getVarint()
    new CraftRecipeResponsePacket(windowId, recipe)
  }
}
/** Packet builder auto-generated by DataTractor */
final class CraftRecipeResponsePacketBuilder[P <: CraftRecipeResponsePacket] extends PacketBuilder[CraftRecipeResponsePacket, P =:= Complete] {
  private[this] var windowId: Byte = _
  private[this] var recipe: Int = _

  def withWindowId(windowId: Byte): CraftRecipeResponsePacketBuilder[P with WindowId] = {
    this.windowId = windowId
    this.asInstanceOf[CraftRecipeResponsePacketBuilder[P with WindowId]]
  }

  def withRecipe(recipe: Int): CraftRecipeResponsePacketBuilder[P with Recipe] = {
    this.recipe = recipe
    this.asInstanceOf[CraftRecipeResponsePacketBuilder[P with Recipe]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new CraftRecipeResponsePacket(windowId, recipe)
  }
}
object CraftRecipeResponsePacketBuilder {
  sealed trait WindowId
  sealed trait Recipe
  type Complete = CraftRecipeResponsePacket with WindowId with Recipe
}