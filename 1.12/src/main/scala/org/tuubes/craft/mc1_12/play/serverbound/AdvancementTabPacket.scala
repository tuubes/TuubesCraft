package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class AdvancementTabPacket(var action: Int, var tabId: Option[String]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(action)
    if (tabId.isDefined) {
      out.putVarstring(tabId, UTF_8)
    }
  }
	
  override def id = AdvancementTabPacket.id

	
}
object AdvancementTabPacket extends PacketObj[AdvancementTabPacket] {
  override val id = 25
	
  override def read(in: NiolOutput): AdvancementTabPacket {
    val action = in.getVarint()
    // TODO read tabId
    new AdvancementTabPacket(action, tabId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class AdvancementTabPacketBuilder[P <: AdvancementTabPacket] extends PacketBuilder[AdvancementTabPacket, Complete] {
  private[this] var action: Int = _
  private[this] var tabId: Option[String] = _

  def withAction(action: Int): AdvancementTabPacketBuilder[P with Action] = {
    this.action = action
    this.asInstanceOf[AdvancementTabPacketBuilder[P with Action]]
  }

  def withTabId(tabId: Option[String]): AdvancementTabPacketBuilder[P with TabId] = {
    this.tabId = tabId
    this.asInstanceOf[AdvancementTabPacketBuilder[P with TabId]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new AdvancementTabPacket(action, tabId)
  }
}
object AdvancementTabPacketBuilder {
  sealed trait Action
  sealed trait TabId
  type Complete = AdvancementTabPacketBuilder with Action with TabId
}
