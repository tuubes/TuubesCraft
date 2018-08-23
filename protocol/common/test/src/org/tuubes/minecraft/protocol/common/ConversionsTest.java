package org.tuubes.minecraft.protocol.common;

import com.electronwill.utils.MathUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ConversionsTest {
  @Test
  public void testUUID() {
    UUID uuid = UUID.randomUUID();
    String withDashes = Conversions.uuidToString(uuid, true);
    String withoutDashes = Conversions.uuidToString(uuid, false);
    assertEquals(withDashes.replace("-", ""), withoutDashes);

    UUID fromDashes = Conversions.stringToUUID(withDashes);
    assertEquals(uuid, fromDashes);

    UUID fromNoDashes = Conversions.stringToUUID(withoutDashes);
    assertEquals(uuid, fromNoDashes);
  }

  @Test
  public void testFixedPointZero() {
    double zero = 0.0;
    testExactFixedPoint(zero);
    assertEquals(0, Conversions.toFixedPoint3(zero));
    assertEquals(0, Conversions.toFixedPoint5(zero));
    assertEquals(0, Conversions.toBigFixedPoint3(zero));
    assertEquals(0, Conversions.toBigFixedPoint5(zero));
  }

  @Test
  public void testApproxFixedPoint() {
    testApproxFixedPoint(Math.PI, 0.01);
  }

  private void testExactFixedPoint(final double value) {
    int fixed5 = Conversions.toFixedPoint5(value);
    int fixed3 = Conversions.toFixedPoint3(value);
    double fromF5 = Conversions.fromFixedPoint5(fixed5);
    double fromF3 = Conversions.fromFixedPoint3(fixed3);
    assertEquals(value, fromF5);
    assertEquals(value, fromF3);
    System.out.printf("%s => %d => %s%n", value, fixed5, fromF5);
  }

  private void testApproxFixedPoint(final double value, final double tolerance) {
    int fixed5 = Conversions.toFixedPoint5(value);
    int fixed3 = Conversions.toFixedPoint3(value);
    double fromF5 = Conversions.fromFixedPoint5(fixed5);
    double fromF3 = Conversions.fromFixedPoint3(fixed3);
    assertTrue(MathUtils.almostEqual(value, fromF5, tolerance));
    assertTrue(MathUtils.almostEqual(value, fromF3, tolerance));
    System.out.printf("%s => %d => %s%n", value, fixed5, fromF5);
  }
}
