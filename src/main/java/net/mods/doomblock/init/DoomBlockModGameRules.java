/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class DoomBlockModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> THE_BLOCK_KILLS_THE_ENTITY;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		THE_BLOCK_KILLS_THE_ENTITY = GameRules.register("theBlockKillsTheEntity", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
	}
}