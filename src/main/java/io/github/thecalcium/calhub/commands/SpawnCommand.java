package io.github.thecalcium.calhub.commands;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    FileConfiguration cfg;

    public SpawnCommand(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player in game to do that.");
            return true;
        }

        Player player = (Player)sender;
        if (label.equalsIgnoreCase("spawn")) {
            if (!(player.hasPermission("calhub.spawn"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.cmdnoperms")));
                return true;
            }

            Location spawn = player.getWorld().getSpawnLocation();
            spawn.setPitch(((float) cfg.getInt("spawndata.pitch")));
            spawn.setYaw(((float) cfg.getInt("spawndata.yaw")));
            player.teleport(spawn);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.spawntp")));
            return true;
        }
        return false;
    }
}
