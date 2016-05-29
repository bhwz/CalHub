package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockFadeListener implements Listener {

    FileConfiguration cfg;

    public BlockFadeListener(CalHub plugin) {
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        if (cfg.getBoolean("nofade")) {
            event.setCancelled(true);
        }
    }
}
