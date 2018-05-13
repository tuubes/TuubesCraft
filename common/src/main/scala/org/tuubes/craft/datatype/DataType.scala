package org.tuubes.craft.datatype

import com.electronwill.niol.NiolInput

trait DataType[A <: Data] {
  def read(in: NiolInput): A
}
