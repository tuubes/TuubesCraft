package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import AdvancementTabPacketBuilder._
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach

/** Packet class auto-generated by DataTractor */
final class AdvancementTabPacket(var action: Int, var tabId: Option[String]) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(action)
    if (tabId.isDefined) {
      out.putVarstring(tabId, UTF_8)
    }
  }
	
  override def obj = AdvancementTabPacket

	
}
object AdvancementTabPacket extends PacketObj[CraftAttach, AdvancementTabPacket] {
  override val id = 25
	
  override def read(in: NiolInput): AdvancementTabPacket = {
    val action = in.getVarint()
    // TODO read tabId
    new AdvancementTabPacket(action, tabId)
  }
}
/** Packet builder auto-generated by DataTractor */
final class AdvancementTabPacketBuilder[P <: AdvancementTabPacket] extends PacketBuilder[AdvancementTabPacket, P =:= Complete] {
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

  override def build()(implicit evidence: P =:= Complete) = {
    new AdvancementTabPacket(action, tabId)
  }
}
object AdvancementTabPacketBuilder {
  sealed trait Action
  sealed trait TabId
  type Complete = AdvancementTabPacket with Action with TabId
}
