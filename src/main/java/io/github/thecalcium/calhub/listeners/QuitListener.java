package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    FileConfiguration cfg;

    public QuitListener(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.quit").replace("{PLAYER}", event.getPlayer().getDisplayName())));
    }
}
