/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.mods.doomblock.block.*;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.Block;

public class DoomBlockModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DoomBlockMod.MODID);
	public static final DeferredBlock<Block> DOOM;
	public static final DeferredBlock<Block> RED_DOOM;
	public static final DeferredBlock<Block> ORANGE_DOOM;
	public static final DeferredBlock<Block> YELLOW_DOOM;
	public static final DeferredBlock<Block> LIME_DOOM;
	public static final DeferredBlock<Block> LIGHT_BLUE_DOOM;
	public static final DeferredBlock<Block> CYAN_DOOM;
	public static final DeferredBlock<Block> BLUE_DOOM;
	public static final DeferredBlock<Block> PURPLE_DOOM;
	public static final DeferredBlock<Block> MAGENTA_DOOM;
	public static final DeferredBlock<Block> PINK_DOOM;
	public static final DeferredBlock<Block> WHITE_DOOM;
	public static final DeferredBlock<Block> INVISIBLE_DOOM;
	public static final DeferredBlock<Block> DOOM_FLART;
	static {
		DOOM = REGISTRY.register("doom", DoomBlock::new);
		RED_DOOM = REGISTRY.register("red_doom", RedDoomBlock::new);
		ORANGE_DOOM = REGISTRY.register("orange_doom", OrangeDoomBlock::new);
		YELLOW_DOOM = REGISTRY.register("yellow_doom", YellowDoomBlock::new);
		LIME_DOOM = REGISTRY.register("lime_doom", LimeDoomBlock::new);
		LIGHT_BLUE_DOOM = REGISTRY.register("light_blue_doom", LightBlueDoomBlock::new);
		CYAN_DOOM = REGISTRY.register("cyan_doom", CyanDoomBlock::new);
		BLUE_DOOM = REGISTRY.register("blue_doom", BlueDoomBlock::new);
		PURPLE_DOOM = REGISTRY.register("purple_doom", PurpleDoomBlock::new);
		MAGENTA_DOOM = REGISTRY.register("magenta_doom", MagentaDoomBlock::new);
		PINK_DOOM = REGISTRY.register("pink_doom", PinkDoomBlock::new);
		WHITE_DOOM = REGISTRY.register("white_doom", WhiteDoomBlock::new);
		INVISIBLE_DOOM = REGISTRY.register("invisible_doom", InvisibleDoomBlock::new);
		DOOM_FLART = REGISTRY.register("doom_flart", DoomFlartBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}