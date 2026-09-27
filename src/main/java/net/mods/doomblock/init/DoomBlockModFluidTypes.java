/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mods.doomblock.fluid.types.DoomFlartFluidType;
import net.mods.doomblock.DoomBlockMod;

public class DoomBlockModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, DoomBlockMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> DOOM_FLART_TYPE = REGISTRY.register("doom_flart", DoomFlartFluidType::new);
}