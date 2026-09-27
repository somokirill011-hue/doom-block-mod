/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mods.doomblock.DoomBlockMod;

/* Doom Blocks Start */

// Default

import net.mods.doomblock.block.entity.DoomBlockEntity;

// MultiColored

import net.mods.doomblock.block.entity.RedDoomBlockEntity;
import net.mods.doomblock.block.entity.OrangeDoomBlockEntity;
import net.mods.doomblock.block.entity.YellowDoomBlockEntity;
import net.mods.doomblock.block.entity.LimeDoomBlockEntity;
import net.mods.doomblock.block.entity.LightBlueDoomBlockEntity;
import net.mods.doomblock.block.entity.CyanDoomBlockEntity;
import net.mods.doomblock.block.entity.BlueDoomBlockEntity;
import net.mods.doomblock.block.entity.PurpleDoomBlockEntity;
import net.mods.doomblock.block.entity.MagentaDoomBlockEntity;
import net.mods.doomblock.block.entity.PinkDoomBlockEntity;
import net.mods.doomblock.block.entity.WhiteDoomBlockEntity;

// Other

import net.mods.doomblock.block.entity.InvisibleDoomBlockEntity;

/* Doom Blocks End */

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber
public class DoomBlockModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DoomBlockMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DoomBlockEntity>> DOOM = register("doom", DoomBlockModBlocks.DOOM, DoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RedDoomBlockEntity>> RED_DOOM = register("red_doom", DoomBlockModBlocks.RED_DOOM, RedDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OrangeDoomBlockEntity>> ORANGE_DOOM = register("orange_doom", DoomBlockModBlocks.ORANGE_DOOM, OrangeDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<YellowDoomBlockEntity>> YELLOW_DOOM = register("yellow_doom", DoomBlockModBlocks.YELLOW_DOOM, YellowDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LimeDoomBlockEntity>> LIME_DOOM = register("lime_doom", DoomBlockModBlocks.LIME_DOOM, LimeDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LightBlueDoomBlockEntity>> LIGHT_BLUE_DOOM = register("light_blue_doom", DoomBlockModBlocks.LIGHT_BLUE_DOOM, LightBlueDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CyanDoomBlockEntity>> CYAN_DOOM = register("cyan_doom", DoomBlockModBlocks.CYAN_DOOM, CyanDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlueDoomBlockEntity>> BLUE_DOOM = register("blue_doom", DoomBlockModBlocks.BLUE_DOOM, BlueDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PurpleDoomBlockEntity>> PURPLE_DOOM = register("purple_doom", DoomBlockModBlocks.PURPLE_DOOM, PurpleDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagentaDoomBlockEntity>> MAGENTA_DOOM = register("magenta_doom", DoomBlockModBlocks.MAGENTA_DOOM, MagentaDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PinkDoomBlockEntity>> PINK_DOOM = register("pink_doom", DoomBlockModBlocks.PINK_DOOM, PinkDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteDoomBlockEntity>> WHITE_DOOM = register("white_doom", DoomBlockModBlocks.WHITE_DOOM, WhiteDoomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InvisibleDoomBlockEntity>> INVISIBLE_DOOM = register("invisible_doom", DoomBlockModBlocks.INVISIBLE_DOOM, InvisibleDoomBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RED_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ORANGE_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, YELLOW_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIME_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIGHT_BLUE_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CYAN_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLUE_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PURPLE_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAGENTA_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PINK_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_DOOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, INVISIBLE_DOOM.get(), SidedInvWrapper::new);
	}
}