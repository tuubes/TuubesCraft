package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeLong implements TagType<Long> {
  TypeLong() {}

  @Override
  public int id() {
    return 4;
  }

  @Override
  public Long readValue(NiolInput in) {
    return in.getLong();
  }

  @Override
  public void writeValue(Long value, NiolOutput out) {
    out.putLong(value);
  }
}
