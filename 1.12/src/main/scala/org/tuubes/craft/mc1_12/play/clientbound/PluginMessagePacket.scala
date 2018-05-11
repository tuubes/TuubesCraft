package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class PluginMessagePacket(var channel: String, var data: Array[Byte]) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(channel, UTF_8)
    out.putBytes(data)
  }
	
  override def id = PluginMessagePacket.id

	
}
object PluginMessagePacket extends PacketObj[PluginMessagePacket] {
  override val id = 24
	
  override def read(in: NiolOutput): PluginMessagePacket {
    val channel = in.getVarstring(UTF_8)
    val data = in.getBytes(dataLength)
    new PluginMessagePacket(channel, data)
  }
}
/** Packet builder auto-generated by DataTractor */
final class PluginMessagePacketBuilder[P <: PluginMessagePacket] extends PacketBuilder[PluginMessagePacket, Complete] {
  private[this] var channel: String = _
  private[this] var data: Array[Byte] = _

  def withChannel(channel: String): PluginMessagePacketBuilder[P with Channel] = {
    this.channel = channel
    this.asInstanceOf[PluginMessagePacketBuilder[P with Channel]]
  }

  def withData(data: Array[Byte]): PluginMessagePacketBuilder[P with Data] = {
    this.data = data
    this.asInstanceOf[PluginMessagePacketBuilder[P with Data]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new PluginMessagePacket(channel, data)
  }
}
object PluginMessagePacketBuilder {
  sealed trait Channel
  sealed trait Data
  type Complete = PluginMessagePacketBuilder with Channel with Data
}
