package net.mods.doomblock.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.mods.doomblock.inits.DoomBlockModBlocks;
import net.mods.doomblock.inits.DoomBlockModGameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.server.level.ServerLevel;

public class DoomBlockKillLogicCommandProcedure {
  private static final Logger LOGGER = LogManager.getLogger();
  
  public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
    if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(DoomBlockModGameRules.THE_BLOCK_KILLS_THE_ENTITY) == true) {
      boolean kill = false;
      int radiusX = 3;
      int radiusY = 3;
      int radiusZ = 3;
      try {
        kill = BoolArgumentType.getBool(arguments, "kill");
      } catch (Exception exception) {}
      try {
        radiusX = (int)Math.floor(DoubleArgumentType.getDouble(arguments, "radiusX"));
        radiusY = (int)Math.floor(DoubleArgumentType.getDouble(arguments, "radiusY"));
        radiusZ = (int)Math.floor(DoubleArgumentType.getDouble(arguments, "radiusZ"));
        if (radiusX > 32)
          radiusX = 32; 
        if (radiusY > 32)
          radiusY = 32; 
        if (radiusZ > 32)
          radiusZ = 32; 
      } catch (Exception exception) {}
      double xPos = ((CommandSourceStack)arguments.getSource()).getPosition().x();
      double yPos = ((CommandSourceStack)arguments.getSource()).getPosition().y();
      double zPos = ((CommandSourceStack)arguments.getSource()).getPosition().z();
      BlockPos centerPos = new BlockPos((int)Math.floor(xPos), (int)Math.floor(yPos), (int)Math.floor(zPos));
      int changedCount = 0;
      for (int dx = -radiusX; dx <= radiusX; dx++) {
        for (int dy = -radiusY; dy <= radiusY; dy++) {
          for (int dz = -radiusZ; dz <= radiusZ; dz++) {
            if (dx != 0 || dy != 0 || dz != 0) {
              BlockPos pos = centerPos.offset(dx, dy, dz);
              BlockState state = world.getBlockState(pos);
              if (state.is((Block)DoomBlockModBlocks.DOOM.get())) {
                Property<?> propGeneric = state.getBlock().getStateDefinition().getProperty("kill");
                if (propGeneric instanceof BooleanProperty) {
                  BooleanProperty prop = (BooleanProperty)propGeneric;
                  world.setBlock(pos, (BlockState)state.setValue((Property)prop, Boolean.valueOf(kill)), 3);
                  changedCount++;
                } 
              } 
            } 
          } 
        } 
      } 
      LOGGER.info("Изменено блоков: {}, радиус: {}x{}x{}", Integer.valueOf(changedCount), Integer.valueOf(radiusX), Integer.valueOf(radiusY), Integer.valueOf(radiusZ));
    } 
  }
}
