/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.inits;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mods.doomblock.DoomBlockMod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class DoomBlockModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, DoomBlockMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> SIRENA = REGISTRY.register("sirena", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("doom_block", "sirena")));
}