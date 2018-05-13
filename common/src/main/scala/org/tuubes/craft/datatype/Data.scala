package org.tuubes.craft.datatype

import com.electronwill.niol.NiolOutput

trait Data {
  def write(out: NiolOutput): Unit
}
