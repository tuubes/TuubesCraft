package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import ServerDifficultyPacketBuilder._
import org.tuubes.craft.CraftAttach

/** Packet class auto-generated by DataTractor */
final class ServerDifficultyPacket(var difficulty: Int) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putInt(difficulty)
  }
	
  override def obj = ServerDifficultyPacket

	
}
object ServerDifficultyPacket extends PacketObj[CraftAttach, ServerDifficultyPacket] {
  override val id = 13
	
  override def read(in: NiolInput): ServerDifficultyPacket = {
    val difficulty = in.getUnsignedByte()
    new ServerDifficultyPacket(difficulty)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ServerDifficultyPacketBuilder[P <: ServerDifficultyPacket] extends PacketBuilder[ServerDifficultyPacket, P =:= Complete] {
  private[this] var difficulty: Int = _

  def withDifficulty(difficulty: Int): ServerDifficultyPacketBuilder[P with Difficulty] = {
    this.difficulty = difficulty
    this.asInstanceOf[ServerDifficultyPacketBuilder[P with Difficulty]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ServerDifficultyPacket(difficulty)
  }
}
object ServerDifficultyPacketBuilder {
  sealed trait Difficulty
  type Complete = ServerDifficultyPacket with Difficulty
}
