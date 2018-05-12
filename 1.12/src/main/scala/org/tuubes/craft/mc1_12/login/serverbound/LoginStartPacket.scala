package org.tuubes.craft.mc1_12.login.serverbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import java.nio.charset.StandardCharsets.UTF_8
import java.util.UUID

import org.tuubes.core.network._
import org.tuubes.craft.CraftAttach
import LoginStartPacketBuilder._
import com.electronwill.niol.buffer.provider.HeapNioAllocator
import org.tuubes.craft.mc1_12.login.clientbound.LoginSuccessPacket
import org.tuubes.craft.mc1_12.play.PlayProtocol

/** Packet class auto-generated by DataTractor */
final class LoginStartPacket(var name: String) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putVarstring(name, UTF_8)
  }
	
  override def obj = LoginStartPacket
}
object LoginStartPacket extends PacketObj[CraftAttach, LoginStartPacket] {
  override val id = 0
	
  override def read(in: NiolInput): LoginStartPacket = {
    val name = in.getVarstring(UTF_8)
    new LoginStartPacket(name)
  }

  override def handle(packet: LoginStartPacket, client: CraftAttach): Unit = {
    super.handle(packet, client)
    // TODO protocol encryption
    val playerId = UUID.fromString(packet.name)
    val success = new LoginSuccessPacket(playerId.toString, packet.name)
    val buffer = HeapNioAllocator.getBuffer(128)
    success.write(buffer)
    client.write(buffer, () => client.protocol = PlayProtocol)
  }
}
/** Packet builder auto-generated by DataTractor */
final class LoginStartPacketBuilder[P <: LoginStartPacket] extends PacketBuilder[LoginStartPacket, P =:= Complete] {
  private[this] var name: String = _

  def withName(name: String): LoginStartPacketBuilder[P with Name] = {
    this.name = name
    this.asInstanceOf[LoginStartPacketBuilder[P with Name]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new LoginStartPacket(name)
  }
}
object LoginStartPacketBuilder {
  sealed trait Name
  type Complete = LoginStartPacket with Name
}
