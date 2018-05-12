package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import PlayerAbilitiesPacketBuilder._

/** Packet class auto-generated by DataTractor */
final class PlayerAbilitiesPacket(var flags: Byte, var flyingSpeed: Float, var fieldOfViewModifier: Float) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putByte(flags)
    out.putFloat(flyingSpeed)
    out.putFloat(fieldOfViewModifier)
  }
	
  override def obj = PlayerAbilitiesPacket

	
}
object PlayerAbilitiesPacket extends PacketObj[CraftAttach, PlayerAbilitiesPacket] {
  override val id = 43
	
  override def read(in: NiolInput): PlayerAbilitiesPacket = {
    val flags = in.getByte()
    val flyingSpeed = in.getFloat()
    val fieldOfViewModifier = in.getFloat()
    new PlayerAbilitiesPacket(flags, flyingSpeed, fieldOfViewModifier)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PlayerAbilitiesPacketBuilder[P <: PlayerAbilitiesPacket] extends PacketBuilder[PlayerAbilitiesPacket, P =:= Complete] {
  private[this] var flags: Byte = _
  private[this] var flyingSpeed: Float = _
  private[this] var fieldOfViewModifier: Float = _

  def withFlags(flags: Byte): PlayerAbilitiesPacketBuilder[P with Flags] = {
    this.flags = flags
    this.asInstanceOf[PlayerAbilitiesPacketBuilder[P with Flags]]
  }

  def withFlyingSpeed(flyingSpeed: Float): PlayerAbilitiesPacketBuilder[P with FlyingSpeed] = {
    this.flyingSpeed = flyingSpeed
    this.asInstanceOf[PlayerAbilitiesPacketBuilder[P with FlyingSpeed]]
  }

  def withFieldOfViewModifier(fieldOfViewModifier: Float): PlayerAbilitiesPacketBuilder[P with FieldOfViewModifier] = {
    this.fieldOfViewModifier = fieldOfViewModifier
    this.asInstanceOf[PlayerAbilitiesPacketBuilder[P with FieldOfViewModifier]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new PlayerAbilitiesPacket(flags, flyingSpeed, fieldOfViewModifier)
  }
}
object PlayerAbilitiesPacketBuilder {
  sealed trait Flags
  sealed trait FlyingSpeed
  sealed trait FieldOfViewModifier
  type Complete = PlayerAbilitiesPacket with Flags with FlyingSpeed with FieldOfViewModifier
}
