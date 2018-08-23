package org.tuubes.minecraft.protocol.common.nbt.tagtypes;

import org.tuubes.minecraft.protocol.common.nbt.NbtException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Utility class that gives access to the NBT tag types.
 */
@SuppressWarnings("unchecked")
public final class Types {
  private Types() {}

  public static final TypeEnd END = new TypeEnd();
  public static final TagType<Byte> BYTE = new TypeByte();
  public static final TagType<Short> SHORT = new TypeShort();
  public static final TagType<Integer> INT = new TypeInt();
  public static final TagType<Long> LONG = new TypeLong();
  public static final TagType<Float> FLOAT = new TypeFloat();
  public static final TagType<Double> DOUBLE = new TypeDouble();
  public static final TagType<byte[]> BYTE_ARRAY = new TypeByteArray();
  public static final TagType<String> STRING = new TypeString();
  public static final TagType<List<?>> LIST = new TypeList();
  public static final TagType<Map<String, Object>> COMPOUND = new TypeCompound();
  public static final TagType<int[]> INT_ARRAY = new TypeIntArray();
  public static final TagType<long[]> LONG_ARRAY = new TypeLongArray();

  public static final TagType<Object[]> OBJ_ARRAY = new TypeObjArray();
  public static final TagType<Iterable<?>> ITERABLE = new TypeIterable();
  public static final TagType<Iterator<?>> ITERATOR = new TypeIterator();

  private static final TagType<?>[] TYPES = { END, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE,
                                              BYTE_ARRAY, STRING, LIST, COMPOUND, INT_ARRAY,
                                              LONG_ARRAY };

  public static TagType<?> get(int id) {
    return TYPES[id];
  }

  public static <T> TagType<? super T> forValue(final T o) {
    if (o == null) {
      return (TagType<T>)END;
    }
    if (o instanceof int[]) {
      return (TagType<T>)INT_ARRAY;
    }
    if (o instanceof long[]) {
      return (TagType<T>)LONG_ARRAY;
    }
    if (o instanceof byte[]) {
      return (TagType<T>)BYTE_ARRAY;
    }
    if (o instanceof Object[]) {
      return (TagType<T>)OBJ_ARRAY;
    }
    if (o instanceof Map) {
      return (TagType<T>)COMPOUND;
    }
    if (o instanceof List) {
      return (TagType<T>)LIST;
    }
    if (o instanceof Iterable) {
      return (TagType<T>)ITERABLE;
    }
    if (o instanceof Iterator) {
      return (TagType<T>)ITERATOR;
    }
    Class<?> clazz = o.getClass();
    if (clazz == String.class) {
      return (TagType<T>)STRING;
    }
    if (clazz == int.class || clazz == Integer.class) {
      return (TagType<T>)INT;
    }
    if (clazz == byte.class || clazz == Byte.class) {
      return (TagType<T>)BYTE;
    }
    if (clazz == short.class || clazz == Short.class) {
      return (TagType<T>)SHORT;
    }
    if (clazz == long.class || clazz == Long.class) {
      return (TagType<T>)LONG;
    }
    if (clazz == float.class || clazz == Float.class) {
      return (TagType<T>)FLOAT;
    }
    if (clazz == double.class || clazz == Double.class) {
      return (TagType<T>)DOUBLE;
    }
    throw new NbtException("Illegal NBT object type: " + o.getClass().getCanonicalName());
  }
}
