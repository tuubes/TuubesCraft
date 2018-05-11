package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class TabCompletePacket(var matches: Array[String]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(matches.length)
    var i_matches = 0
    while (i_matches < matches.length) {
      out.putVarstring(matches(i_matches), UTF_8)
      i_matches += 1
    }
  }
	
  override def id = TabCompletePacket.id

	
}
object TabCompletePacket extends PacketObj[TabCompletePacket] {
  override val id = 14
	
  override def read(in: NiolOutput): TabCompletePacket {
    val matchesLength = in.getVarint()
    var i_matches = 0
    val matches = new Array[String](matchesLength)
    while (i_matches < matchesLength) {
      matches(i_matches) = in.getVarstring(UTF_8)
      i_matches += 1
    }
    new TabCompletePacket(matches)
  }
}
/** Packet builder auto-generated by DataTractor */
final class TabCompletePacketBuilder[P <: TabCompletePacket] extends PacketBuilder[TabCompletePacket, Complete] {
  private[this] var matches: Array[String] = _

  def withMatches(matches: Array[String]): TabCompletePacketBuilder[P with Matches] = {
    this.matches = matches
    this.asInstanceOf[TabCompletePacketBuilder[P with Matches]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new TabCompletePacket(matches)
  }
}
object TabCompletePacketBuilder {
  sealed trait Matches
  type Complete = TabCompletePacketBuilder with Matches
}