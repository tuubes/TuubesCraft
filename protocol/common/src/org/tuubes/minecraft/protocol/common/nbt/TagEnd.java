package org.tuubes.minecraft.protocol.common.nbt;

import com.electronwill.niol.NiolOutput;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.TagType;
import org.tuubes.minecraft.protocol.common.nbt.tagtypes.Types;

/**
 * End of NBT Compound.
 *
 * @author TheElectronWill
 */
public final class TagEnd implements Tag<Void> {
  public static final TagEnd INSTANCE = new TagEnd();

  private TagEnd() {}

  @Override
  public void writeNameless(NiolOutput out) {
    out.putByte(0);
  }

  @Override
  public void writeNamed(NiolOutput out) {
    out.putByte(0);
  }

  @Override
  public TagType<Void> getType() {
    return Types.END;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Void getValue() {
    return null;
  }
}
