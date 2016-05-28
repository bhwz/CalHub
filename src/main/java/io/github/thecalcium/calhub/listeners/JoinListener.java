package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    FileConfiguration cfg;

    public JoinListener(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.join").replace("{PLAYER}", event.getPlayer().getDisplayName())));

        for (String line : cfg.getStringList("messages.motd")) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    line.replace("{PLAYER}", event.getPlayer().getDisplayName())));
        }
    }
}
