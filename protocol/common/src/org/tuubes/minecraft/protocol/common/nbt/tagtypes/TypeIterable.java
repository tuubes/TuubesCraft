package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

import java.util.ArrayList;
import java.util.List;

public final class TypeIterable implements TagType<Iterable<?>> {
  TypeIterable() {}

  @Override
  public int id() {
    return 9;
  }

  @Override
  public Iterable<?> readValue(NiolInput in) {
    return Types.LIST.readValue(in);
  }

  @Override
  public void writeValue(Iterable<?> value, NiolOutput out) {
    List<Object> list = new ArrayList<>();
    for (Object element : value) {
      list.add(element);
    }
    Types.LIST.writeValue(list, out);
  }
}
