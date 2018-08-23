package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeFloat implements TagType<Float> {
  TypeFloat() {}

  @Override
  public int id() {
    return 5;
  }

  @Override
  public Float readValue(NiolInput in) {
    return in.getFloat();
  }

  @Override
  public void writeValue(Float value, NiolOutput out) {
    out.putFloat(value);
  }
}
