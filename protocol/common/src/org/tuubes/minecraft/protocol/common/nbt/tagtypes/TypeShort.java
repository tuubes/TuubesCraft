package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeShort implements TagType<Short> {
  TypeShort() {}

  @Override
  public int id() {
    return 2;
  }

  @Override
  public Short readValue(NiolInput in) {
    return in.getShort();
  }

  @Override
  public void writeValue(Short value, NiolOutput out) {
    out.putByte(value);
  }
}
