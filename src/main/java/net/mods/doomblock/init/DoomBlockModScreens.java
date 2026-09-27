/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mods.doomblock.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mods.doomblock.client.gui.ChestDoomBlocksScreen;

@EventBusSubscriber(Dist.CLIENT)
public class DoomBlockModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(DoomBlockModMenus.CHEST_DOOM_BLOCKS.get(), ChestDoomBlocksScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}