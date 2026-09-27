/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.inits;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.mods.doomblock.blocks.*;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class DoomBlockModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DoomBlockMod.MODID);
	public static final DeferredBlock<Block> DOOM;
	static {
		DOOM = register("doom", DoomBlock::new);
	}

	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}