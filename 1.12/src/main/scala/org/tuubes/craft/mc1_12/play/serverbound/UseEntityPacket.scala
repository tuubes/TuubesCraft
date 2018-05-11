package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class UseEntityPacket(var target: Int, var type: Int, var targetX: Option[Float], var targetY: Option[Float], var targetZ: Option[Float], var hand: Option[Int]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarint(target)
    out.putVarint(type)
    if (targetX.isDefined) {
      out.putFloat(targetX)
    }
    if (targetY.isDefined) {
      out.putFloat(targetY)
    }
    if (targetZ.isDefined) {
      out.putFloat(targetZ)
    }
    if (hand.isDefined) {
      out.putVarint(hand)
    }
  }
	
  override def id = UseEntityPacket.id

	
}
object UseEntityPacket extends PacketObj[UseEntityPacket] {
  override val id = 11
	
  override def read(in: NiolOutput): UseEntityPacket {
    val target = in.getVarint()
    val type = in.getVarint()
    // TODO read targetX
    // TODO read targetY
    // TODO read targetZ
    // TODO read hand
    new UseEntityPacket(target, type, targetX, targetY, targetZ, hand)
  }
}
/** Packet builder auto-generated by DataTractor */
final class UseEntityPacketBuilder[P <: UseEntityPacket] extends PacketBuilder[UseEntityPacket, Complete] {
  private[this] var target: Int = _
  private[this] var type: Int = _
  private[this] var targetX: Option[Float] = _
  private[this] var targetY: Option[Float] = _
  private[this] var targetZ: Option[Float] = _
  private[this] var hand: Option[Int] = _

  def withTarget(target: Int): UseEntityPacketBuilder[P with Target] = {
    this.target = target
    this.asInstanceOf[UseEntityPacketBuilder[P with Target]]
  }

  def withType(type: Int): UseEntityPacketBuilder[P with Type] = {
    this.type = type
    this.asInstanceOf[UseEntityPacketBuilder[P with Type]]
  }

  def withTargetX(targetX: Option[Float]): UseEntityPacketBuilder[P with TargetX] = {
    this.targetX = targetX
    this.asInstanceOf[UseEntityPacketBuilder[P with TargetX]]
  }

  def withTargetY(targetY: Option[Float]): UseEntityPacketBuilder[P with TargetY] = {
    this.targetY = targetY
    this.asInstanceOf[UseEntityPacketBuilder[P with TargetY]]
  }

  def withTargetZ(targetZ: Option[Float]): UseEntityPacketBuilder[P with TargetZ] = {
    this.targetZ = targetZ
    this.asInstanceOf[UseEntityPacketBuilder[P with TargetZ]]
  }

  def withHand(hand: Option[Int]): UseEntityPacketBuilder[P with Hand] = {
    this.hand = hand
    this.asInstanceOf[UseEntityPacketBuilder[P with Hand]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new UseEntityPacket(target, type, targetX, targetY, targetZ, hand)
  }
}
object UseEntityPacketBuilder {
  sealed trait Target
  sealed trait Type
  sealed trait TargetX
  sealed trait TargetY
  sealed trait TargetZ
  sealed trait Hand
  type Complete = UseEntityPacketBuilder with Target with Type with TargetX with TargetY with TargetZ with Hand
}
