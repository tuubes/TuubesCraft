package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeLongArray implements TagType<long[]> {
  TypeLongArray() {}

  @Override
  public int id() {
    return 12;
  }

  @Override
  public long[] readValue(NiolInput in) {
    int length = in.getInt();
    long[] longs = new long[length];
    for (int i = 0; i < length; i++) {
      longs[i] = Types.LONG.readValue(in);
    }
    return longs;
  }

  @Override
  public void writeValue(long[] value, NiolOutput out) {
    out.putLong(value.length);
    for (long l : value) {
      Types.LONG.writeValue(l, out);
    }
  }
}
