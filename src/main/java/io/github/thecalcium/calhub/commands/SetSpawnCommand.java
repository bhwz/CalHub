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

    CalHub plugin;
    FileConfiguration cfg;

    public SetSpawnCommand(CalHub plugin) {
        this.plugin = plugin;
        cfg = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player in game to do that.");
            return true;
        }

        Player player = (Player)sender;
        if(label.equalsIgnoreCase("setspawn")) {
            if (!(player.hasPermission("calhub.setspawn"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.cmdnoperms")));
                return true;
            }

            Location playerLocation = player.getLocation();
            player.getWorld().setSpawnLocation(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ());

            if (cfg.contains("spawndata.pitch")) {
                cfg.set("spawndata.pitch", Math.round(playerLocation.getPitch()));
            } else {
                sender.sendMessage(ChatColor.RED + "There was an error while setting spawn pitch.");
            }

            if (cfg.contains("spawndata.yaw")) {
                cfg.set("spawndata.yaw", Math.round(playerLocation.getYaw()));
            } else {
                sender.sendMessage(ChatColor.RED + "There was an error while setting spawn yaw.");
            }

            plugin.saveConfig();

            player.sendMessage(ChatColor.GREEN + "Spawn set!");
            return true;
        }
        return false;
    }
}
