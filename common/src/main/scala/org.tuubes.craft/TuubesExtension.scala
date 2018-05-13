package org.tuubes.craft

import com.electronwill.niol.buffer.provider.{HeapNioAllocator, StageBufferPoolBuilder}
import org.tuubes.core.LocalWorld
import org.tuubes.core.network.NetworkSystem
import org.tuubes.core.plugins.Plugin

abstract class TuubesExtension extends Plugin {
  /**
   * The first protocol associated to each client.
   */
  val defaultProtocol: MinecraftProtocol

  override def onLoad(): Unit = {
    logger.info("Opening a server on port 25565")
    val poolBuilder = new StageBufferPoolBuilder()
    poolBuilder += (64, 100)
    poolBuilder += (256, 50)
    poolBuilder.defaultHandler(HeapNioAllocator.getBuffer)
    val pool = poolBuilder.build()
    val tcp = new CraftTcpListener(defaultProtocol)
    NetworkSystem.selector.listen(25565, 64, pool, tcp)
  }

  override def onUnload(): Unit = {
    logger.info("Closing port 25565")
    NetworkSystem.selector.unlisten(25565)
  }

  /** Does nothing */
  override def onEnable(world: LocalWorld): Unit = ()

  /** Does nothing */
  override def onDisable(world: LocalWorld): Unit = ()
}