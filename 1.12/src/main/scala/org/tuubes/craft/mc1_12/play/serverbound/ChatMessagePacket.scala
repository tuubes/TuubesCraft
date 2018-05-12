package org.tuubes.craft.mc1_12.play.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.core.network._
import ChatMessagePacketBuilder._

/** Packet class auto-generated by DataTractor */
final class ChatMessagePacket(var message: String) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarstring(message, UTF_8)
  }
	
  override def obj = ChatMessagePacket

	
}
object ChatMessagePacket extends PacketObj[CraftAttach, ChatMessagePacket] {
  override val id = 3
	
  override def read(in: NiolInput): ChatMessagePacket = {
    val message = in.getVarstring(UTF_8)
    new ChatMessagePacket(message)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ChatMessagePacketBuilder[P <: ChatMessagePacket] extends PacketBuilder[ChatMessagePacket, P =:= Complete] {
  private[this] var message: String = _

  def withMessage(message: String): ChatMessagePacketBuilder[P with Message] = {
    this.message = message
    this.asInstanceOf[ChatMessagePacketBuilder[P with Message]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ChatMessagePacket(message)
  }
}
object ChatMessagePacketBuilder {
  sealed trait Message
  type Complete = ChatMessagePacket with Message
}
