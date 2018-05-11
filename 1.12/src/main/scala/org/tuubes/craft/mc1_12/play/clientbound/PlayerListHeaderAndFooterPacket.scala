package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class PlayerListHeaderAndFooterPacket(var header: String, var footer: String) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(header, UTF_8)
    out.putVarstring(footer, UTF_8)
  }
	
  override def id = PlayerListHeaderAndFooterPacket.id

	
}
object PlayerListHeaderAndFooterPacket extends PacketObj[PlayerListHeaderAndFooterPacket] {
  override val id = 73
	
  override def read(in: NiolOutput): PlayerListHeaderAndFooterPacket {
    val header = in.getVarstring(UTF_8)
    val footer = in.getVarstring(UTF_8)
    new PlayerListHeaderAndFooterPacket(header, footer)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PlayerListHeaderAndFooterPacketBuilder[P <: PlayerListHeaderAndFooterPacket] extends PacketBuilder[PlayerListHeaderAndFooterPacket, Complete] {
  private[this] var header: String = _
  private[this] var footer: String = _

  def withHeader(header: String): PlayerListHeaderAndFooterPacketBuilder[P with Header] = {
    this.header = header
    this.asInstanceOf[PlayerListHeaderAndFooterPacketBuilder[P with Header]]
  }

  def withFooter(footer: String): PlayerListHeaderAndFooterPacketBuilder[P with Footer] = {
    this.footer = footer
    this.asInstanceOf[PlayerListHeaderAndFooterPacketBuilder[P with Footer]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new PlayerListHeaderAndFooterPacket(header, footer)
  }
}
object PlayerListHeaderAndFooterPacketBuilder {
  sealed trait Header
  sealed trait Footer
  type Complete = PlayerListHeaderAndFooterPacketBuilder with Header with Footer
}