package org.eu.sortmc.splugin.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class suicideCommand {
    public static void registerCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Registering the "/suicide" command
        dispatcher.register(literal("suicide").executes(ctx -> suicide(ctx.getSource())));
    }

    static int suicide(ServerCommandSource source) {
        final PlayerEntity self = source.getPlayer();
        String playerName = self.getDisplayName().getString();
        if (self != null) {
            self.kill();
            source.sendFeedback(() -> Text.literal("Killed player " + playerName), true);
        } else {
            source.sendError(Text.literal("Player " + playerName + " not found."));
        }
        return 1;
    }
}
