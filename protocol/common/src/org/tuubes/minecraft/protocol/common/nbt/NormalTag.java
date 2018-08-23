package org.tuubes.minecraft.protocol.common.nbt;

import com.electronwill.niol.NiolOutput;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.TagType;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.Types;

/**
 * Represents an NBT tag.
 *
 * @param <V> the tag's value type
 */
@SuppressWarnings("unchecked")
public class NormalTag<V> implements Tag<V> {
  protected final TagType<V> type;
  protected String name;
  protected V value;

  public NormalTag(TagType<V> type, String name, V value) {
    this.type = type;
    this.name = name;
    this.value = value;
  }

  public void writeNameless(NiolOutput out) {
    out.putByte(type.id());
    type.writeValue(value, out);
  }

  public void writeNamed(NiolOutput out) {
    out.putByte(type.id());
    Types.STRING.writeValue(name, out);
    type.writeValue(value, out);
  }

  public TagType<V> getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public V getValue() {
    return value;
  }
}
