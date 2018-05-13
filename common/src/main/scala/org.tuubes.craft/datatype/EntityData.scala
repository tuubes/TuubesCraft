package org.tuubes.craft.datatype

import com.electronwill.niol.{NiolInput, NiolOutput}

import scala.collection.mutable

/** Entity metadata */
final case class EntityData(entries: Seq[EntityDataEntry[_]]) extends Data {
  override def write(out: NiolOutput): Unit = {
    entries.foreach(_.write(out))
    out.putByte(0xff)
  }
}

object EntityData {
  def read(in: NiolInput, types: Array[EntityDataType[_]]): EntityData = {
    val entries = new mutable.ArrayBuffer[EntityDataEntry[_]]()
    var entry: EntityDataEntry[Any] = EntityDataEntry.read(in, types)
    while (entry != null) {
      entries += entry
      entry = EntityDataEntry.read(in, types)
    }
    EntityData(entries)
  }
}