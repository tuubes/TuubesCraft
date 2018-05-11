package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class ScoreboardObjectivePacket(var objectiveName: String, var mode: Byte, var objectiveValue: Option[String], var type: Option[String]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(objectiveName, UTF_8)
    out.putByte(mode)
    if (objectiveValue.isDefined) {
      out.putVarstring(objectiveValue, UTF_8)
    }
    if (type.isDefined) {
      out.putVarstring(type, UTF_8)
    }
  }
	
  override def id = ScoreboardObjectivePacket.id

	
}
object ScoreboardObjectivePacket extends PacketObj[ScoreboardObjectivePacket] {
  override val id = 65
	
  override def read(in: NiolOutput): ScoreboardObjectivePacket {
    val objectiveName = in.getVarstring(UTF_8)
    val mode = in.getByte()
    // TODO read objectiveValue
    // TODO read type
    new ScoreboardObjectivePacket(objectiveName, mode, objectiveValue, type)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ScoreboardObjectivePacketBuilder[P <: ScoreboardObjectivePacket] extends PacketBuilder[ScoreboardObjectivePacket, Complete] {
  private[this] var objectiveName: String = _
  private[this] var mode: Byte = _
  private[this] var objectiveValue: Option[String] = _
  private[this] var type: Option[String] = _

  def withObjectiveName(objectiveName: String): ScoreboardObjectivePacketBuilder[P with ObjectiveName] = {
    this.objectiveName = objectiveName
    this.asInstanceOf[ScoreboardObjectivePacketBuilder[P with ObjectiveName]]
  }

  def withMode(mode: Byte): ScoreboardObjectivePacketBuilder[P with Mode] = {
    this.mode = mode
    this.asInstanceOf[ScoreboardObjectivePacketBuilder[P with Mode]]
  }

  def withObjectiveValue(objectiveValue: Option[String]): ScoreboardObjectivePacketBuilder[P with ObjectiveValue] = {
    this.objectiveValue = objectiveValue
    this.asInstanceOf[ScoreboardObjectivePacketBuilder[P with ObjectiveValue]]
  }

  def withType(type: Option[String]): ScoreboardObjectivePacketBuilder[P with Type] = {
    this.type = type
    this.asInstanceOf[ScoreboardObjectivePacketBuilder[P with Type]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new ScoreboardObjectivePacket(objectiveName, mode, objectiveValue, type)
  }
}
object ScoreboardObjectivePacketBuilder {
  sealed trait ObjectiveName
  sealed trait Mode
  sealed trait ObjectiveValue
  sealed trait Type
  type Complete = ScoreboardObjectivePacketBuilder with ObjectiveName with Mode with ObjectiveValue with Type
}