package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeEnd implements TagType<Void> {
  TypeEnd() {}

  @Override
  public int id() {
    return 0;
  }

  @Override
  public Void readValue(NiolInput in) {
    return null;
  }

  @Override
  public void writeValue(Void value, NiolOutput out) {}
}
