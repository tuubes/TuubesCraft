package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class TabCompletePacket(var text: String, var assumeCommand: Boolean, var hasPosition: Boolean, var lookedAtBlock: Option[Long]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(text, UTF_8)
    out.putBoolean(assumeCommand)
    out.putBoolean(hasPosition)
    if (lookedAtBlock.isDefined) {
      out.putLong(lookedAtBlock)
    }
  }
	
  override def id = TabCompletePacket.id

	
}
object TabCompletePacket extends PacketObj[TabCompletePacket] {
  override val id = 2
	
  override def read(in: NiolOutput): TabCompletePacket {
    val text = in.getVarstring(UTF_8)
    val assumeCommand = in.getBoolean()
    val hasPosition = in.getBoolean()
    // TODO read lookedAtBlock
    new TabCompletePacket(text, assumeCommand, hasPosition, lookedAtBlock)
  }
}
/** Packet builder auto-generated by DataTractor */
final class TabCompletePacketBuilder[P <: TabCompletePacket] extends PacketBuilder[TabCompletePacket, Complete] {
  private[this] var text: String = _
  private[this] var assumeCommand: Boolean = _
  private[this] var hasPosition: Boolean = _
  private[this] var lookedAtBlock: Option[Long] = _

  def withText(text: String): TabCompletePacketBuilder[P with Text] = {
    this.text = text
    this.asInstanceOf[TabCompletePacketBuilder[P with Text]]
  }

  def withAssumeCommand(assumeCommand: Boolean): TabCompletePacketBuilder[P with AssumeCommand] = {
    this.assumeCommand = assumeCommand
    this.asInstanceOf[TabCompletePacketBuilder[P with AssumeCommand]]
  }

  def withHasPosition(hasPosition: Boolean): TabCompletePacketBuilder[P with HasPosition] = {
    this.hasPosition = hasPosition
    this.asInstanceOf[TabCompletePacketBuilder[P with HasPosition]]
  }

  def withLookedAtBlock(lookedAtBlock: Option[Long]): TabCompletePacketBuilder[P with LookedAtBlock] = {
    this.lookedAtBlock = lookedAtBlock
    this.asInstanceOf[TabCompletePacketBuilder[P with LookedAtBlock]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new TabCompletePacket(text, assumeCommand, hasPosition, lookedAtBlock)
  }
}
object TabCompletePacketBuilder {
  sealed trait Text
  sealed trait AssumeCommand
  sealed trait HasPosition
  sealed trait LookedAtBlock
  type Complete = TabCompletePacketBuilder with Text with AssumeCommand with HasPosition with LookedAtBlock
}