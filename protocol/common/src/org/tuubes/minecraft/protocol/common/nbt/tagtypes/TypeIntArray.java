package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeIntArray implements TagType<int[]> {
  TypeIntArray() {}

  @Override
  public int id() {
    return 11;
  }

  @Override
  public int[] readValue(NiolInput in) {
    int length = in.getInt();
    int[] ints = new int[length];
    for (int i = 0; i < length; i++) {
      ints[i] = Types.INT.readValue(in);
    }
    return ints;
  }

  @Override
  public void writeValue(int[] value, NiolOutput out) {
    out.putInt(value.length);
    for (int i : value) {
      Types.INT.writeValue(i, out);
    }
  }
}
