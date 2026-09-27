package net.mods.doomblock.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mods.doomblock.procedures.GiveButtonInMiniDoomChestProcedure;
import net.mods.doomblock.procedures.CancelButtonInMiniDoomChestProcedure;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record ChestDoomBlocksButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ChestDoomBlocksButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(DoomBlockMod.MODID, "chest_doom_blocks_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ChestDoomBlocksButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ChestDoomBlocksButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ChestDoomBlocksButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ChestDoomBlocksButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ChestDoomBlocksButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			CancelButtonInMiniDoomChestProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GiveButtonInMiniDoomChestProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DoomBlockMod.addNetworkMessage(ChestDoomBlocksButtonMessage.TYPE, ChestDoomBlocksButtonMessage.STREAM_CODEC, ChestDoomBlocksButtonMessage::handleData);
	}
}