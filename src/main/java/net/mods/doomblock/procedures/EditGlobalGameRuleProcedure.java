package net.mods.doomblock.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.mods.doomblock.init.DoomBlockModGameRules;
import net.mods.doomblock.init.DoomBlockModBlocks;
import net.mods.doomblock.init.DoomBlocksList;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.level.block.SignBlock;

import javax.annotation.Nullable;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import java.util.Set;

@EventBusSubscriber
public class EditGlobalGameRuleProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 20) {
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.DRIPSTONE_BLOCK) {
			BlockState blockState1 = world.getBlockState(BlockPos.containing(x, y - 1, z));
			Block block1 = blockState1.getBlock();
			
			if (
			block1 == DoomBlockModBlocks.DOOM.get() ||
			block1 == DoomBlockModBlocks.RED_DOOM.get() ||
			block1 == DoomBlockModBlocks.ORANGE_DOOM.get() ||
			block1 == DoomBlockModBlocks.YELLOW_DOOM.get() ||
			block1 == DoomBlockModBlocks.LIME_DOOM.get() ||
			block1 == DoomBlockModBlocks.LIGHT_BLUE_DOOM.get() ||
			block1 == DoomBlockModBlocks.BLUE_DOOM.get() ||
			block1 == DoomBlockModBlocks.PURPLE_DOOM.get() ||
			block1 == DoomBlockModBlocks.MAGENTA_DOOM.get() ||
			block1 == DoomBlockModBlocks.PINK_DOOM.get() ||
			block1 == DoomBlockModBlocks.WHITE_DOOM.get()) {
			BlockState blockState2 = world.getBlockState(BlockPos.containing(x, y, z + 1));
			Block block2 = blockState2.getBlock();

			boolean zPlus  = DoomBlocksList.isDoomBlock(world.getBlockState(BlockPos.containing(x, y, z + 1)).getBlock());
			boolean zMinus = DoomBlocksList.isDoomBlock(world.getBlockState(BlockPos.containing(x, y, z - 1)).getBlock());
			boolean xPlus  = DoomBlocksList.isDoomBlock(world.getBlockState(BlockPos.containing(x + 1, y, z)).getBlock());
			boolean xMinus = DoomBlocksList.isDoomBlock(world.getBlockState(BlockPos.containing(x - 1, y, z)).getBlock());
			
			if (zPlus && zMinus && xPlus && xMinus) {
								if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == DoomBlockModBlocks.DOOM.get()) {
									if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.SCULK_SENSOR) {
										if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).getBlock() == Blocks.SCULK_SENSOR) {
											if ((world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).getBlock() == Blocks.SCULK_SENSOR) {
												if ((world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).getBlock() == Blocks.SCULK_SENSOR) {
													if ((world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).getBlock() == Blocks.SCULK_SENSOR) {
														if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z + 1))).getBlock() == Blocks.SCULK_SENSOR) {
															if ((world.getBlockState(BlockPos.containing(x - 1, y - 2, z - 1))).getBlock() == Blocks.SCULK_SENSOR) {
																if ((world.getBlockState(BlockPos.containing(x - 1, y - 2, z + 1))).getBlock() == Blocks.SCULK_SENSOR) {
																	if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z - 1))).getBlock() == Blocks.SCULK_SENSOR) {
//																		BlockPos centerPos = BlockPos.containing(x, y, z);
//
//																		if (isDoomSignConfigured(world, centerPos)) {
																		if (hasEntityInInventory(entity, new ItemStack(Blocks.REDSTONE_BLOCK))) {
																					if (hasEntityInInventory(entity, new ItemStack(Items.DIAMOND))) {
																						if (hasEntityInInventory(entity, new ItemStack(Items.TRIDENT))) {
																							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.DRIPSTONE_BLOCK.asItem()) {
																								if (entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
																										&& _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().get(ResourceLocation.parse("minecraft:adventure/kill_all_mobs"))).isDone()) {
																									if (entity instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
																											&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().get(ResourceLocation.parse("minecraft:adventure/lightning_rod_with_villager_no_fire"))).isDone()) {
																										if (entity instanceof ServerPlayer _player) {
																											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("doom_block:doom_block_disable"));
																											if (_adv != null) {
																												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																												if (!_ap.isDone()) {
																													for (String criteria : _ap.getRemainingCriteria())
																														_player.getAdvancements().award(_adv, criteria);
																												if (entity instanceof Player _plr) {
																													ItemStack _stktoremove = new ItemStack(Items.DIAMOND);
																													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
																												}
																												if (entity instanceof Player _plr) {
																													ItemStack _stktoremove = new ItemStack(Items.TRIDENT);
																													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
																												}
																												if (entity instanceof Player _plr) {
																													ItemStack _stktoremove = new ItemStack(Blocks.REDSTONE_BLOCK);
																													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
																												}
																												if (entity instanceof Player _plr) {
																													ItemStack _stktoremove = new ItemStack(Blocks.DRIPSTONE_BLOCK);
																													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
																												}
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												DoomBlockMod.queueServerWork(10, () -> {
																												});
																												DoomBlockMod.queueServerWork(20, () -> {
																													if (world instanceof ServerLevel _level)
																														_level.setDayTime(18000);
																													world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
																												});
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												DoomBlockMod.queueServerWork(40, () -> {
																													if (world instanceof Level _level) {
																														if (!_level.isClientSide()) {
																															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1, 1);
																														} else {
																															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1, 1, false);
																														}
																													}
																													if (entity instanceof Player _plr)
																														_player.giveExperiencePoints(-(20));
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"weather thunder");
																												});
																												DoomBlockMod.queueServerWork(100, () -> {
																													world.getLevelData().getGameRules().getRule(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY).set(true, world.getServer());
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~4 ~ ~4 ~-4 ~1 ~-4 diamond_block");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~3 ~1 ~3 ~-3 ~1 ~-3 diamond_block");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~2 ~2 ~2 ~-2 ~2 ~-2 diamond_block");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~1 ~3 ~1 ~1 ~3 ~1 diamond_block");
																													world.setBlock(BlockPos.containing(x, y + 4, z), Blocks.BEACON.defaultBlockState(), 3);
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(120, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal((Component.translatable("theBlockKillsTheEntityFalse.send_message").getString())), false);
																													world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, world.getServer());
																													if (world instanceof ServerLevel _level)
																														FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 12, z), DoomBlockModBlocks.DOOM.get().defaultBlockState());
																													if (world instanceof ServerLevel _level) {
																														Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																														if (entityToSpawn != null) {
																														}
																													}
																												});
																												DoomBlockMod.queueServerWork(320, () -> {
																													if (world instanceof Level _level) {
																														if (!_level.isClientSide()) {
																															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1, 1);
																														} else {
																															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1, 1, false);
																														}
																													}
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("00:10"), false);
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																												});
																												DoomBlockMod.queueServerWork(1320, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("01:00"), false);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(2520, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("02:00"), false);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(3720, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("03:00!"), false);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(4920, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("04:00!!"), false);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, z, 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x - 16), y, (z + 16), 12, Level.ExplosionInteraction.BLOCK);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, (x + 16), y, (z - 16), 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(5520, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("04:30!!!"), false);
																												if (world instanceof Level _level && !_level.isClientSide())
																													_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												});
																												DoomBlockMod.queueServerWork(5920, () -> {
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal("04:50!!!!!"), false);
																												});
																												DoomBlockMod.queueServerWork(6120, () -> {
																													world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
																													world.getLevelData().getGameRules().getRule(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY).set(true, world.getServer());
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																													if (entity instanceof Player _plr)
																														_player.giveExperiencePoints(5);
																													if (entity instanceof Player _plr && !_player.level().isClientSide())
																														_player.displayClientMessage(Component.literal((Component.translatable("theBlockKillsTheEntity\u0415\u043A\u0433\u0443.send_message").getString())), false);
																													if (world instanceof Level _level) {
																														if (!_level.isClientSide()) {
																															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 2, 2);
																														} else {
																															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 2, 2, false);
																														}
																													}
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~4 ~ ~4 ~-4 ~1 ~-4 air");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~3 ~1 ~3 ~-3 ~1 ~-3 air");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~2 ~2 ~2 ~-2 ~2 ~-2 air");
																													if (world instanceof ServerLevel _level)
																														_level.getServer().getCommands().performPrefixedCommand(
																																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																																		.withSuppressedOutput(),
																																"fill ~1 ~3 ~1 ~1 ~3 ~1 air");
																													world.setBlock(BlockPos.containing(x, y + 4, z), Blocks.AIR.defaultBlockState(), 3);
																													if (world instanceof Level _level && !_level.isClientSide())
																														_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.BLOCK);
																												});
																											}
									//																	}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
	}

	private static String[] getSignMessages(LevelAccessor world, BlockPos pos) {
	    BlockEntity blockEntity = world.getBlockEntity(pos);
	
	    CompoundTag nbt = blockEntity.getPersistentData();
	
	    CompoundTag frontText = nbt.getCompound("front_text");
	    ListTag messages = frontText.getList("messages", Tag.TAG_STRING);
	    String[] result = new String[messages.size()];
	    for (int i = 0; i < messages.size(); i++) {
	        result[i] = messages.getString(i);
	    }
	    return result;
	}

	private static boolean isDoomSignConfigured(LevelAccessor world, BlockPos pos) {
    	String[] messages = getSignMessages(world, pos);
    	return messages.length >= 4 &&
            "\"Gamerule:\"".equals(messages) &&
            "\"theBlockKillsTheE\"".equals(messages) &&
            "\"ntity\"".equals(messages) &&
            "\"true\"".equals(messages);
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
