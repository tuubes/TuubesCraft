package org.tuubes.craft.mc1_12.login.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import org.tuubes.network._

/** Packet class auto-generated by DataTractor */
final class LoginStartPacket(var name: String) extends Packet {
  override def write(out: NiolOutput): Unit {
    out.putVarstring(name, UTF_8)
  }
	
  override def id = LoginStartPacket.id

	
}
object LoginStartPacket extends PacketObj[LoginStartPacket] {
  override val id = 0
	
  override def read(in: NiolOutput): LoginStartPacket {
    val name = in.getVarstring(UTF_8)
    new LoginStartPacket(name)
  }
}
/** Packet builder auto-generated by DataTractor */
final class LoginStartPacketBuilder[P <: LoginStartPacket] extends PacketBuilder[LoginStartPacket, Complete] {
  private[this] var name: String = _

  def withName(name: String): LoginStartPacketBuilder[P with Name] = {
    this.name = name
    this.asInstanceOf[LoginStartPacketBuilder[P with Name]]
  }

  override def build()(implicit evidence: P =:= Complete) {
    new LoginStartPacket(name)
  }
}
object LoginStartPacketBuilder {
  sealed trait Name
  type Complete = LoginStartPacketBuilder with Name
}
