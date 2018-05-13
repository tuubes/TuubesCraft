package org.tuubes.craft.datatype;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

public enum Direction implements Data {
  Down, Up, North, South, West, East;

  public int id() {
    return ordinal();
  }

  @Override
  public void write(NiolOutput out) {
    out.putByte(id());
  }

  public static Direction read(NiolInput in) {
    return values()[in.getByte()];
  }
}
