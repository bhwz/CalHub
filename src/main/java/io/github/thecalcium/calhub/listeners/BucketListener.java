package io.github.thecalcium.calhub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class BucketListener implements Listener {
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
}
