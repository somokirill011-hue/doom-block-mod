package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModMenus;
import net.mods.doomblock.init.DoomBlockModItems;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class GiveButtonInMiniDoomChestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof DoomBlockModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof DoomBlockModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof DoomBlockModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof DoomBlockModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof DoomBlockModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.DRIPSTONE_BLOCK.asItem()) {
							if (Math.random() <= 0.95) {
								{
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("killing_with_a_touch") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
								}
							} else {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DoomBlockModItems.DOOM_FLART_BUCKET.get()));
									entityToSpawn.setPickUpDelay(1);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
				}
			}
		}
	}
}