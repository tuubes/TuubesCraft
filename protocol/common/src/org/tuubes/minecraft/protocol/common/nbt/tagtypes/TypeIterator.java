package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TypeIterator implements TagType<Iterator<?>> {
  TypeIterator() {}

  @Override
  public int id() {
    return 9;
  }

  @Override
  public Iterator<?> readValue(NiolInput in) {
    return Types.LIST.readValue(in).iterator();
  }

  @Override
  public void writeValue(Iterator<?> value, NiolOutput out) {
    List<Object> list = new ArrayList<>();
    while (value.hasNext()) {
      list.add(value.next());
    }
    Types.LIST.writeValue(list, out);
  }
}
