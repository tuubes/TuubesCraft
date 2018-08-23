package org.tuubes.minecraft.protocol.v1_12_2.utils;

import com.electronwill.niol.NiolOutput;
import com.electronwill.utils.Rotation3;
import com.electronwill.utils.Vec3i;
import org.tuubes.minecraft.protocol.common.Conversions;
import org.tuubes.minecraft.protocol.common.Direction;
import org.tuubes.minecraft.protocol.common.nbt.Tag;

import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Writes "Entity Metadata" values.
 *
 * @version Minecraft 1.12
 * @see <a href="https://wiki.vg/index.php?title=Entity_metadata&oldid=14048">wiki.vg - Entity Metadata</a>
 */
public final class EntityMetadata {
  private EntityMetadata() {}

  public static void putByte(int index, int value, NiolOutput out) {
    putHeader(index, 0, out);
    out.putByte(value);
  }

  public static void putVarint(int index, int value, NiolOutput out) {
    putHeader(index, 1, out);
    out.putByte(value);
  }

  public static void putFloat(int index, float value, NiolOutput out) {
    putHeader(index, 2, out);
    out.putFloat(value);
  }

  public static void putString(int index, String value, NiolOutput out) {
    putHeader(index, 3, out);
    out.putVarstring(value, UTF_8);
  }

  public static void putChat(int index, String json, NiolOutput out) {
    putHeader(index, 4, out);
    out.putVarstring(json, UTF_8);
  }

  public static void putSlot(int index, Slot value, NiolOutput out) {
    putHeader(index, 5, out);
    value.writeTo(out);
  }

  public static void putBool(int index, boolean value, NiolOutput out) {
    putHeader(index, 6, out);
    out.putBool(value);
  }

  public static void putRotation(int index, Rotation3 value, NiolOutput out) {
    putHeader(index, 7, out);
    out.putFloat(value.yaw());
    out.putFloat(value.pitch());
    out.putFloat(value.roll());
  }

  public static void putPosition(int index, Vec3i value, NiolOutput out) {
    putHeader(index, 8, out);
    out.putLong(Conversions.packPosition(value));
  }

  public static void putOptionalPosition(int index, Vec3i value, NiolOutput out) {
    putHeader(index, 9, out);
    if (value == null) {
      out.putBool(false);
    } else {
      out.putBool(true);
      out.putLong(Conversions.packPosition(value));
    }
  }

  public static void putDirection(int index, Direction value, NiolOutput out) {
    putHeader(index, 10, out);
    out.putVarint(value.id());
  }

  public static void putOptionalUUID(int index, UUID value, NiolOutput out) {
    putHeader(index, 11, out);
    if (value == null) {
      out.putBool(false);
    } else {
      out.putBool(true);
      out.putLong(value.getMostSignificantBits());
      out.putLong(value.getLeastSignificantBits());
    }
  }

  public static void putOptionalBlockId(int index, int fullId, NiolOutput out) {
    putHeader(index, 12, out);
    out.putVarint(fullId);
  }

  public static void putNbtTag(int index, Tag<?> value, NiolOutput out) {
    putHeader(index, 8, out);
    value.writeNamed(out);
  }

  private static void putHeader(int index, int type, NiolOutput out) {
    out.putByte(index);
    out.putVarint(type);
  }
}
