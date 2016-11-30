package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener {

    private FileConfiguration config;

    public WorldListener(CalHub plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.canbreak"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!(event.getPlayer().hasPermission("calhub.canplace"))) {
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
    public void onItemPickup (PlayerPickupItemEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.canpickup"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        if (!(event.getPlayer().hasPermission("calhub.canbucket"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (!(event.getPlayer().hasPermission("calhub.canbucket"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.STATIONARY_WATER || material == Material.STATIONARY_LAVA
                && config.getBoolean("noliquidflow")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.STATIONARY_WATER || material == Material.WATER || material == Material.LAVA
                || material == Material.STATIONARY_LAVA && config.getBoolean("noliquidflow")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        if (config.getBoolean("nofade")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeatherChange (WeatherChangeEvent event) {
        if (event.toWeatherState() && config.getBoolean("noweather")) {
            event.setCancelled(true);
        }
    }
}
