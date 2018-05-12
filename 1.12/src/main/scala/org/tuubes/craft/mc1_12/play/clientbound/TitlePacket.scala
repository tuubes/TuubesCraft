package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import TitlePacketBuilder._

/** Packet class auto-generated by DataTractor */
final class TitlePacket(var action: Int, var titleText: String, var subtitleText: String, var actionBarText: String, var fadeIn: Int, var stay: Int, var fadeOut: Int, var noFields: Nothing, var noFields: Nothing) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(action)
    out.putVarstring(titleText, UTF_8)
    out.putVarstring(subtitleText, UTF_8)
    out.putVarstring(actionBarText, UTF_8)
    out.putInt(fadeIn)
    out.putInt(stay)
    out.putInt(fadeOut)
    // TODO write noFields
    // TODO write noFields
  }
	
  override def obj = TitlePacket

	
}
object TitlePacket extends PacketObj[CraftAttach, TitlePacket] {
  override val id = 72
	
  override def read(in: NiolInput): TitlePacket = {
    val action = in.getVarint()
    val titleText = in.getVarstring(UTF_8)
    val subtitleText = in.getVarstring(UTF_8)
    val actionBarText = in.getVarstring(UTF_8)
    val fadeIn = in.getInt()
    val stay = in.getInt()
    val fadeOut = in.getInt()
    // TODO read noFields
    // TODO read noFields
    new TitlePacket(action, titleText, subtitleText, actionBarText, fadeIn, stay, fadeOut, noFields, noFields)
  }
}
/** Packet builder auto-generated by DataTractor */
final class TitlePacketBuilder[P <: TitlePacket] extends PacketBuilder[TitlePacket, P =:= Complete] {
  private[this] var action: Int = _
  private[this] var titleText: String = _
  private[this] var subtitleText: String = _
  private[this] var actionBarText: String = _
  private[this] var fadeIn: Int = _
  private[this] var stay: Int = _
  private[this] var fadeOut: Int = _
  private[this] var noFields: Nothing = _
  private[this] var noFields: Nothing = _

  def withAction(action: Int): TitlePacketBuilder[P with Action] = {
    this.action = action
    this.asInstanceOf[TitlePacketBuilder[P with Action]]
  }

  def withTitleText(titleText: String): TitlePacketBuilder[P with TitleText] = {
    this.titleText = titleText
    this.asInstanceOf[TitlePacketBuilder[P with TitleText]]
  }

  def withSubtitleText(subtitleText: String): TitlePacketBuilder[P with SubtitleText] = {
    this.subtitleText = subtitleText
    this.asInstanceOf[TitlePacketBuilder[P with SubtitleText]]
  }

  def withActionBarText(actionBarText: String): TitlePacketBuilder[P with ActionBarText] = {
    this.actionBarText = actionBarText
    this.asInstanceOf[TitlePacketBuilder[P with ActionBarText]]
  }

  def withFadeIn(fadeIn: Int): TitlePacketBuilder[P with FadeIn] = {
    this.fadeIn = fadeIn
    this.asInstanceOf[TitlePacketBuilder[P with FadeIn]]
  }

  def withStay(stay: Int): TitlePacketBuilder[P with Stay] = {
    this.stay = stay
    this.asInstanceOf[TitlePacketBuilder[P with Stay]]
  }

  def withFadeOut(fadeOut: Int): TitlePacketBuilder[P with FadeOut] = {
    this.fadeOut = fadeOut
    this.asInstanceOf[TitlePacketBuilder[P with FadeOut]]
  }

  def withNoFields(noFields: Nothing): TitlePacketBuilder[P with NoFields] = {
    this.noFields = noFields
    this.asInstanceOf[TitlePacketBuilder[P with NoFields]]
  }

  def withNoFields(noFields: Nothing): TitlePacketBuilder[P with NoFields] = {
    this.noFields = noFields
    this.asInstanceOf[TitlePacketBuilder[P with NoFields]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new TitlePacket(action, titleText, subtitleText, actionBarText, fadeIn, stay, fadeOut, noFields, noFields)
  }
}
object TitlePacketBuilder {
  sealed trait Action
  sealed trait TitleText
  sealed trait SubtitleText
  sealed trait ActionBarText
  sealed trait FadeIn
  sealed trait Stay
  sealed trait FadeOut
  sealed trait NoFields
  sealed trait NoFields
  type Complete = TitlePacket with Action with TitleText with SubtitleText with ActionBarText with FadeIn with Stay with FadeOut with NoFields with NoFields
}
