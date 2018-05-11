package org.tuubes.craft.mc1_12.play.clientbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}

/** Packet class auto-generated by DataTractor */
final class TimeUpdatePacket(var worldAge: Long, var timeOfDay: Long) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putLong(worldAge)
    out.putLong(timeOfDay)
  }
	
  override def obj = TimeUpdatePacket

	
}
object TimeUpdatePacket extends PacketObj[TimeUpdatePacket] {
  override val id = 70
	
  override def read(in: NiolOutput): TimeUpdatePacket = {
    val worldAge = in.getLong()
    val timeOfDay = in.getLong()
    new TimeUpdatePacket(worldAge, timeOfDay)
  }
}
/** Packet builder auto-generated by DataTractor */
final class TimeUpdatePacketBuilder[P <: TimeUpdatePacket] extends PacketBuilder[TimeUpdatePacket, Complete] {
  private[this] var worldAge: Long = _
  private[this] var timeOfDay: Long = _

  def withWorldAge(worldAge: Long): TimeUpdatePacketBuilder[P with WorldAge] = {
    this.worldAge = worldAge
    this.asInstanceOf[TimeUpdatePacketBuilder[P with WorldAge]]
  }

  def withTimeOfDay(timeOfDay: Long): TimeUpdatePacketBuilder[P with TimeOfDay] = {
    this.timeOfDay = timeOfDay
    this.asInstanceOf[TimeUpdatePacketBuilder[P with TimeOfDay]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new TimeUpdatePacket(worldAge, timeOfDay)
  }
}
object TimeUpdatePacketBuilder {
  sealed trait WorldAge
  sealed trait TimeOfDay
  type Complete = TimeUpdatePacketBuilder with WorldAge with TimeOfDay
}
