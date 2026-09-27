/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mods.doomblock.item.DoomFlartItem;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

@EventBusSubscriber
public class DoomBlockModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(DoomBlockMod.MODID);
	public static final DeferredItem<Item> DOOM;
	public static final DeferredItem<Item> RED_DOOM;
	public static final DeferredItem<Item> ORANGE_DOOM;
	public static final DeferredItem<Item> YELLOW_DOOM;
	public static final DeferredItem<Item> LIME_DOOM;
	public static final DeferredItem<Item> LIGHT_BLUE_DOOM;
	public static final DeferredItem<Item> CYAN_DOOM;
	public static final DeferredItem<Item> BLUE_DOOM;
	public static final DeferredItem<Item> PURPLE_DOOM;
	public static final DeferredItem<Item> MAGENTA_DOOM;
	public static final DeferredItem<Item> PINK_DOOM;
	public static final DeferredItem<Item> WHITE_DOOM;
	public static final DeferredItem<Item> INVISIBLE_DOOM;
	public static final DeferredItem<Item> DOOM_FLART_BUCKET;
	static {
		DOOM = block(DoomBlockModBlocks.DOOM);
		RED_DOOM = block(DoomBlockModBlocks.RED_DOOM);
		ORANGE_DOOM = block(DoomBlockModBlocks.ORANGE_DOOM);
		YELLOW_DOOM = block(DoomBlockModBlocks.YELLOW_DOOM);
		LIME_DOOM = block(DoomBlockModBlocks.LIME_DOOM);
		LIGHT_BLUE_DOOM = block(DoomBlockModBlocks.LIGHT_BLUE_DOOM);
		CYAN_DOOM = block(DoomBlockModBlocks.CYAN_DOOM);
		BLUE_DOOM = block(DoomBlockModBlocks.BLUE_DOOM);
		PURPLE_DOOM = block(DoomBlockModBlocks.PURPLE_DOOM);
		MAGENTA_DOOM = block(DoomBlockModBlocks.MAGENTA_DOOM);
		PINK_DOOM = block(DoomBlockModBlocks.PINK_DOOM);
		WHITE_DOOM = block(DoomBlockModBlocks.WHITE_DOOM);
		INVISIBLE_DOOM = block(DoomBlockModBlocks.INVISIBLE_DOOM);
		DOOM_FLART_BUCKET = REGISTRY.register("doom_flart_bucket", DoomFlartItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), DOOM_FLART_BUCKET.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}