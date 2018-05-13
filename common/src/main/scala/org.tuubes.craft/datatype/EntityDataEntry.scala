package org.tuubes.craft.datatype

import com.electronwill.niol.{NiolInput, NiolOutput}

final case class EntityDataEntry[A](index: Int, `type`: EntityDataType[A], value: A) {
  def write(out: NiolOutput): Unit = {
    out.putByte(index)
    out.putByte(`type`.id)
    `type`.writeValue(value, out)
  }
}

object EntityDataEntry {
  def read[A](in: NiolInput, types: Array[EntityDataType[_]]): EntityDataEntry[A] = {
    val index = in.getUnsignedByte()
    if (index == 0xff) {
      null
    } else {
      val typeId = in.getByte()
      val typeInstance = types(typeId).asInstanceOf[EntityDataType[A]]
      val value = typeInstance.readValue(in)
      EntityDataEntry(index, typeInstance, value)
    }
  }
}
