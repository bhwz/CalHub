package io.github.thecalcium.calhub.commands;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final CalHub plugin;
    private final FileConfiguration cfg;

    public SetSpawnCommand(CalHub plugin) {
        this.plugin = plugin;
        this.cfg = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player in game to do that.");
            return true;
        }

        Player player = (Player)sender;
        if(label.equalsIgnoreCase("setspawn")) {
            if (!(sender.hasPermission("calhub.setspawn"))) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.cmdnoperms")));
                return true;
            }
            Location playerLocation = player.getLocation();
            player.getWorld().setSpawnLocation(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ());
            player.sendMessage(ChatColor.GREEN + "Spawn set!");
            return true;
        }
        return false;
    }
}