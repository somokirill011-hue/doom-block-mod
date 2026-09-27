package net.mods.doomblock.procedures;

import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DoomFlartNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x, y - 1, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1, y, z)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x - 1, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1, y, z)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z - 1)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z + 1)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1)) == 0) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x - 1, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1, y, z)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1, y, z)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z - 1)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z + 1)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1)) < 1.0) {
			DoomBlockMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x - 1, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1, y, z)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1, y, z)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z - 1)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z + 1)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1)) < 3.0) {
			DoomBlockMod.queueServerWork(400, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x - 1, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1, y, z)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1, y, z)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z - 1)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z + 1)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1)) < 10.0) {
			DoomBlockMod.queueServerWork(1000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x - 1, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1, y, z)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1, y, z)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z - 1)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
		if (world.getBlockState(BlockPos.containing(x, y, z + 1)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1)) > 10.0) {
			DoomBlockMod.queueServerWork(10000, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			});
		}
	}
}