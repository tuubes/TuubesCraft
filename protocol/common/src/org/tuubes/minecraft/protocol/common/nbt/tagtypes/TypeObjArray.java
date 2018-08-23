package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

/**
 * Reads and writes object arrays as NBT lists.
 */
public final class TypeObjArray implements TagType<Object[]> {
  TypeObjArray() {}

  @Override
  public int id() {
    return 9;
  }

  @Override
  public Object[] readValue(NiolInput in) {
    byte typeId = in.getByte();
    TagType<?> type = Types.get(typeId);
    int length = in.getInt();
    Object[] array = new Object[length];
    for (int i = 0; i < length; i++) {
      Object element = type.readValue(in);
      array[i] = element;
    }
    return array;
  }

  @Override
  public void writeValue(Object[] value, NiolOutput out) {
    Object firstElement = value.length == 0 ? null : value[0];
    TagType<Object> type = Types.forValue(firstElement);
    out.putByte(type.id());
    out.putInt(value.length);
    for (Object element : value) {
      type.writeValue(element, out);
    }
  }
}
