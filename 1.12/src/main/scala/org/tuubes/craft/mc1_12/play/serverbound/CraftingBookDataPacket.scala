package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class CraftingBookDataPacket(var type: Int, var recipeId: Int, var craftingBookOpen: Boolean, var craftingFilter: Boolean) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(type)
    out.putInt(recipeId)
    out.putBoolean(craftingBookOpen)
    out.putBoolean(craftingFilter)
  }
	
  override def id = CraftingBookDataPacket.id

	
}
object CraftingBookDataPacket extends PacketObj[CraftingBookDataPacket] {
  override val id = 23
	
  override def read(in: NiolOutput): CraftingBookDataPacket {
    val type = in.getVarint()
    val recipeId = in.getInt()
    val craftingBookOpen = in.getBoolean()
    val craftingFilter = in.getBoolean()
    new CraftingBookDataPacket(type, recipeId, craftingBookOpen, craftingFilter)
  }
}
/** Packet builder auto-generated by DataTractor */
final class CraftingBookDataPacketBuilder[P <: CraftingBookDataPacket] extends PacketBuilder[CraftingBookDataPacket, Complete] {
  private[this] var type: Int = _
  private[this] var recipeId: Int = _
  private[this] var craftingBookOpen: Boolean = _
  private[this] var craftingFilter: Boolean = _

  def withType(type: Int): CraftingBookDataPacketBuilder[P with Type] = {
    this.type = type
    this.asInstanceOf[CraftingBookDataPacketBuilder[P with Type]]
  }

  def withRecipeId(recipeId: Int): CraftingBookDataPacketBuilder[P with RecipeId] = {
    this.recipeId = recipeId
    this.asInstanceOf[CraftingBookDataPacketBuilder[P with RecipeId]]
  }

  def withCraftingBookOpen(craftingBookOpen: Boolean): CraftingBookDataPacketBuilder[P with CraftingBookOpen] = {
    this.craftingBookOpen = craftingBookOpen
    this.asInstanceOf[CraftingBookDataPacketBuilder[P with CraftingBookOpen]]
  }

  def withCraftingFilter(craftingFilter: Boolean): CraftingBookDataPacketBuilder[P with CraftingFilter] = {
    this.craftingFilter = craftingFilter
    this.asInstanceOf[CraftingBookDataPacketBuilder[P with CraftingFilter]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new CraftingBookDataPacket(type, recipeId, craftingBookOpen, craftingFilter)
  }
}
object CraftingBookDataPacketBuilder {
  sealed trait Type
  sealed trait RecipeId
  sealed trait CraftingBookOpen
  sealed trait CraftingFilter
  type Complete = CraftingBookDataPacketBuilder with Type with RecipeId with CraftingBookOpen with CraftingFilter
}
