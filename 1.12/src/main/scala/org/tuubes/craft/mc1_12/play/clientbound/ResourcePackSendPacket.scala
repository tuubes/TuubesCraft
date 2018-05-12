package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import java.nio.charset.StandardCharsets.UTF_8
import ResourcePackSendPacketBuilder._
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class ResourcePackSendPacket(var url: String, var hash: String) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarstring(url, UTF_8)
    out.putVarstring(hash, UTF_8)
  }
	
  override def obj = ResourcePackSendPacket

	
}
object ResourcePackSendPacket extends PacketObj[CraftAttach, ResourcePackSendPacket] {
  override val id = 51
	
  override def read(in: NiolInput): ResourcePackSendPacket = {
    val url = in.getVarstring(UTF_8)
    val hash = in.getVarstring(UTF_8)
    new ResourcePackSendPacket(url, hash)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ResourcePackSendPacketBuilder[P <: ResourcePackSendPacket] extends PacketBuilder[ResourcePackSendPacket, P =:= Complete] {
  private[this] var url: String = _
  private[this] var hash: String = _

  def withUrl(url: String): ResourcePackSendPacketBuilder[P with Url] = {
    this.url = url
    this.asInstanceOf[ResourcePackSendPacketBuilder[P with Url]]
  }

  def withHash(hash: String): ResourcePackSendPacketBuilder[P with Hash] = {
    this.hash = hash
    this.asInstanceOf[ResourcePackSendPacketBuilder[P with Hash]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ResourcePackSendPacket(url, hash)
  }
}
object ResourcePackSendPacketBuilder {
  sealed trait Url
  sealed trait Hash
  type Complete = ResourcePackSendPacket with Url with Hash
}
