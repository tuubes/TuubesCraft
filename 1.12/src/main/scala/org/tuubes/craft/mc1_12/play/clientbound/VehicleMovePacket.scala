package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import VehicleMovePacketBuilder._

/** Packet class auto-generated by DataTractor */
final class VehicleMovePacket(var x: Double, var y: Double, var z: Double, var yaw: Float, var pitch: Float) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putDouble(x)
    out.putDouble(y)
    out.putDouble(z)
    out.putFloat(yaw)
    out.putFloat(pitch)
  }
	
  override def obj = VehicleMovePacket

	
}
object VehicleMovePacket extends PacketObj[CraftAttach, VehicleMovePacket] {
  override val id = 41
	
  override def read(in: NiolInput): VehicleMovePacket = {
    val x = in.getDouble()
    val y = in.getDouble()
    val z = in.getDouble()
    val yaw = in.getFloat()
    val pitch = in.getFloat()
    new VehicleMovePacket(x, y, z, yaw, pitch)
  }
}
/** Packet builder auto-generated by DataTractor */
final class VehicleMovePacketBuilder[P <: VehicleMovePacket] extends PacketBuilder[VehicleMovePacket, P =:= Complete] {
  private[this] var x: Double = _
  private[this] var y: Double = _
  private[this] var z: Double = _
  private[this] var yaw: Float = _
  private[this] var pitch: Float = _

  def withX(x: Double): VehicleMovePacketBuilder[P with X] = {
    this.x = x
    this.asInstanceOf[VehicleMovePacketBuilder[P with X]]
  }

  def withY(y: Double): VehicleMovePacketBuilder[P with Y] = {
    this.y = y
    this.asInstanceOf[VehicleMovePacketBuilder[P with Y]]
  }

  def withZ(z: Double): VehicleMovePacketBuilder[P with Z] = {
    this.z = z
    this.asInstanceOf[VehicleMovePacketBuilder[P with Z]]
  }

  def withYaw(yaw: Float): VehicleMovePacketBuilder[P with Yaw] = {
    this.yaw = yaw
    this.asInstanceOf[VehicleMovePacketBuilder[P with Yaw]]
  }

  def withPitch(pitch: Float): VehicleMovePacketBuilder[P with Pitch] = {
    this.pitch = pitch
    this.asInstanceOf[VehicleMovePacketBuilder[P with Pitch]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new VehicleMovePacket(x, y, z, yaw, pitch)
  }
}
object VehicleMovePacketBuilder {
  sealed trait X
  sealed trait Y
  sealed trait Z
  sealed trait Yaw
  sealed trait Pitch
  type Complete = VehicleMovePacket with X with Y with Z with Yaw with Pitch
}
