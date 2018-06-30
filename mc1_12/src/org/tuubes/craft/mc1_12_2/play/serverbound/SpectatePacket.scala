package org.tuubes.craft.mc1_12_2.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import SpectatePacketBuilder._
import org.tuubes.craft.CraftAttach
import java.util.UUID
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class SpectatePacket(var targetPlayer: UUID) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putLong(targetPlayer.getMostSignificantBits); out.putLong(targetPlayer.getLeastSignificantBits)
  }
	
  override def id = SpectatePacket.id

	
}
object SpectatePacket extends PacketObj[CraftAttach, SpectatePacket] {
  override val id = 30
	
  override def read(in: NiolInput): SpectatePacket = {
    val targetPlayer = new UUID(in.getLong(), in.getLong())
    new SpectatePacket(targetPlayer)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SpectatePacketBuilder[P <: SpectatePacket] extends PacketBuilder[SpectatePacket, P =:= Complete] {
  private[this] var targetPlayer: UUID = _

  def withTargetPlayer(targetPlayer: UUID): SpectatePacketBuilder[P with TargetPlayer] = {
    this.targetPlayer = targetPlayer
    this.asInstanceOf[SpectatePacketBuilder[P with TargetPlayer]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new SpectatePacket(targetPlayer)
  }
}
object SpectatePacketBuilder {
  sealed trait TargetPlayer
  type Complete = SpectatePacket with TargetPlayer
}