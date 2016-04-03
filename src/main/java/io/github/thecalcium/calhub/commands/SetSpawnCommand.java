package io.github.thecalcium.calhub.commands;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetSpawnCommand implements CommandExecutor {

    private final CalHub plugin;

    public SetSpawnCommand(CalHub plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("setspawn") && sender.hasPermission("calhub.setspawn")) {
            // TODO: Get sender's location and set it as spawn
            return true;
        }
        return false;
    }
}