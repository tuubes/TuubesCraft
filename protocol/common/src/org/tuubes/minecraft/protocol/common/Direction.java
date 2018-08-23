package org.tuubes.minecraft.protocol.common;

public enum Direction {
  DOWN, UP, NORTH, SOUTH, WEST, EAST;

  public int id() {
    return ordinal();
  }
}
