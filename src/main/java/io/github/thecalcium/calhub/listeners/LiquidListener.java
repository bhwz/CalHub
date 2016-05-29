package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class LiquidListener implements Listener {

    FileConfiguration cfg;

    public LiquidListener(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.STATIONARY_WATER || material == Material.STATIONARY_LAVA
                && cfg.getBoolean("noliquidflow")) {
                    event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.STATIONARY_WATER || material == Material.WATER ||
                material == Material.LAVA || material == Material.STATIONARY_LAVA && cfg.getBoolean("noliquidflow")) {
                    event.setCancelled(true);
        }
    }
}
