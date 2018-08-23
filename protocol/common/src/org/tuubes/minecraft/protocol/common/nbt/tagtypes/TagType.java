package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public interface TagType<V> {
  int id();

  V readValue(NiolInput in);

  void writeValue(V value, NiolOutput out);
}
