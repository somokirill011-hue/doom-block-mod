/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mods.doomblock.fluid.DoomFlartFluid;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class DoomBlockModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, DoomBlockMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> DOOM_FLART = REGISTRY.register("doom_flart", DoomFlartFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_DOOM_FLART = REGISTRY.register("flowing_doom_flart", DoomFlartFluid.Flowing::new);

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(DOOM_FLART.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DOOM_FLART.get(), RenderType.translucent());
		}
	}
}