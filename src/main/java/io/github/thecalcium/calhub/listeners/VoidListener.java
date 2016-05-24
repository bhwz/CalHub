package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class VoidListener implements Listener {

    FileConfiguration cfg;

    public VoidListener(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if((cfg.getBoolean("voidtp")) && (event.getEntity() instanceof Player) && (event.getCause().equals(EntityDamageEvent.DamageCause.VOID))) {
            event.setCancelled(true);
            Location spawn = event.getEntity().getWorld().getSpawnLocation();
            event.getEntity().teleport(spawn);
            event.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("messages.voidtp")));
        }
    }
}
