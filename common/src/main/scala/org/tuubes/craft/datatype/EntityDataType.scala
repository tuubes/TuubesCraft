package org.tuubes.craft.datatype

import java.nio.charset.StandardCharsets.UTF_8
import java.util.UUID

import com.electronwill.nbj.TagCompound
import com.electronwill.niol.compatibility.{NiolToDataInput, NiolToDataOutput}
import com.electronwill.niol.{NiolInput, NiolOutput}
import com.electronwill.utils.{Rotation3, Vec3i}

abstract class EntityDataType[A](val id: Int) {
  def readValue(in: NiolInput): A

  def writeValue(value: A, out: NiolOutput): Unit

  final def makeEntry(index: Int, value: A) = EntityDataEntry(index, this, value)
}

object EntityDataType {
  final class TypeByte(id: Int) extends EntityDataType[Byte](id) {
    override def readValue(in: NiolInput): Byte = in.getByte()

    override def writeValue(value: Byte, out: NiolOutput): Unit = out.putByte(value)
  }

  final class TypeVarint(id: Int) extends EntityDataType[Int](id) {
    override def readValue(in: NiolInput): Int = in.getVarint()

    override def writeValue(value: Int, out: NiolOutput): Unit = out.putVarint(value)
  }

  final class TypeFloat(id: Int) extends EntityDataType[Float](id) {
    override def readValue(in: NiolInput): Float = in.getFloat()

    override def writeValue(value: Float, out: NiolOutput): Unit = out.putFloat(value)
  }

  final class TypeString(id: Int) extends EntityDataType[String](id) {
    override def readValue(in: NiolInput): String = in.getVarstring(UTF_8)

    override def writeValue(value: String, out: NiolOutput): Unit = out.putString(value, UTF_8)
  }

  final class TypeChat(id: Int) extends EntityDataType[String](id) {
    override def readValue(in: NiolInput): String = in.getVarstring(UTF_8)

    override def writeValue(value: String, out: NiolOutput): Unit = out.putString(value, UTF_8)
  }

  final class TypeSlot(id: Int) extends EntityDataType[SlotData](id) {
    override def readValue(in: NiolInput): SlotData = SlotData.read(in)

    override def writeValue(value: SlotData, out: NiolOutput): Unit = value.write(out)
  }

  final class TypeBoolean(id: Int) extends EntityDataType[Boolean](id) {
    override def readValue(in: NiolInput): Boolean = in.getBool()

    override def writeValue(value: Boolean, out: NiolOutput): Unit = out.putBool(value)
  }

  final class TypeRotation(id: Int) extends EntityDataType[Rotation3](id) {
    override def readValue(in: NiolInput): Rotation3 = {
      val rx = in.getFloat()
      val ry = in.getFloat()
      val rz = in.getFloat()
      new Rotation3(rx, ry, rz)
    }

    override def writeValue(value: Rotation3, out: NiolOutput): Unit = {
      out.putFloat(value.yaw)
      out.putFloat(value.pitch)
      out.putFloat(value.roll)
    }
  }

  final class TypePosition(id: Int) extends EntityDataType[Vec3i](id) {
    override def readValue(in: NiolInput): Vec3i = {
      val l = in.getLong()
      Conversions.longToPos(l)
    }

    override def writeValue(value: Vec3i, out: NiolOutput): Unit = {
      val l = Conversions.posToLong(value)
      out.putLong(l)
    }
  }

  final class TypeOptionalPos(id: Int) extends EntityDataType[Option[Vec3i]](id) {
    override def readValue(in: NiolInput): Option[Vec3i] = {
      val present = in.getBool()
      if (present) Some(Conversions.longToPos(in.getLong())) else None
    }

    override def writeValue(value: Option[Vec3i], out: NiolOutput): Unit = {
      out.putBool(value.isDefined)
      value.foreach(v => out.putLong(Conversions.posToLong(v)))
    }
  }

  final class TypeDirection(id: Int) extends EntityDataType[Direction](id) {
    override def readValue(in: NiolInput): Direction = Direction.read(in)

    override def writeValue(value: Direction, out: NiolOutput): Unit = value.write(out)
  }

  final class TypeOptionalUuid(id: Int) extends EntityDataType[Option[UUID]](id) {
    override def readValue(in: NiolInput): Option[UUID] = {
      val present = in.getBool()
      if (present) Some(new UUID(in.getLong(), in.getLong())) else None
    }

    override def writeValue(value: Option[UUID], out: NiolOutput): Unit = {
      out.putBool(value.isDefined)
      value.foreach(v => {
        out.putLong(v.getMostSignificantBits)
        out.putLong(v.getLeastSignificantBits)
      })
    }
  }

  final class TypeOptionalBlockId(id: Int) extends EntityDataType[Option[Int]](id) {
    override def readValue(in: NiolInput): Option[Int] = {
      val present = in.getBool()
      if (present) Some(in.getInt()) else None
    }

    override def writeValue(value: Option[Int], out: NiolOutput): Unit = {
      out.putBool(value.isDefined)
      value.foreach(out.putInt)
    }
  }

  final class TypeNbt(id: Int) extends EntityDataType[TagCompound](id) {
    override def readValue(in: NiolInput): TagCompound = {
      TagCompound.readNamed(new NiolToDataInput(in))
    }

    override def writeValue(value: TagCompound, out: NiolOutput): Unit = {
      value.writeNamed(new NiolToDataOutput(out))
    }
  }

  final class TypeOptionalChat(id: Int) extends EntityDataType[Option[String]](id) {
    override def readValue(in: NiolInput): Option[String] = {
      val present = in.getBool()
      if (present) Some(in.getVarstring(UTF_8)) else None
    }

    override def writeValue(value: Option[String], out: NiolOutput): Unit = {
      out.putBool(value.isDefined)
      value.foreach(out.putVarstring(_, UTF_8))
    }
  }
}