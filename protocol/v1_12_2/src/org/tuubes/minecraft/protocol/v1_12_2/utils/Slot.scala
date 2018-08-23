package org.tuubes.minecraft.protocol.v1_12_2.utils

import com.electronwill.niol.{NiolInput, NiolOutput, Reader, Writeable}
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.Types
import org.tuubes.minecraft.protocol.common.nbt.{Tag, TagCompound}

/**
 * Data structure for item stacks.
 *
 * @version Minecraft 1.12
 * @see https://wiki.vg/index.php?title=Slot_Data&oldid=7835
 * @param itemId     item's id
 * @param itemCount  number of items in the item stack
 * @param itemDamage damage value
 * @param nbtData    additional nbt data, may be null
 */
final case class Slot(itemId: Int, itemCount: Int, itemDamage: Int, nbtData: TagCompound) extends Writeable {
  override def writeTo(out: NiolOutput): Unit = {
    if (itemCount <= 0) {
      out.putShort(-1)
    } else {
      out.putShort(itemId)
      out.putByte(itemCount)
      out.putShort(itemDamage)
      if (nbtData != null) {
        nbtData.writeNamed(out)
      } else {
        out.putByte(0)
      }
    }
  }
}

object Slot extends Reader[Slot] {
  override def readFrom(in: NiolInput): Slot = {
    val itemId = in.getShort()
    if (itemId < 0) {
      Slot(0, 0, 0, null)
    } else {
      val itemCount = in.getByte()
      val itemDamage = in.getShort()
      val tag = Tag.readNamed(in)
      val nbtData = if (tag is Types.COMPOUND) tag.asInstanceOf[TagCompound] else null
      Slot(itemId, itemCount, itemDamage, nbtData)
    }
  }
}
