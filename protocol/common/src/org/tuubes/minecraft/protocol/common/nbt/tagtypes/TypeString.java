package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

import java.nio.ByteBuffer;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class TypeString implements TagType<String> {
  TypeString() {}

  @Override
  public int id() {
    return 8;
  }

  @Override
  public String readValue(NiolInput in) {
    int length = in.getUnsignedShort();
    return in.getString(length, UTF_8);
  }

  @Override
  public void writeValue(String value, NiolOutput out) {
    ByteBuffer bytes = UTF_8.encode(value);
    out.putShort(bytes.remaining());
    out.putBytes(bytes);
  }
}
