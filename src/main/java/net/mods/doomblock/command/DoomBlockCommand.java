package net.mods.doomblock.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.mods.doomblock.procedures.SendMessageCommandProcedure;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class DoomBlockCommand {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal("doomblock")
                .requires(source -> source.hasPermission(1));

        builder.then(Commands.argument("radiusX", DoubleArgumentType.doubleArg(1.0D, 32.0D))
                .then(Commands.argument("radiusY", DoubleArgumentType.doubleArg(1.0D, 32.0D))
                        .then(Commands.argument("radiusZ", DoubleArgumentType.doubleArg(1.0D, 32.0D))
                                .executes(context -> {
                                    SendMessageCommandProcedure.executeDoomBlock(context, false);
                                    return 1;
                                })
                                .then(Commands.argument("kill", BoolArgumentType.bool())
                                        .executes(context -> {
                                            boolean kill = BoolArgumentType.getBool(context, "kill");
                                            SendMessageCommandProcedure.executeDoomBlock(context, kill);
                                            return 1;
                                        })))));

        event.getDispatcher().register(builder);
    }
}
