package io.github.thecalcium.calhub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!(event.getPlayer().hasPermission("calhub.canplace"))) {
            event.setCancelled(true);
        }
    }
}
