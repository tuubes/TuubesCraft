package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeByte implements TagType<Byte> {
  TypeByte() {}

  @Override
  public int id() {
    return 1;
  }

  @Override
  public Byte readValue(NiolInput in) {
    return in.getByte();
  }

  @Override
  public void writeValue(Byte value, NiolOutput out) {
    out.putByte(value);
  }
}
