package org.tuubes.craft.datatype

import com.electronwill.nbj.{NbtException, TagCompound}
import com.electronwill.niol.compatibility.{NiolToDataInput, NiolToDataOutput}
import com.electronwill.niol.{NiolInput, NiolOutput}

final case class SlotData(shortId: Int, count: Int, damage: Int, nbt: Option[TagCompound]) extends Data {
  override def write(out: NiolOutput): Unit = {
    out.putShort(shortId)
    if (shortId >= 0) {
      out.putByte(count)
      out.putByte(damage)
      if (nbt.isDefined) {
        nbt.get.writeNamed(new NiolToDataOutput(out))
      } else {
        out.putByte(0)
      }
    }
  }
}

object SlotData extends DataType[SlotData] {
  override def read(in: NiolInput): SlotData = {
    val id = in.getShort()
    if (id < 0) {
      Empty
    } else {
      val count = in.getByte()
      val damage = in.getByte()
      val nbt =
        try {
          Some(TagCompound.readNamed(new NiolToDataInput(in)))
        } catch {
          case e: NbtException => None
        }
      SlotData(id, count, damage, nbt)
    }
  }

  val Empty = SlotData(-1, -1, -1, None)
}
