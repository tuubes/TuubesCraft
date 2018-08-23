package org.tuubes.minecraft.protocol.common.nbt;

/**
 * Thrown when a problem occurs during parsing or writing NBT data.
 *
 * @author TheElectronWill
 */
public class NbtException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NbtException() {}

  public NbtException(String message) {
    super(message);
  }

  public NbtException(String message, Throwable cause) {
    super(message, cause);
  }

  public NbtException(Throwable cause) {
    super(cause);
  }
}
