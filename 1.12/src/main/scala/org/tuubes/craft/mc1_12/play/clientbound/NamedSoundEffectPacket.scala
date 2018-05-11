package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class NamedSoundEffectPacket(var soundName: String, var soundCategory: Int, var effectPositionX: Int, var effectPositionY: Int, var effectPositionZ: Int, var volume: Float, var pitch: Float) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(soundName, UTF_8)
    out.putVarint(soundCategory)
    out.putInt(effectPositionX)
    out.putInt(effectPositionY)
    out.putInt(effectPositionZ)
    out.putFloat(volume)
    out.putFloat(pitch)
  }
	
  override def id = NamedSoundEffectPacket.id

	
}
object NamedSoundEffectPacket extends PacketObj[NamedSoundEffectPacket] {
  override val id = 25
	
  override def read(in: NiolOutput): NamedSoundEffectPacket {
    val soundName = in.getVarstring(UTF_8)
    val soundCategory = in.getVarint()
    val effectPositionX = in.getInt()
    val effectPositionY = in.getInt()
    val effectPositionZ = in.getInt()
    val volume = in.getFloat()
    val pitch = in.getFloat()
    new NamedSoundEffectPacket(soundName, soundCategory, effectPositionX, effectPositionY, effectPositionZ, volume, pitch)
  }
}
/** Packet builder auto-generated by DataTractor */
final class NamedSoundEffectPacketBuilder[P <: NamedSoundEffectPacket] extends PacketBuilder[NamedSoundEffectPacket, Complete] {
  private[this] var soundName: String = _
  private[this] var soundCategory: Int = _
  private[this] var effectPositionX: Int = _
  private[this] var effectPositionY: Int = _
  private[this] var effectPositionZ: Int = _
  private[this] var volume: Float = _
  private[this] var pitch: Float = _

  def withSoundName(soundName: String): NamedSoundEffectPacketBuilder[P with SoundName] = {
    this.soundName = soundName
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with SoundName]]
  }

  def withSoundCategory(soundCategory: Int): NamedSoundEffectPacketBuilder[P with SoundCategory] = {
    this.soundCategory = soundCategory
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with SoundCategory]]
  }

  def withEffectPositionX(effectPositionX: Int): NamedSoundEffectPacketBuilder[P with EffectPositionX] = {
    this.effectPositionX = effectPositionX
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with EffectPositionX]]
  }

  def withEffectPositionY(effectPositionY: Int): NamedSoundEffectPacketBuilder[P with EffectPositionY] = {
    this.effectPositionY = effectPositionY
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with EffectPositionY]]
  }

  def withEffectPositionZ(effectPositionZ: Int): NamedSoundEffectPacketBuilder[P with EffectPositionZ] = {
    this.effectPositionZ = effectPositionZ
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with EffectPositionZ]]
  }

  def withVolume(volume: Float): NamedSoundEffectPacketBuilder[P with Volume] = {
    this.volume = volume
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with Volume]]
  }

  def withPitch(pitch: Float): NamedSoundEffectPacketBuilder[P with Pitch] = {
    this.pitch = pitch
    this.asInstanceOf[NamedSoundEffectPacketBuilder[P with Pitch]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new NamedSoundEffectPacket(soundName, soundCategory, effectPositionX, effectPositionY, effectPositionZ, volume, pitch)
  }
}
object NamedSoundEffectPacketBuilder {
  sealed trait SoundName
  sealed trait SoundCategory
  sealed trait EffectPositionX
  sealed trait EffectPositionY
  sealed trait EffectPositionZ
  sealed trait Volume
  sealed trait Pitch
  type Complete = NamedSoundEffectPacketBuilder with SoundName with SoundCategory with EffectPositionX with EffectPositionY with EffectPositionZ with Volume with Pitch
}