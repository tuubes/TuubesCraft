package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class SteerBoatPacket(var rightPaddleTurning: Boolean, var leftPaddleTurning: Boolean) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putBoolean(rightPaddleTurning)
    out.putBoolean(leftPaddleTurning)
  }
	
  override def id = SteerBoatPacket.id

	
}
object SteerBoatPacket extends PacketObj[SteerBoatPacket] {
  override val id = 18
	
  override def read(in: NiolOutput): SteerBoatPacket {
    val rightPaddleTurning = in.getBoolean()
    val leftPaddleTurning = in.getBoolean()
    new SteerBoatPacket(rightPaddleTurning, leftPaddleTurning)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SteerBoatPacketBuilder[P <: SteerBoatPacket] extends PacketBuilder[SteerBoatPacket, Complete] {
  private[this] var rightPaddleTurning: Boolean = _
  private[this] var leftPaddleTurning: Boolean = _

  def withRightPaddleTurning(rightPaddleTurning: Boolean): SteerBoatPacketBuilder[P with RightPaddleTurning] = {
    this.rightPaddleTurning = rightPaddleTurning
    this.asInstanceOf[SteerBoatPacketBuilder[P with RightPaddleTurning]]
  }

  def withLeftPaddleTurning(leftPaddleTurning: Boolean): SteerBoatPacketBuilder[P with LeftPaddleTurning] = {
    this.leftPaddleTurning = leftPaddleTurning
    this.asInstanceOf[SteerBoatPacketBuilder[P with LeftPaddleTurning]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new SteerBoatPacket(rightPaddleTurning, leftPaddleTurning)
  }
}
object SteerBoatPacketBuilder {
  sealed trait RightPaddleTurning
  sealed trait LeftPaddleTurning
  type Complete = SteerBoatPacketBuilder with RightPaddleTurning with LeftPaddleTurning
}