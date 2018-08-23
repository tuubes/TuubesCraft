package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeInt implements TagType<Integer> {
  TypeInt() {}

  @Override
  public int id() {
    return 3;
  }

  @Override
  public Integer readValue(NiolInput in) {
    return in.getInt();
  }

  @Override
  public void writeValue(Integer value, NiolOutput out) {
    out.putInt(value);
  }
}
