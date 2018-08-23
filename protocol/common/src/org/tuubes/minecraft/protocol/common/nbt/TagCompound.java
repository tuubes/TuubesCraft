package org.tuubes.minecraft.protocol.common.nbt;

import com.electronwill.niol.NiolInput;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.TagType;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.Types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * NBT compound tag.
 *
 * @author TheElectronWill
 */
@SuppressWarnings("unchecked")
public final class TagCompound extends NormalTag<Map<String, Object>> implements Iterable<Tag<?>> {

  public TagCompound(String name, Map<String, Object> value) {
    super(Types.COMPOUND, name, value);
  }

  public TagCompound(String name) {
    super(Types.COMPOUND, name, new HashMap<>());
  }

  public Object get(String name) {
    return value.get(name);
  }

  @Override
  public Iterator<Tag<?>> iterator() {
    return new Iterator<Tag<?>>() {
      private final Iterator<Map.Entry<String, Object>> entryIterator = value.entrySet().iterator();

      @Override
      public boolean hasNext() {
        return entryIterator.hasNext();
      }

      @Override
      public void remove() {
        entryIterator.remove();
      }

      @Override
      public Tag<?> next() {
        Map.Entry<String, Object> next = entryIterator.next();
        TagType<?> type = Types.forValue(next.getValue());
        if (type == Types.END) {
          return TagEnd.INSTANCE;
        }
        return new NormalTag(type, next.getKey(), next.getValue());
      }
    };
  }

  public static TagCompound readNamed(NiolInput in) {
    int typeId = in.getByte();
    if (typeId != Types.COMPOUND.id()) {
      throw new NbtException(
        "Invalid first id in TagCompound, expected Compound's id, not " + typeId);
    }
    String name = Types.STRING.readValue(in);
    Map<String, Object> values = Types.COMPOUND.readValue(in);
    return new TagCompound(name, values);
  }
}
