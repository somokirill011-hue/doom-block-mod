/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class DoomBlockModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DoomBlockMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(DoomBlockModBlocks.DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.RED_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.ORANGE_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.YELLOW_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.LIME_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.LIGHT_BLUE_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.CYAN_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.BLUE_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.PURPLE_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.MAGENTA_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.PINK_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.WHITE_DOOM.get().asItem());
			tabData.accept(DoomBlockModBlocks.INVISIBLE_DOOM.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(DoomBlockModItems.DOOM_FLART_BUCKET.get());
		}
	}
}