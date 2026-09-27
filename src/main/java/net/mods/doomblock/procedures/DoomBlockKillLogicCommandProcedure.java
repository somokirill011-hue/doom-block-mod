package net.mods.doomblock.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.resources.ResourceLocation;
import net.mods.doomblock.init.DoomBlocksList;
import net.mods.doomblock.init.DoomBlockModGameRules;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.level.block.state.properties.Property;

public class DoomBlockKillLogicCommandProcedure {
    private static final Logger LOGGER = LogManager.getLogger();

    public static int execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, String type, boolean kill) {
        if (!world.getLevelData().getGameRules().getBoolean(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY)) {
            return 0;
        }

        int radiusX = 3;
        int radiusY = 3;
        int radiusZ = 3;

        try {
            radiusX = (int) Math.floor(DoubleArgumentType.getDouble(arguments, "radiusX"));
            radiusY = (int) Math.floor(DoubleArgumentType.getDouble(arguments, "radiusY"));
            radiusZ = (int) Math.floor(DoubleArgumentType.getDouble(arguments, "radiusZ"));

            if (radiusX > 32) radiusX = 32;
            if (radiusY > 32) radiusY = 32;
            if (radiusZ > 32) radiusZ = 32;
        } catch (Exception e) {
            // оставляем дефолт 3
        }

        BlockPos centerPos = new BlockPos(
            (int) Math.floor(arguments.getSource().getPosition().x()),
            (int) Math.floor(arguments.getSource().getPosition().y()),
            (int) Math.floor(arguments.getSource().getPosition().z())
        );

        int changedCount = 0;

        for (int dx = -radiusX; dx <= radiusX; dx++) {
            for (int dy = -radiusY; dy <= radiusY; dy++) {
                for (int dz = -radiusZ; dz <= radiusZ; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;

                    BlockPos pos = centerPos.offset(dx, dy, dz);
                    BlockState state = world.getBlockState(pos);
                    var block = state.getBlock();

                    // Используем новую проверку из DoomBlocksList
                    if (DoomBlocksList.matchesDoomType(block, type)) {
                        Property<?> propGeneric = block.getStateDefinition().getProperty("kill");
                        if (propGeneric instanceof BooleanProperty) {
                            BooleanProperty prop = (BooleanProperty) propGeneric;
                            world.setBlock(pos, state.setValue(prop, kill), 3 | 2);
                            changedCount++;
                        }
                    }
                }
            }
        }

        LOGGER.info("Изменено блоков: {}, тип: {}, радиус: {}x{}x{}", changedCount, type, radiusX, radiusY, radiusZ);

        return changedCount;
    }
}
