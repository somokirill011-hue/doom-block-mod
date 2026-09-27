package net.mods.doomblock.procedures;

import net.mods.doomblock.world.inventory.ChestDoomBlocksMenu;

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

import io.netty.buffer.Unpooled;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OpenGUIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
      	BlockPos pos = BlockPos.containing(x, y, z);
        BlockState currentState = world.getBlockState(pos);
        Block block = currentState.getBlock();

        // Получаем свойство "chest" и сразу проверяем, что оно существует и это BooleanProperty
        Property<?> chestProp = block.getStateDefinition().getProperty("chest");
        if (!(chestProp instanceof BooleanProperty)) {
            return;
        }
		BooleanProperty propChest = (BooleanProperty) chestProp;
        boolean currentChest = false;

		if (propChest instanceof BooleanProperty) {
			BooleanProperty chestP = (BooleanProperty) chestProp;
        	currentChest = currentState.getValue(chestP);
		}
        if (!currentChest) {
            return; // Сундук не активирован — ничего не делаем
        }
        if (currentChest == true) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
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
						return new ChestDoomBlocksMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
        }
	}
}