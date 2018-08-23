package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import com.electronwill.niol.NiolInput;
import com.electronwill.niol.NiolOutput;

import java.util.HashMap;
import java.util.Map;

public final class TypeCompound implements TagType<Map<String, Object>> {
  TypeCompound() {}

  @Override
  public int id() {
    return 10;
  }

  @Override
  public Map<String, Object> readValue(NiolInput in) {
    Map<String, Object> map = new HashMap<>();
    byte elementTypeId;
    while ((elementTypeId = in.getByte()) > 0) {
      String elementName = Types.STRING.readValue(in);
      TagType<?> elementType = Types.get(elementTypeId);
      Object element = elementType.readValue(in);
      map.put(elementName, element);
    }
    return map;
  }

  @Override
  public void writeValue(Map<String, Object> value, NiolOutput out) {
    for (Map.Entry<String, Object> entry : value.entrySet()) {
      String elementName = entry.getKey();
      Object element = entry.getValue();
      TagType<Object> elementType = Types.forValue(element);
      Types.STRING.writeValue(elementName, out);
      elementType.writeValue(element, out);
    }
    out.putByte(0); // TAG_END's type
  }
}
