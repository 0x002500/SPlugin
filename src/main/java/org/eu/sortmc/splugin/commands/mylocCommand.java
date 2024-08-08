package org.eu.sortmc.splugin.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class mylocCommand {
    public static void registerCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Registering the "/myloc" command
        dispatcher.register(literal("myloc").executes(ctx -> shareLoction(ctx.getSource())));
    }

    private static int shareLoction(ServerCommandSource source) {
        final PlayerEntity self = source.getPlayer();
        assert self != null;
        int x = (int) Math.floor(self.getX());
        int y = (int) Math.floor(self.getY());
        int z = (int) Math.floor(self.getZ());
        Text textMessage = Text.literal(self.getName().getString() + "在 X: " + x + " Y: " + y + " Z: " + z);
        for (ServerPlayerEntity player : source.getServer().getPlayerManager().getPlayerList()) {
            player.sendMessage(textMessage, false);
        }
        return Command.SINGLE_SUCCESS;
    }
}
