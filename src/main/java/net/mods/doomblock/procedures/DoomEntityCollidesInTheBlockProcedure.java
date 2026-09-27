package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModBlocks;
import net.mods.doomblock.DoomBlockMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.entity.EntityTypeTest;

public class DoomEntityCollidesInTheBlockProcedure {
	public static class Red {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
			if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.RED_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp1
					? DoomBlockModBlocks.RED_DOOM.get().defaultBlockState().setValue(_withbp1, true)
					: DoomBlockModBlocks.RED_DOOM.get().defaultBlockState())) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~10 ~5 ~10 ~-10 ~5 ~-10 lava");
			}
		}
	}

	public static class Orange {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.ORANGE_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp5
						? DoomBlockModBlocks.ORANGE_DOOM.get().defaultBlockState().setValue(_withbp5, true)
						: DoomBlockModBlocks.ORANGE_DOOM.get().defaultBlockState())) {
					entity.igniteForSeconds(30);
				}
			}
	}

	public static class Yellow {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.YELLOW_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp9
						? DoomBlockModBlocks.YELLOW_DOOM.get().defaultBlockState().setValue(_withbp9, true)
						: DoomBlockModBlocks.YELLOW_DOOM.get().defaultBlockState())) {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
	}

	public static class Lime {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.LIME_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp13
						? DoomBlockModBlocks.LIME_DOOM.get().defaultBlockState().setValue(_withbp13, true)
						: DoomBlockModBlocks.LIME_DOOM.get().defaultBlockState())) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1));
				}
			}
	}

	public static class LightBlue {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.LIGHT_BLUE_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp17
						? DoomBlockModBlocks.LIGHT_BLUE_DOOM.get().defaultBlockState().setValue(_withbp17, true)
						: DoomBlockModBlocks.LIGHT_BLUE_DOOM.get().defaultBlockState())) {
					entity.setTicksFrozen(300);
				}
			}
	}

	public static class Cyan {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.CYAN_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp21
						? DoomBlockModBlocks.CYAN_DOOM.get().defaultBlockState().setValue(_withbp21, true)
						: DoomBlockModBlocks.CYAN_DOOM.get().defaultBlockState())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~3 ~3 ~3 ~-3 ~-3 ~-3 doom_block:cyan_doom");
				}
		}
	}
	public static class Blue {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.BLUE_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp25
						? DoomBlockModBlocks.BLUE_DOOM.get().defaultBlockState().setValue(_withbp25, true)
						: DoomBlockModBlocks.BLUE_DOOM.get().defaultBlockState())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~15 ~15 ~15 ~-15 ~15 ~-15 water");
				}
			}
	}

	public static class Purple {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		    if (entity == null) return;
		
		    BlockPos pos = BlockPos.containing(x, y, z);
		    BlockState state = world.getBlockState(pos);
		
		    if (state.is(DoomBlockModBlocks.PURPLE_DOOM.get())) {
		        Property<?> prop = DoomBlockModBlocks.PURPLE_DOOM.get().getStateDefinition().getProperty("kill");
		        boolean isLethal = false;
		        if (prop instanceof BooleanProperty bp) {
		            isLethal = state.getValue(bp);
		        }
		
		        if (isLethal) {
		            entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 500);
		
		            if (world instanceof ServerLevel serverLevel) {
		                // Запускаем цикл ОДИН раз при активации блока
		                startDoomRadiusLoop(serverLevel, x, y, z, 600, entity); // 600 тиков = 30 сек
		            }
		        }
		    }
		}
		
		private static void startDoomRadiusLoop(ServerLevel level, double centerX, double centerY, double centerZ, int remainingTicks, Entity source) {
		    doOneStepOfDoom(level, centerX, centerY, centerZ, remainingTicks, source);
		}
		
		private static void doOneStepOfDoom(ServerLevel level, double centerX, double centerY, double centerZ, int remainingTicks, Entity source) {
		    if (remainingTicks <= 0) return;
		
		    double radius = 15.0; // Радиус 15 блоков — оптимально для производительности
		    AABB searchBox = new AABB(
		        centerX - radius, centerY - radius, centerZ - radius,
		        centerX + radius, centerY + radius, centerZ + radius
		    );
		
		    // 🔥 ГЛАВНОЕ ИСПРАВЛЕНИЕ: передаём source (игрока) как первый аргумент.
		    // Теперь Java точно знает, какой метод вызывать: getEntities(Entity, AABB, Predicate)
		    List<Entity> entitiesInRange = level.getEntities(
		        source,                 // <-- Вместо null ставим реального игрока
		        searchBox,
		        e -> !e.equals(source)  // <-- Фильтр: все, кроме самого игрока
		    );
		
		    int killedThisStep = 0;
		    int maxTargetsPerStep = 2; // Бьём только 2 моба за шаг, чтобы не лагало
		
		    for (Entity target : entitiesInRange) {
		        if (killedThisStep >= maxTargetsPerStep) break;
		        target.hurt(new DamageSource(level.holderOrThrow(DamageTypes.GENERIC)), 500);
		        killedThisStep++;
		    }
		
		    // Планируем следующий шаг через 5 тиков
		    DoomBlockMod.queueServerWork(5, () -> {
		        doOneStepOfDoom(level, centerX, centerY, centerZ, remainingTicks - 5, source);
		    });
		}
	}

	public static class Magenta {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.MAGENTA_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp34
						? DoomBlockModBlocks.MAGENTA_DOOM.get().defaultBlockState().setValue(_withbp34, true)
						: DoomBlockModBlocks.MAGENTA_DOOM.get().defaultBlockState())) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
				}
			}
	}

	public static class Pink {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.PINK_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp38
						? DoomBlockModBlocks.PINK_DOOM.get().defaultBlockState().setValue(_withbp38, true)
						: DoomBlockModBlocks.PINK_DOOM.get().defaultBlockState())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
	}

	public static class White {
		public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
			if (entity == null)
				return;
				if ((world.getBlockState(BlockPos.containing(x, y, z))) == (DoomBlockModBlocks.WHITE_DOOM.get().getStateDefinition().getProperty("kill") instanceof BooleanProperty _withbp42
						? DoomBlockModBlocks.WHITE_DOOM.get().defaultBlockState().setValue(_withbp42, true)
						: DoomBlockModBlocks.WHITE_DOOM.get().defaultBlockState())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~5 ~5 ~5 ~-5 ~-5 ~-5 snow_block");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~5 ~6 ~5 ~-5 ~6 ~-5 snow");
			}
		}
	}
}