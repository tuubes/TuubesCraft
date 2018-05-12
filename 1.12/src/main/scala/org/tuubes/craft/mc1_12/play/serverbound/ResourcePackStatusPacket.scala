package org.tuubes.craft.mc1_12.play.serverbound

import ResourcePackStatusPacketBuilder._
import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class ResourcePackStatusPacket(var result: Int) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(result)
  }
	
  override def obj = ResourcePackStatusPacket

	
}
object ResourcePackStatusPacket extends PacketObj[CraftAttach, ResourcePackStatusPacket] {
  override val id = 24
	
  override def read(in: NiolInput): ResourcePackStatusPacket = {
    val result = in.getVarint()
    new ResourcePackStatusPacket(result)
  }
}
/** Packet builder auto-generated by DataTractor */
final class ResourcePackStatusPacketBuilder[P <: ResourcePackStatusPacket] extends PacketBuilder[ResourcePackStatusPacket, P =:= Complete] {
  private[this] var result: Int = _

  def withResult(result: Int): ResourcePackStatusPacketBuilder[P with Result] = {
    this.result = result
    this.asInstanceOf[ResourcePackStatusPacketBuilder[P with Result]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new ResourcePackStatusPacket(result)
  }
}
object ResourcePackStatusPacketBuilder {
  sealed trait Result
  type Complete = ResourcePackStatusPacket with Result
}
