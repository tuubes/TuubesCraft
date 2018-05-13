package org.tuubes.craft.mc1_12_2

import com.electronwill.niol.NiolInput
import org.tuubes.craft.datatype.EntityDataType._
import org.tuubes.craft.datatype.{DataType, EntityData, EntityDataType}

/** Entity medata format as of version 1.12.2 */
object EntityData1_12 extends DataType[EntityData] {
  val TByte = new TypeByte(0)
  val TVarInt = new TypeVarint(1)
  val TFloat = new TypeFloat(2)
  val TString = new TypeString(3)
  val TChat = new TypeChat(4)
  val TSlot = new TypeSlot(5)
  val TBool = new TypeBoolean(6)
  val TRotation = new TypeRotation(7)
  val TPosition = new TypePosition(8)
  val TOptionalPos = new TypeOptionalPos(9)
  val TDirection = new TypeDirection(10)
  val TOptionalUid = new TypeOptionalUuid(11)
  val TOptionalBlock = new TypeOptionalBlockId(12)
  val TNbt = new TypeNbt(13)

  val Types: Array[EntityDataType[_]] = Array(TByte,
                                              TVarInt,
                                              TFloat,
                                              TSlot,
                                              TChat,
                                              TSlot,
                                              TBool,
                                              TRotation,
                                              TOptionalPos,
                                              TOptionalPos,
                                              TDirection,
                                              TOptionalUid,
                                              TOptionalBlock,
                                              TNbt)

  override def read(in: NiolInput): EntityData = {
    EntityData.read(in, Types)
  }
}
