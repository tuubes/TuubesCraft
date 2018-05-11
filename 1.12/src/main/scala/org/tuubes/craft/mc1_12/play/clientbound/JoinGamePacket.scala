package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class JoinGamePacket(var entityId: Int, var gamemode: Int, var dimension: Int, var difficulty: Int, var maxPlayers: Int, var levelType: String, var reducedDebugInfo: Boolean) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putInt(entityId)
    out.putInt(gamemode)
    out.putInt(dimension)
    out.putInt(difficulty)
    out.putInt(maxPlayers)
    out.putVarstring(levelType, UTF_8)
    out.putBoolean(reducedDebugInfo)
  }
	
  override def id = JoinGamePacket.id

	
}
object JoinGamePacket extends PacketObj[JoinGamePacket] {
  override val id = 35
	
  override def read(in: NiolOutput): JoinGamePacket {
    val entityId = in.getInt()
    val gamemode = in.getUnsignedByte()
    val dimension = in.getInt()
    val difficulty = in.getUnsignedByte()
    val maxPlayers = in.getUnsignedByte()
    val levelType = in.getVarstring(UTF_8)
    val reducedDebugInfo = in.getBoolean()
    new JoinGamePacket(entityId, gamemode, dimension, difficulty, maxPlayers, levelType, reducedDebugInfo)
  }
}
/** Packet builder auto-generated by DataTractor */
final class JoinGamePacketBuilder[P <: JoinGamePacket] extends PacketBuilder[JoinGamePacket, Complete] {
  private[this] var entityId: Int = _
  private[this] var gamemode: Int = _
  private[this] var dimension: Int = _
  private[this] var difficulty: Int = _
  private[this] var maxPlayers: Int = _
  private[this] var levelType: String = _
  private[this] var reducedDebugInfo: Boolean = _

  def withEntityId(entityId: Int): JoinGamePacketBuilder[P with EntityId] = {
    this.entityId = entityId
    this.asInstanceOf[JoinGamePacketBuilder[P with EntityId]]
  }

  def withGamemode(gamemode: Int): JoinGamePacketBuilder[P with Gamemode] = {
    this.gamemode = gamemode
    this.asInstanceOf[JoinGamePacketBuilder[P with Gamemode]]
  }

  def withDimension(dimension: Int): JoinGamePacketBuilder[P with Dimension] = {
    this.dimension = dimension
    this.asInstanceOf[JoinGamePacketBuilder[P with Dimension]]
  }

  def withDifficulty(difficulty: Int): JoinGamePacketBuilder[P with Difficulty] = {
    this.difficulty = difficulty
    this.asInstanceOf[JoinGamePacketBuilder[P with Difficulty]]
  }

  def withMaxPlayers(maxPlayers: Int): JoinGamePacketBuilder[P with MaxPlayers] = {
    this.maxPlayers = maxPlayers
    this.asInstanceOf[JoinGamePacketBuilder[P with MaxPlayers]]
  }

  def withLevelType(levelType: String): JoinGamePacketBuilder[P with LevelType] = {
    this.levelType = levelType
    this.asInstanceOf[JoinGamePacketBuilder[P with LevelType]]
  }

  def withReducedDebugInfo(reducedDebugInfo: Boolean): JoinGamePacketBuilder[P with ReducedDebugInfo] = {
    this.reducedDebugInfo = reducedDebugInfo
    this.asInstanceOf[JoinGamePacketBuilder[P with ReducedDebugInfo]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new JoinGamePacket(entityId, gamemode, dimension, difficulty, maxPlayers, levelType, reducedDebugInfo)
  }
}
object JoinGamePacketBuilder {
  sealed trait EntityId
  sealed trait Gamemode
  sealed trait Dimension
  sealed trait Difficulty
  sealed trait MaxPlayers
  sealed trait LevelType
  sealed trait ReducedDebugInfo
  type Complete = JoinGamePacketBuilder with EntityId with Gamemode with Dimension with Difficulty with MaxPlayers with LevelType with ReducedDebugInfo
}