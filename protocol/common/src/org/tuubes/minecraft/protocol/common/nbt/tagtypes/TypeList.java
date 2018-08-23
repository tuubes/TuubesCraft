package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TypeList implements TagType<List<?>> {
  TypeList() {}

  @Override
  public int id() {
    return 9;
  }

  @Override
  public List<?> readValue(NiolInput in) {
    byte typeId = in.getByte();
    TagType<?> type = Types.get(typeId);
    int length = in.getInt();
    if (length == 0) {
      return Collections.emptyList();
    }
    List<Object> list = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      Object element = type.readValue(in);
      list.add(element);
    }
    return list;
  }

  @Override
  public void writeValue(List<?> value, NiolOutput out) {
    Object firstElement = value.size() == 0 ? null : value.get(0);
    TagType<Object> type = Types.forValue(firstElement);
    out.putByte(type.id());
    out.putInt(value.size());
    for (Object element : value) {
      type.writeValue(element, out);
    }
  }
}
