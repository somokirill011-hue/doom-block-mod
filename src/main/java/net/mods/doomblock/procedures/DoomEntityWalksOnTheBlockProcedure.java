package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModBlocks;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

public class DoomEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp1
				? DoomBlockModBlocks.DOOM.get().defaultBlockState().setValue(_withbp1, true)
				: DoomBlockModBlocks.DOOM.get().defaultBlockState())) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 500);
		}
	}
}