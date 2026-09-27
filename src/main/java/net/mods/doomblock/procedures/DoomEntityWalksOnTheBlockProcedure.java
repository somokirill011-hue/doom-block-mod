package net.mods.doomblock.procedures;

import net.mods.doomblock.inits.DoomBlockModGameRules;
import net.mods.doomblock.inits.DoomBlockModBlocks;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.server.level.ServerLevel;

public class DoomEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState currentState = world.getBlockState(pos);
        Block block = currentState.getBlock();

        if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY) == false) {
            return;
        }

        Property<?> propTouch = block.getStateDefinition().getProperty("killing_with_a_touch");
        Property<?> propKill = block.getStateDefinition().getProperty("kill");

        if (!(propTouch instanceof BooleanProperty) || !(propKill instanceof BooleanProperty)) {
            return;
        }

        BooleanProperty touchProp = (BooleanProperty) propTouch;
        BooleanProperty killProp = (BooleanProperty) propKill;

        boolean currentTouch = currentState.getValue(touchProp);
        boolean currentKill = currentState.getValue(killProp);

        boolean shouldKill = currentKill || currentTouch;

        if (shouldKill) {
            entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 500.0F);
        }
    }
}
