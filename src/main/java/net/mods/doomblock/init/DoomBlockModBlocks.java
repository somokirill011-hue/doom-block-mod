/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.mods.doomblock.block.DoomBlock;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.Block;

public class DoomBlockModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DoomBlockMod.MODID);
	public static final DeferredBlock<Block> DOOM;
	static {
		DOOM = REGISTRY.register("doom", DoomBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}