package net.mods.doomblock.procedures;

import net.mods.doomblock.world.inventory.ChestDoomBlocksMenu;
import net.mods.doomblock.init.DoomBlockModBlocks;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;

import io.netty.buffer.Unpooled;

public class RightClickOnDoomBlockOpenGUIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState state = world.getBlockState(pos);
        var block = state.getBlock();

		Property<?> chestActive = block.getStateDefinition().getProperty("chest");

		boolean isChestActive = false;
		if (chestActive instanceof BooleanProperty) {
			BooleanProperty chest = (BooleanProperty) chestActive;
			isChestActive = state.getValue(chest);
		}

		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == DoomBlockModBlocks.DOOM.get()) {
			if (isChestActive == true) {
				if (entity instanceof ServerPlayer _ent) {
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ChestDoomBlocks");
						}
		
						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}
		
						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ChestDoomBlocksMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
						}
					}, pos);
				}
			}
		}
	}
}