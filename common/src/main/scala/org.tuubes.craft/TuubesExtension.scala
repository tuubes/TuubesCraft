package org.tuubes.craft

import com.electronwill.niol.buffer.provider.{HeapNioAllocator, StageBufferPoolBuilder}
import org.tuubes.core.engine.World
import org.tuubes.core.network.NetworkSystem
import org.tuubes.core.plugins.Plugin

abstract class TuubesExtension extends Plugin {
  /**
   * The first protocol associated to each client.
   */
  val defaultProtocol: MinecraftProtocol

  override def onLoad(): Unit = {
    val poolBuilder = new StageBufferPoolBuilder()
    poolBuilder += (64, 100)
    poolBuilder += (256, 50)
    poolBuilder.defaultHandler(HeapNioAllocator.getBuffer)
    val pool = poolBuilder.build()
    val tcp = new CraftTcpListener(defaultProtocol)
    NetworkSystem.selector.listen(25565, 64, pool, tcp)
  }

  override def onUnload(): Unit = {
    NetworkSystem.selector.unlisten(25565)
  }

  /** Does nothing */
  override def onEnable(world: World): Unit = ()

  /** Does nothing */
  override def onDisable(world: World): Unit = ()
}