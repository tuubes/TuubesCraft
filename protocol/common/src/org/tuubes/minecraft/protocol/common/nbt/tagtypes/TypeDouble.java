package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeDouble implements TagType<Double> {
  TypeDouble() {}

  @Override
  public int id() {
    return 6;
  }

  @Override
  public Double readValue(NiolInput in) {
    return in.getDouble();
  }

  @Override
  public void writeValue(Double value, NiolOutput out) {
    out.putDouble(value);
  }
}
