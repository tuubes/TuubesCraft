package org.tuubes.craft.mc1_12.play.serverbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}

/** Packet class auto-generated by DataTractor */
final class SteerVehiclePacket(var sideways: Float, var forward: Float, var flags: Int) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putFloat(sideways)
    out.putFloat(forward)
    out.putInt(flags)
  }
	
  override def obj = SteerVehiclePacket

	
}
object SteerVehiclePacket extends PacketObj[SteerVehiclePacket] {
  override val id = 22
	
  override def read(in: NiolOutput): SteerVehiclePacket = {
    val sideways = in.getFloat()
    val forward = in.getFloat()
    val flags = in.getUnsignedByte()
    new SteerVehiclePacket(sideways, forward, flags)
  }
}
/** Packet builder auto-generated by DataTractor */
final class SteerVehiclePacketBuilder[P <: SteerVehiclePacket] extends PacketBuilder[SteerVehiclePacket, Complete] {
  private[this] var sideways: Float = _
  private[this] var forward: Float = _
  private[this] var flags: Int = _

  def withSideways(sideways: Float): SteerVehiclePacketBuilder[P with Sideways] = {
    this.sideways = sideways
    this.asInstanceOf[SteerVehiclePacketBuilder[P with Sideways]]
  }

  def withForward(forward: Float): SteerVehiclePacketBuilder[P with Forward] = {
    this.forward = forward
    this.asInstanceOf[SteerVehiclePacketBuilder[P with Forward]]
  }

  def withFlags(flags: Int): SteerVehiclePacketBuilder[P with Flags] = {
    this.flags = flags
    this.asInstanceOf[SteerVehiclePacketBuilder[P with Flags]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new SteerVehiclePacket(sideways, forward, flags)
  }
}
object SteerVehiclePacketBuilder {
  sealed trait Sideways
  sealed trait Forward
  sealed trait Flags
  type Complete = SteerVehiclePacketBuilder with Sideways with Forward with Flags
}
