package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModBlocks;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LavaNeighborProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock() == Blocks.LAVA)) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM.get().defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.LAVA) {
			DoomBlockMod.queueServerWork(600, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM_FLART.get().defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.LAVA) {
			DoomBlockMod.queueServerWork(300, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM_FLART.get().defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.LAVA) {
			DoomBlockMod.queueServerWork(100, () -> {
				world.setBlock(BlockPos.containing(x, y, z), DoomBlockModBlocks.DOOM_FLART.get().defaultBlockState(), 3);
			});
		}
	}
}