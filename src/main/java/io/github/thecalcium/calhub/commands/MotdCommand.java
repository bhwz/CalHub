package io.github.thecalcium.calhub.commands;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MotdCommand implements CommandExecutor {

    FileConfiguration cfg;

    public MotdCommand(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player in game to do that.");
            return true;
        }

        Player player = (Player)sender;
        if (label.equalsIgnoreCase("motd")) {
            if (!(player.hasPermission("calhub.motd"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.cmdnoperms")));
                return true;
            }
            for (String line : cfg.getStringList("messages.motd")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        line.replace("{PLAYER}", player.getDisplayName())));
            }
            return true;
        }
        return false;
    }
}
