package io.github.thecalcium.calhub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickupListener implements Listener {
    @EventHandler
    public void onItemPickup (PlayerPickupItemEvent event) {
        if(!(event.getPlayer().hasPermission("calhub.canpickup"))) {
            event.setCancelled(true);
        }
    }
}
