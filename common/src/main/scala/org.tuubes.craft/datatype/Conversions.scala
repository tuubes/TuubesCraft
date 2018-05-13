package org.tuubes.craft.datatype

import com.electronwill.utils
import com.electronwill.utils.Vec3i

object Conversions {
  def posToLong(v: Vec3i): Long = {
    ((v.x & 0x3ffffff) << 38) | ((v.y & 0xfff) << 26) | (v.z & 0x3ffffff)
  }

  def longToPos(l: Long): Vec3i = {
    val x = l >> 38
    val y = (l >> 26) & 0xfff
    val z = l << 38 >> 38
    new Vec3i(x.toInt, y.toInt, z.toInt)
  }

  def radsToSteps(radians: Float): Int = {
    (radians / utils.Pi2 * 256f).toInt
  }

  def stepsToRads(steps: Int): Float = {
    steps / 256f * utils.Pi2
  }
}
