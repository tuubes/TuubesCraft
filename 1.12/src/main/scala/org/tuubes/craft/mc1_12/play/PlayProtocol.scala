package org.tuubes.craft.mc1_12.play

import org.tuubes.craft.mc1_12.play.serverbound._
import org.tuubes.craft.MinecraftProtocol

/** Protocol class auto-generated by DataTractor */
object PlayProtocol extends MinecraftProtocol {
  registerPacket(AdvancementTabPacket)
  registerPacket(AnimationPacket)
  registerPacket(ChatMessagePacket)
  registerPacket(ClickWindowPacket)
  registerPacket(ClientSettingsPacket)
  registerPacket(ClientStatusPacket)
  registerPacket(CloseWindowPacket)
  registerPacket(ConfirmTransactionPacket)
  registerPacket(CraftingBookDataPacket)
  registerPacket(CreativeInventoryActionPacket)
  registerPacket(EnchantItemPacket)
  registerPacket(EntityActionPacket)
  registerPacket(HeldItemChangePacket)
  registerPacket(KeepAlivePacket)
  registerPacket(PlayerPacket)
  registerPacket(PlayerAbilitiesPacket)
  registerPacket(PlayerBlockPlacementPacket)
  registerPacket(PlayerDiggingPacket)
  registerPacket(PlayerLookPacket)
  registerPacket(PlayerPositionPacket)
  registerPacket(PlayerPositionAndLookPacket)
  registerPacket(PluginMessagePacket)
  registerPacket(PrepareCraftingGridPacket)
  registerPacket(ResourcePackStatusPacket)
  registerPacket(SpectatePacket)
  registerPacket(SteerBoatPacket)
  registerPacket(SteerVehiclePacket)
  registerPacket(TabCompletePacket)
  registerPacket(TeleportConfirmPacket)
  registerPacket(UpdateSignPacket)
  registerPacket(UseEntityPacket)
  registerPacket(UseItemPacket)
  registerPacket(VehicleMovePacket)
}