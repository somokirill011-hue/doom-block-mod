package net.mods.doomblock.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nullable;
import net.mods.doomblock.init.DoomBlocksList;

public class RightClickOnDoomBlocksProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState currentState = world.getBlockState(pos);
        Block block = currentState.getBlock();

        if (!DoomBlocksList.isDoomBlock(block)) {
            return;
        }

        ItemStack mainHand = ItemStack.EMPTY;
        if (entity instanceof LivingEntity livingEntity) {
            mainHand = livingEntity.getMainHandItem();
        }
        if (!mainHand.is(Blocks.POINTED_DRIPSTONE.asItem())) {
            return;
        }

        Property<?> propTouch = block.getStateDefinition().getProperty("killing_with_a_touch");
        Property<?> propKill = block.getStateDefinition().getProperty("kill");

        if (!(propTouch instanceof BooleanProperty)) {
            return;
        }
        BooleanProperty touchProp = (BooleanProperty) propTouch;

        boolean currentKill = false;
        if (propKill instanceof BooleanProperty) {
            BooleanProperty killProp = (BooleanProperty) propKill;
            currentKill = currentState.getValue(killProp);
        }

        boolean currentTouch = currentState.getValue(touchProp);

        boolean resultTouch = false;

        if (currentKill && !currentTouch) {
            resultTouch = true;
        } else {
            resultTouch = false;
        }

        if (resultTouch == currentTouch) {
            return;
        }

        world.setBlock(
            pos,
            currentState.setValue(touchProp, resultTouch),
            net.minecraft.world.level.block.Block.UPDATE_ALL | net.minecraft.world.level.block.Block.UPDATE_IMMEDIATE
        );
    }
}
