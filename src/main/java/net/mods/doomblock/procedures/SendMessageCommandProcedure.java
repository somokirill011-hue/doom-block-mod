package net.mods.doomblock.procedures;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.common.util.FakePlayerFactory;

public class SendMessageCommandProcedure {
  public static int executeDoomBlock(CommandContext<CommandSourceStack> context, boolean killMode) {
    FakePlayer fakePlayer;
    Level world = ((CommandSourceStack)context.getSource()).getUnsidedLevel();
    double x = ((CommandSourceStack)context.getSource()).getPosition().x();
    double y = ((CommandSourceStack)context.getSource()).getPosition().y();
    double z = ((CommandSourceStack)context.getSource()).getPosition().z();
    Entity entity = ((CommandSourceStack)context.getSource()).getEntity();
    if (entity == null && world instanceof ServerLevel) {
      ServerLevel _servLevel = (ServerLevel)world;
      fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
    } 
    Direction direction = Direction.DOWN;
    DoomBlockKillLogicCommandProcedure.execute((LevelAccessor)world, context);
    int activatedCount = 1;
    double radiusX = ((Double)context.getArgument("radiusX", Double.class)).doubleValue();
    String killStatus = killMode ? "true" : "false";
    MutableComponent mutableComponent = Component.translatable("command.send_message.0", new Object[] { Integer.valueOf(activatedCount), killStatus, Integer.valueOf((int)radiusX) }).withStyle(style -> style.withColor(ChatFormatting.GREEN));
    ((CommandSourceStack)context.getSource()).sendSuccess(() -> mutableComponent, false);
    return 1;
  }
}
