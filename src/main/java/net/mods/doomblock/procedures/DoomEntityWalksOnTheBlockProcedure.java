package net.mods.doomblock.procedures;

import net.mods.doomblock.init.DoomBlockModGameRules;
import net.mods.doomblock.init.DoomBlockModBlocks;
import net.mods.doomblock.init.DoomBlocksList;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;

public class DoomEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState currentState = world.getBlockState(pos);
        Block block = currentState.getBlock();

        // 1. Проверяем, что это Doom-блок
        if (!DoomBlocksList.isDoomBlock(block)) {
            return;
        }

        // 2. Проверяем GameRule: глобально ли разрешено убивать сущностей этим блоком
        if (!world.getLevelData().getGameRules().getBoolean(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY)) {
            return;
        }

        // Получаем свойства
        Property<?> propTouch = block.getStateDefinition().getProperty("killing_with_a_touch");
        Property<?> propKill = block.getStateDefinition().getProperty("kill");

        // Если свойства не найдены — выходим (защита от краша)
        if (!(propTouch instanceof BooleanProperty) || !(propKill instanceof BooleanProperty)) {
            return;
        }

        BooleanProperty touchProp = (BooleanProperty) propTouch;
        BooleanProperty killProp = (BooleanProperty) propKill;

        boolean currentTouch = currentState.getValue(touchProp);
        boolean currentKill = currentState.getValue(killProp);

        // 3. ТВОЯ ЛОГИКА: блок убивает, если kill=true ИЛИ touch=true
        boolean shouldKill = currentKill || currentTouch;

        if (shouldKill) {
            // Наносим урон. 500 — это почти мгновенная смерть, можно уменьшить, если хочешь
            entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 500.0F);
        }
    }
}
