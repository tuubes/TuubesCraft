package org.tuubes.craft.mc1_12.play.clientbound

import java.nio.charset.StandardCharsets.UTF_8
import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class DisplayScoreboardPacket(var position: Byte, var scoreName: String) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putByte(position)
    out.putVarstring(scoreName, UTF_8)
  }
	
  override def obj = DisplayScoreboardPacket

	
}
object DisplayScoreboardPacket extends PacketObj[DisplayScoreboardPacket] {
  override val id = 58
	
  override def read(in: NiolOutput): DisplayScoreboardPacket = {
    val position = in.getByte()
    val scoreName = in.getVarstring(UTF_8)
    new DisplayScoreboardPacket(position, scoreName)
  }
}
/** Packet builder auto-generated by DataTractor */
final class DisplayScoreboardPacketBuilder[P <: DisplayScoreboardPacket] extends PacketBuilder[DisplayScoreboardPacket, Complete] {
  private[this] var position: Byte = _
  private[this] var scoreName: String = _

  def withPosition(position: Byte): DisplayScoreboardPacketBuilder[P with Position] = {
    this.position = position
    this.asInstanceOf[DisplayScoreboardPacketBuilder[P with Position]]
  }

  def withScoreName(scoreName: String): DisplayScoreboardPacketBuilder[P with ScoreName] = {
    this.scoreName = scoreName
    this.asInstanceOf[DisplayScoreboardPacketBuilder[P with ScoreName]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new DisplayScoreboardPacket(position, scoreName)
  }
}
object DisplayScoreboardPacketBuilder {
  sealed trait Position
  sealed trait ScoreName
  type Complete = DisplayScoreboardPacketBuilder with Position with ScoreName
}
