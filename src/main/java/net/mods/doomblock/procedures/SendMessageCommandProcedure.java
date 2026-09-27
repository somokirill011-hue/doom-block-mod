package net.mods.doomblock.procedures;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.ChatFormatting;
import net.mods.doomblock.procedures.DoomBlockKillLogicCommandProcedure;

public class SendMessageCommandProcedure {
    // Сигнатура теперь принимает type и killMode
    public static int executeDoomBlock(CommandContext<CommandSourceStack> context, String type, boolean killMode) {
        Level world = context.getSource().getUnsidedLevel();

        Entity entity = context.getSource().getEntity();
        if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
        }

        Direction direction = Direction.DOWN;
        if (entity != null) {
            direction = entity.getDirection();
        }

        // Вызываем процедуру и получаем реальное количество изменённых блоков
        int activatedCount = DoomBlockKillLogicCommandProcedure.execute(world, context, type, killMode);

        double radiusX = context.getArgument("radiusX", Double.class);
        String killStatus = killMode ? "true" : "false";

        Component message = Component.translatable(
                "command.send_message.0",
                activatedCount,
                killStatus,
                (int) radiusX
        ).withStyle(style -> style.withColor(ChatFormatting.GREEN));

        context.getSource().sendSuccess(() -> message, false);

        return 1;
    }
}
