package org.eu.sortmc.splugin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.eu.sortmc.splugin.commands.mylocCommand;
import org.eu.sortmc.splugin.commands.suicideCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPlugin implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("SPlugin");

    @Override
    public void onInitialize() {
        LOGGER.info("Thanks for using SPlugin,a useful and lightweight fork of QPlugin.");
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
            suicideCommand.registerCommand(dispatcher);
            mylocCommand.registerCommand(dispatcher);
        });
    }
}