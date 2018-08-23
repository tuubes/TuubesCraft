package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public final class TypeByteArray implements TagType<byte[]> {
  TypeByteArray() {}

  @Override
  public int id() {
    return 7;
  }

  @Override
  public byte[] readValue(NiolInput in) {
    int length = in.getInt();
    return in.getBytes(length);
  }

  @Override
  public void writeValue(byte[] value, NiolOutput out) {
    out.putInt(value.length);
    out.putBytes(value);
  }
}
