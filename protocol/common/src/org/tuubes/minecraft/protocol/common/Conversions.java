package org.tuubes.minecraft.protocol.common;

import com.electronwill.utils.StringUtils;
import com.electronwill.utils.Vec3i;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.electronwill.utils.MathUtils.TWICE_PI;

/**
 * Useful conversions for working with the protocol.
 */
public final class Conversions {
  private Conversions() {}

  private static final float RADS_TO_STEPS = 256f / TWICE_PI;
  private static final float STEPS_TO_RADS = TWICE_PI / 256f;

  private static final float DEGS_TO_STEPS = 256f / 360f;
  private static final float STEPS_TO_DEGS = 360f / 256f;

  // --- Integer positions ---

  /**
   * Packs a position to a single long
   */
  public static long packPosition(int x, int y, int z) {
    long px = ((long)x) & 0x3FFFFFF;
    long py = ((long)y) & 0xFFF;
    long pz = ((long)z) & 0x3FFFFFF;
    return (px << 38) | (py << 26) | pz;
  }

  /**
   * Packs a position to a single long
   */
  public static long packPosition(Vec3i pos) {
    return packPosition(pos.x(), pos.y(), pos.z());
  }

  /**
   * Unpacks a long to three coordinates
   */
  public static Vec3i unpackPosition(long packed) {
    int x = (int)(packed >> 38);
    int y = (int)((packed >> 26) & 0xFFF);
    int z = (int)(packed << 38 >> 38);
    return new Vec3i(x, y, z);
  }

  // --- Angles ---

  /**
   * Converts radians to steps of 1/256 of a full turn
   */
  public static int radiansToRotationSteps(float radians) {
    return (int)(radians * RADS_TO_STEPS);
  }

  /**
   * Converts steps of 1/256 of a full turn to radians
   */
  public static float rotationStepsToRadians(int steps) {
    return steps * STEPS_TO_RADS;
  }

  /**
   * Converts degrees to steps of 1/256 of a full turn
   */
  public static int degreesToRotationSteps(float degrees) {
    return (int)(degrees * DEGS_TO_STEPS);
  }

  /**
   * Converts steps of 1/256 of a full turn to degrees
   */
  public static float rotationStepsToDegrees(int steps) {
    return steps * STEPS_TO_DEGS;
  }

  // --- Fixed-point numbers  with 5 bits dedicated to the fractional part ---

  /**
   * Converts a double to a fixed-point number using its 5 least significant bits for the
   * fractional part.
   */
  public static int toFixedPoint5(double value) {
    return (int)(value * 32d);
  }

  /**
   * Converts a fixed-point number using its 5 least significant bits for the fractional part
   * to a floating-point double.
   */
  public static double fromFixedPoint5(int value) {
    return value / 32d;
  }

  /**
   * Converts a double to a fixed-point number using its 5 least significant bits for the
   * fractional part.
   */
  public static long toBigFixedPoint5(double value) {
    return (long)(value * 32d);
  }

  /**
   * Converts a fixed-point number using its 5 least significant bits for the fractional part
   * to a floating-point double.
   */
  public static double fromBigFixedPoint5(long value) {
    return value / 32d;
  }

  // --- Fixed-point numbers  with 3 bits dedicated to the fractional part ---

  /**
   * Converts a double to a fixed-point number using its 3 least significant bits for the
   * fractional part.
   */
  public static int toFixedPoint3(double value) {
    return (int)(value * 8d);
  }

  /**
   * Converts a fixed-point number using its 3 least significant bits for the fractional part
   * to a floating-point double.
   */
  public static double fromFixedPoint3(int value) {
    return (int)(value / 8d);
  }

  /**
   * Converts a double to a fixed-point number using its 3 least significant bits for the
   * fractional part.
   */
  public static long toBigFixedPoint3(double value) {
    return (long)(value * 8d);
  }

  /**
   * Converts a fixed-point number using its 3 least significant bits for the fractional part
   * to a floating-point double.
   */
  public static double fromBigFixedPoint3(long value) {
    return value / 8d;
  }

  // --- UUIDs ---

  /**
   * Creates a String representing a UUID.
   *
   * @param uuid       the UUID to represent
   * @param withDashes true to put dashes in the String, false not to put dashes
   * @return a String representing the given UUID
   */
  public static String uuidToString(UUID uuid, boolean withDashes) {
    String standardString = uuid.toString();
    return withDashes ? standardString : StringUtils.remove(standardString, '-');
  }

  /**
   * Constructs a UUID from a String. The String can contain dashes but doesn't have to.
   *
   * @param str a String representing the UUID
   * @return a UUID created with the information contained in the String
   */
  public static UUID stringToUUID(String str) {
    List<String> parts = new ArrayList<>(5);
    StringUtils.split(str, '-', parts);
    final int size = parts.size();
    if (size == 1) { // UUID without dashes
      String a = str.substring(0, 8);
      String b = str.substring(8);
      long msb = Long.parseLong(a, 16);
      long lsb = Long.parseLong(b, 16);
      return new UUID(msb, lsb);
    } else if (size != 5) { // invalid
      throw new IllegalArgumentException("Invalid UUID string: " + str);
    } else { // UUID with dashes
      // Extract the most significant bits
      long msb = Long.parseLong(parts.get(0), 16) << 32;
      msb |= Long.parseLong(parts.get(1), 16) << 16;
      msb |= Long.parseLong(parts.get(2), 16);
      // Extract the least significant bits
      long lsb = Long.parseLong(parts.get(3), 16) << 48;
      lsb |= Long.parseLong(parts.get(4), 16);
      // Construct the UUID
      return new UUID(msb, lsb);
    }
  }
}
