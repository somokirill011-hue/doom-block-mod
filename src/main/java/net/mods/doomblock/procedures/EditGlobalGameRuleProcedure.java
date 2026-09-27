package net.mods.doomblock.procedures;

import javax.annotation.Nullable;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.mods.doomblock.DoomBlockMod;
import net.mods.doomblock.inits.DoomBlockModBlocks;
import net.mods.doomblock.inits.DoomBlockModGameRules;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

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
    Player _plr = (Player) entity;
    if (_plr.experienceLevel >= 20 &&
      world.getBlockState(BlockPos.containing(x, y + 2.0D, z)).getBlock() == Blocks.DRIPSTONE_BLOCK &&
      world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == DoomBlockModBlocks.DOOM.get() &&
      world.getBlockState(BlockPos.containing(x, y, z + 1.0D)).getBlock() == DoomBlockModBlocks.DOOM.get() &&
      world.getBlockState(BlockPos.containing(x, y, z - 1.0D)).getBlock() == DoomBlockModBlocks.DOOM.get() &&
      world.getBlockState(BlockPos.containing(x + 1.0D, y, z)).getBlock() == DoomBlockModBlocks.DOOM.get() &&
      world.getBlockState(BlockPos.containing(x - 1.0D, y, z)).getBlock() == DoomBlockModBlocks.DOOM.get() &&
      world.getBlockState(BlockPos.containing(x, y - 2.0D, z)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x + 1.0D, y - 2.0D, z)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x - 1.0D, y - 2.0D, z)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x, y - 2.0D, z - 1.0D)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x, y - 2.0D, z + 1.0D)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x + 1.0D, y - 2.0D, z + 1.0D)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x - 1.0D, y - 2.0D, z - 1.0D)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x - 1.0D, y - 2.0D, z + 1.0D)).getBlock() == Blocks.SCULK_SENSOR &&
      world.getBlockState(BlockPos.containing(x + 1.0D, y - 2.0D, z - 1.0D)).getBlock() == Blocks.SCULK_SENSOR)
          if (hasEntityInInventory(entity, new ItemStack(Blocks.REDSTONE_BLOCK)) &&
            hasEntityInInventory(entity, new ItemStack(Items.DIAMOND)) &&
            hasEntityInInventory(entity, new ItemStack(Items.TRIDENT))) {
            if (((LivingEntity) entity).getMainHandItem().getItem() == Blocks.DRIPSTONE_BLOCK.asItem() &&
				entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel _serverLevel0
						&& _plr5.getAdvancements().getOrStartProgress(_serverLevel0.getServer().getAdvancements().get(ResourceLocation.parse("minecraft:adventure/kill_all_mobs"))).isDone()) {
					if (entity instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel _serverLevel1
							&& _plr6.getAdvancements().getOrStartProgress(_serverLevel1.getServer().getAdvancements().get(ResourceLocation.parse("minecraft:adventure/lightning_rod_with_villager_no_fire"))).isDone()) {
						if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _levelse) {
							AdvancementHolder _adv = _levelse.getServer().getAdvancements().get(ResourceLocation.parse("doom_block:doom_block_disable"));
								if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
						ItemStack _stk1 = new ItemStack(Items.DIAMOND);
						_player.getInventory().clearOrCountMatchingItems(p -> _stk1.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						ItemStack _stk2 = new ItemStack(Items.TRIDENT);
						_player.getInventory().clearOrCountMatchingItems(p -> _stk2.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						ItemStack _stk3 = new ItemStack(Blocks.REDSTONE_BLOCK);
						_player.getInventory().clearOrCountMatchingItems(p -> _stk3.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						ItemStack _stk4 = new ItemStack(Blocks.DRIPSTONE_BLOCK);
						_player.getInventory().clearOrCountMatchingItems(p -> _stk4.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      DoomBlockMod.queueServerWork(20, () -> {
                        if (world instanceof ServerLevel _level) {
                          _level.setDayTime(18000L);
                          ((GameRules.BooleanValue) _level.getGameRules().getRule(GameRules.RULE_DAYLIGHT)).set(false, _level.getServer());
                        }
                      });
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      if (world instanceof Level _level) {
                        if (!_level.isClientSide())
                          _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                      }
                      DoomBlockMod.queueServerWork(40, () -> {
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                          } else {
                            _level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                          }
                        }
                        if (entity instanceof Player _plr1) {
                          _plr1.giveExperiencePoints(-20);
                        }
                        if (world instanceof ServerLevel _level) {
                          LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
                          entityToSpawn.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                          _level.addFreshEntity(entityToSpawn);
							entityToSpawn.setVisualOnly(true);
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "weather thunder");
                        }
                      });
                      DoomBlockMod.queueServerWork(100, () -> {
                        if (world instanceof ServerLevel _level) {
                          ((GameRules.BooleanValue) _level.getGameRules().getRule(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY)).set(false, _level.getServer());
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~4 ~ ~4 ~-4 ~1 ~-4 diamond_block");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~3 ~1 ~3 ~-3 ~1 ~-3 diamond_block");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~2 ~2 ~2 ~-2 ~2 ~-2 diamond_block");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~1 ~3 ~1 ~1 ~3 ~1 diamond_block");
                        }
                        world.setBlock(BlockPos.containing(x, y + 4.0D, z), Blocks.BEACON.defaultBlockState(), 3);
                        if (world instanceof ServerLevel _level) {
                          LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
                          entityToSpawn.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                          _level.addFreshEntity(entityToSpawn);
							entityToSpawn.setVisualOnly(true);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(120, () -> {
                        if (entity instanceof Player _plr2) {
                          if (!_plr2.level().isClientSide())
                            _plr2.displayClientMessage(Component.literal(Component.translatable("theBlockKillsTheEntityFalse.send_message").getString()), false);
                        }
                        if (world instanceof ServerLevel _level) {
                          ((GameRules.BooleanValue) _level.getGameRules().getRule(GameRules.RULE_DAYLIGHT)).set(true, _level.getServer());
                          FallingBlockEntity.fall(_level, BlockPos.containing(x, y + 12.0D, z), DoomBlockModBlocks.DOOM.get().defaultBlockState());
                        }
                        if (world instanceof ServerLevel _level) {
                          Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
                          if (entityToSpawn != null);
                        }
                      });
                      DoomBlockMod.queueServerWork(320, () -> {
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                          } else {
                            _level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                          }
                        }
                        if (entity instanceof Player _plr3) {
                          if (!_plr3.level().isClientSide())
                            _plr3.displayClientMessage(Component.literal("00:10"), false);
                        }
                        if (world instanceof ServerLevel _level) {
                          LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
                          entityToSpawn.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                          _level.addFreshEntity(entityToSpawn);
							entityToSpawn.setVisualOnly(true);
                        }
                      });
                      DoomBlockMod.queueServerWork(1320, () -> {
                        if (entity instanceof Player _plr4) {
                          if (!_plr4.level().isClientSide())
                            _plr4.displayClientMessage(Component.literal("01:00"), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(2520, () -> {
                        if (entity instanceof Player _plr10) {
                          if (!_plr10.level().isClientSide())
                            _plr10.displayClientMessage(Component.literal("02:00"), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(3720, () -> {
                        if (entity instanceof Player _plr11) {
                          if (!_plr11.level().isClientSide())
                            _plr11.displayClientMessage(Component.literal("03:00!"), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(4920, () -> {
                        if (entity instanceof Player _plr7) {
                          if (!_plr7.level().isClientSide())
                            _plr7.displayClientMessage(Component.literal("04:00!!"), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x - 16.0D, y, z + 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x + 16.0D, y, z - 16.0D, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(5520, () -> {
                        if (entity instanceof Player _plr8) {
                          if (!_plr8.level().isClientSide())
                            _plr8.displayClientMessage(Component.literal("04:30!!!"), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
                      DoomBlockMod.queueServerWork(5920, () -> {
                        if (entity instanceof Player _plr12) {
                          if (!_plr12.level().isClientSide())
                            _plr12.displayClientMessage(Component.literal("04:50!!!!!"), false);
                        }
                      });
                      DoomBlockMod.queueServerWork(6120, () -> {
                        if (world instanceof ServerLevel _serverLevel) {
                          ((GameRules.BooleanValue) _serverLevel.getGameRules().getRule(GameRules.RULE_DAYLIGHT)).set(false, _serverLevel.getServer());
                          ((GameRules.BooleanValue) _serverLevel.getGameRules().getRule(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY)).set(true, _serverLevel.getServer());
                        }
                        if (world instanceof ServerLevel _level) {
                          LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
                          entityToSpawn.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                          _level.addFreshEntity(entityToSpawn);
							entityToSpawn.setVisualOnly(true);
                        }
                        if (entity instanceof Player _plr13) {
                          _plr13.giveExperiencePoints(5);
                        }
                        if (entity instanceof Player _plr14) {
                          if (!_plr14.level().isClientSide())
                            _plr14.displayClientMessage(Component.literal(Component.translatable("theBlockKillsTheEntityЕкгу.send_message").getString()), false);
                        }
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                          } else {
                            _level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("doom_block:sirena")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                          }
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~4 ~ ~4 ~-4 ~1 ~-4 air");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~3 ~1 ~3 ~-3 ~1 ~-3 air");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~2 ~2 ~2 ~-2 ~2 ~-2 air");
                        }
                        if (world instanceof ServerLevel _level) {
                          _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "fill ~1 ~3 ~1 ~1 ~3 ~1 air");
                        }
                        world.setBlock(BlockPos.containing(x, y + 4.0D, z), Blocks.AIR.defaultBlockState(), 3);
                        if (world instanceof Level _level) {
                          if (!_level.isClientSide())
                            _level.explode(null, x, y, z, 12.0F, Level.ExplosionInteraction.BLOCK);
                        }
                      });
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
	
	    CompoundTag frontText = nbt.getCompound("front_text").orElse(new CompoundTag());
	    ListTag messages = frontText.getList("messages").orElse(new ListTag());
	    String[] result = new String[messages.size()];
	    for (int i = 0; i < messages.size(); i++) {
	        result[i] = messages.getString(i).orElse("");
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
