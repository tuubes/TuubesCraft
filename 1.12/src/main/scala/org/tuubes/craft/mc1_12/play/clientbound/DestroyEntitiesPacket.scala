package org.tuubes.craft.mc1_12.play.clientbound

import org.tuubes.network._
import com.electronwill.niol.{NiolInput, NiolOutput}

/** Packet class auto-generated by DataTractor */
final class DestroyEntitiesPacket(var entityIds: Array[Int]) extends Packet {
  override def write(out: NiolOutput): Unit = {
    out.putVarint(entityIds.length)
    var i_entityIds = 0
    while (i_entityIds < entityIds.length) {
      out.putVarint(entityIds(i_entityIds))
      i_entityIds += 1
    }
  }
	
  override def obj = DestroyEntitiesPacket

	
}
object DestroyEntitiesPacket extends PacketObj[DestroyEntitiesPacket] {
  override val id = 49
	
  override def read(in: NiolOutput): DestroyEntitiesPacket = {
    val entityIdsLength = in.getVarint()
    var i_entityIds = 0
    val entityIds = new Array[Int](entityIdsLength)
    while (i_entityIds < entityIdsLength) {
      entityIds(i_entityIds) = in.getVarint()
      i_entityIds += 1
    }
    new DestroyEntitiesPacket(entityIds)
  }
}
/** Packet builder auto-generated by DataTractor */
final class DestroyEntitiesPacketBuilder[P <: DestroyEntitiesPacket] extends PacketBuilder[DestroyEntitiesPacket, Complete] {
  private[this] var entityIds: Array[Int] = _

  def withEntityIds(entityIds: Array[Int]): DestroyEntitiesPacketBuilder[P with EntityIds] = {
    this.entityIds = entityIds
    this.asInstanceOf[DestroyEntitiesPacketBuilder[P with EntityIds]]
  }

  override def build()(implicit evidence: P =:= Complete) = {
    new DestroyEntitiesPacket(entityIds)
  }
}
object DestroyEntitiesPacketBuilder {
  sealed trait EntityIds
  type Complete = DestroyEntitiesPacketBuilder with EntityIds
}
