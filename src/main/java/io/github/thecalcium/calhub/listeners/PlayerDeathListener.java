package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    FileConfiguration cfg;

    public PlayerDeathListener (CalHub plugin){
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.death").replace("{PLAYER}", event.getEntity().getDisplayName())));
    }
}
