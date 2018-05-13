package org.tuubes.craft.mc1_12_2.play.serverbound

import AnimationPacketBuilder._
import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class AnimationPacket(var hand: Int) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(hand)
  }
	
  override def id = AnimationPacket.id

	
}
object AnimationPacket extends PacketObj[CraftAttach, AnimationPacket] {
  override val id = 29
	
  override def read(in: NiolInput): AnimationPacket = {
    val hand = in.getVarint()
    new AnimationPacket(hand)
  }
}
/** Packet builder auto-generated by DataTractor */
final class AnimationPacketBuilder[P <: AnimationPacket] extends PacketBuilder[AnimationPacket, P =:= Complete] {
  private[this] var hand: Int = _

  def withHand(hand: Int): AnimationPacketBuilder[P with Hand] = {
    this.hand = hand
    this.asInstanceOf[AnimationPacketBuilder[P with Hand]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new AnimationPacket(hand)
  }
}
object AnimationPacketBuilder {
  sealed trait Hand
  type Complete = AnimationPacket with Hand
}