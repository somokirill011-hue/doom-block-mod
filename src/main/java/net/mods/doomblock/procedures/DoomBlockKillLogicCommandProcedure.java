package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModBlocks;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class DoomBlockKillLogicCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
	    boolean shouldSetKill = BoolArgumentType.getBool(arguments, "kill");
	
	    for (int dx = -3; dx <= 3; dx++) {
	        for (int dy = -3; dy <= 3; dy++) {
	            for (int dz = -3; dz <= 3; dz++) {
	                if (dx == 0 && dy == 0 && dz == 0) continue;
	
	                BlockPos checkPos = BlockPos.containing(x + dx, y + dy, z + dz);
	                BlockState state = world.getBlockState(checkPos);
	
	                if (state.is(net.mods.doomblock.init.DoomBlockModBlocks.DOOM.get())) {
	                    var prop = state.getBlock().getStateDefinition().getProperty("kill");
	                    if (prop instanceof BooleanProperty booleanProp) {
	                        world.setBlock(checkPos, state.setValue(booleanProp, shouldSetKill), 3);
	                    }
	                }
	            }
	        }
	    }
	}
}