package net.mods.doomblock.command;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mods.doomblock.procedures.SendMessageCommandProcedure;
import net.mods.doomblock.procedures.DoomBlockKillLogicCommandProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

@EventBusSubscriber
public class DoomBlockCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("doomblock")
		    .requires(source -> source.hasPermission(1))
		    .then(Commands.argument("radiusX", DoubleArgumentType.doubleArg(1, 32))
		        .then(Commands.argument("radiusY", DoubleArgumentType.doubleArg(1, 32))
		            .then(Commands.argument("radiusZ", DoubleArgumentType.doubleArg(1, 32))
		                .then(Commands.argument("type", StringArgumentType.string())
						    .then(Commands.argument("kill", BoolArgumentType.bool())
						        .executes(context -> {
						            SendMessageCommandProcedure.executeDoomBlock(
						                context,
						                context.getArgument("type", String.class),
						                context.getArgument("kill", Boolean.class)
						            );
						            return 1;
						        })
						    )
						)
		            )
		        )
		    )
		);
	}
}