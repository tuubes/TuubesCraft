package org.tuubes.craft.mc1_12.play.clientbound

import com.electronwill.niol.{NiolInput, NiolOutput}
import org.tuubes.craft.CraftAttach
import UnloadChunkPacketBuilder._
import org.tuubes.core.network._

/** Packet class auto-generated by DataTractor */
final class UnloadChunkPacket(var chunkX: Int, var chunkZ: Int) extends Packet[CraftAttach] {
  override def write(out: NiolOutput): Unit = {
    out.putInt(chunkX)
    out.putInt(chunkZ)
  }
	
  override def obj = UnloadChunkPacket

	
}
object UnloadChunkPacket extends PacketObj[CraftAttach, UnloadChunkPacket] {
  override val id = 29
	
  override def read(in: NiolInput): UnloadChunkPacket = {
    val chunkX = in.getInt()
    val chunkZ = in.getInt()
    new UnloadChunkPacket(chunkX, chunkZ)
  }
}
/** Packet builder auto-generated by DataTractor */
final class UnloadChunkPacketBuilder[P <: UnloadChunkPacket] extends PacketBuilder[UnloadChunkPacket, P =:= Complete] {
  private[this] var chunkX: Int = _
  private[this] var chunkZ: Int = _

  def withChunkX(chunkX: Int): UnloadChunkPacketBuilder[P with ChunkX] = {
    this.chunkX = chunkX
    this.asInstanceOf[UnloadChunkPacketBuilder[P with ChunkX]]
  }

  def withChunkZ(chunkZ: Int): UnloadChunkPacketBuilder[P with ChunkZ] = {
    this.chunkZ = chunkZ
    this.asInstanceOf[UnloadChunkPacketBuilder[P with ChunkZ]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new UnloadChunkPacket(chunkX, chunkZ)
  }
}
object UnloadChunkPacketBuilder {
  sealed trait ChunkX
  sealed trait ChunkZ
  type Complete = UnloadChunkPacket with ChunkX with ChunkZ
}
