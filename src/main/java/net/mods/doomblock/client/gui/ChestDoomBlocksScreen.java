package net.mods.doomblock.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.mods.doomblock.world.inventory.ChestDoomBlocksMenu;
import net.mods.doomblock.network.ChestDoomBlocksButtonMessage;
import net.mods.doomblock.init.DoomBlockModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChestDoomBlocksScreen extends AbstractContainerScreen<ChestDoomBlocksMenu> implements DoomBlockModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_cancel;
	private Button button_give;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("doom_block:textures/screens/chest_doom_blocks.png");

	public ChestDoomBlocksScreen(ChestDoomBlocksMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 296;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.doom_block.chest_doom_blocks.label_mini_doom_chest"), 6, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.doom_block.chest_doom_blocks.button_cancel"), e -> {
			int x = ChestDoomBlocksScreen.this.x;
			int y = ChestDoomBlocksScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ChestDoomBlocksButtonMessage(0, x, y, z));
				ChestDoomBlocksButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 21, this.topPos + 46, 55, 20).build();
		this.addRenderableWidget(button_cancel);
		button_give = Button.builder(Component.translatable("gui.doom_block.chest_doom_blocks.button_give"), e -> {
			int x = ChestDoomBlocksScreen.this.x;
			int y = ChestDoomBlocksScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ChestDoomBlocksButtonMessage(1, x, y, z));
				ChestDoomBlocksButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 213, this.topPos + 45, 45, 20).build();
		this.addRenderableWidget(button_give);
	}
}