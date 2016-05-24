package io.github.thecalcium.calhub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.candrop"))) {
            event.setCancelled(true);
        }
    }
}
