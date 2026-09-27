package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;

public class DoomEntityCollidesInTheBlockOtherProcedure {
	public static class Invisible {
	    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
	        if (entity == null) {
	            return;
	        }
	
	        BlockPos pos = BlockPos.containing(x, y, z);
	        BlockState state = world.getBlockState(pos);
	        Block block = state.getBlock();
	
	        // Сравниваем с .get() — потому что INVISIBLE_DOOM это RegistryObject<Block>
	        if (block != DoomBlockModBlocks.INVISIBLE_DOOM.get()) {
	            if (entity instanceof LivingEntity living) {
	                living.removeEffect(MobEffects.INVISIBILITY);
	            }
	            return;
	        }
	
	        var blockDef = block.getStateDefinition();
	        Property<?> propKill = blockDef.getProperty("kill");
	        Property<?> propTouch = blockDef.getProperty("killing_with_a_touch");
	
	        boolean isKillActive = false;
	        if (propKill instanceof BooleanProperty) {
	            BooleanProperty p = (BooleanProperty) propKill;
	            isKillActive = state.getValue(p);
	        }
	
	        boolean isTouchActive = false;
	        if (propTouch instanceof BooleanProperty) {
	            BooleanProperty p = (BooleanProperty) propTouch;
	            isTouchActive = state.getValue(p);
	        }
	
	        // ЛОГИКА: эффект, если хотя бы один флаг true
	        if (isKillActive || isTouchActive) {
	            if (entity instanceof LivingEntity living && !world.isClientSide()) {
	                living.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, Integer.MAX_VALUE, 0, false, false));
	            }
	        } else {
	            // Оба false — убираем эффект
	            if (entity instanceof LivingEntity living) {
	                living.removeEffect(MobEffects.INVISIBILITY);
	            }
	        }
	    }
	}
}
