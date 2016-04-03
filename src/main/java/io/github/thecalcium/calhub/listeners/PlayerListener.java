package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final CalHub plugin;
    private final FileConfiguration cfg;

    public PlayerListener(CalHub plugin) {
        this.plugin = plugin;
        this.cfg = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.join").replace("{PLAYER}", event.getPlayer().getName())));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.quit").replace("{PLAYER}", event.getPlayer().getName())));
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.canplace"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.canbreak"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.candrop"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(ChatColor.translateAlternateColorCodes
                ('&', cfg.getString("messages.death").replace("{PLAYER}", event.getEntity().getDisplayName())));
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if((cfg.getBoolean("voidtp")) && (event.getEntity() instanceof Player)&& (event.getCause().equals(EntityDamageEvent.DamageCause.VOID))) {
            // TODO: Cancel damage and teleport player to spawn
            event.setCancelled(false);
        }
    }
}
