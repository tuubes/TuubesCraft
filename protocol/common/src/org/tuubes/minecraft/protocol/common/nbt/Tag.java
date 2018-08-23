package org.tuubes.minecraft.protocol.common.nbt;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.TagType;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.Types;

/**
 * Represents an NBT tag.
 *
 * @param <V> the tag's value type
 */
@SuppressWarnings("unchecked")
public interface Tag<V> {
  void writeNameless(NiolOutput out);

  void writeNamed(NiolOutput out);

  TagType<V> getType();

  String getName();

  V getValue();

  default boolean is(TagType<?> type) {
    return getType() == type;
  }

  static Tag<?> readNamed(NiolInput in) {
    int typeId = in.getByte();
    TagType<?> type = Types.get(typeId);
    if (type == Types.END) {
      return TagEnd.INSTANCE;
    }
    String name = Types.STRING.readValue(in);
    Object value = type.readValue(in);
    return new NormalTag(type, name, value);
  }

  static Tag<?> readNameless(NiolInput in) {
    int typeId = in.getByte();
    TagType<?> type = Types.get(typeId);
    if (type == Types.END) {
      return TagEnd.INSTANCE;
    }
    Object value = type.readValue(in);
    return new NormalTag(type, "", value);
  }
}
