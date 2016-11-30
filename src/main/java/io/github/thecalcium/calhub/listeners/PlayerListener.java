package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.HashMap;

public class PlayerListener implements Listener {

    private FileConfiguration config;

    private HashMap<String, String> groupsMap = new HashMap<String, String>();

    public PlayerListener(CalHub plugin) {
        config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.translateAlternateColorCodes
                ('&', config.getString("messages.join").replace("{PLAYER}", event.getPlayer().getDisplayName())));

        if (config.getBoolean("joinspawn")) {
            Location spawn = event.getPlayer().getWorld().getSpawnLocation();
            spawn.setPitch(((float) config.getInt("spawndata.pitch")));
            spawn.setYaw(((float) config.getInt("spawndata.yaw")));
            event.getPlayer().teleport(spawn);
        }

        if (config.getBoolean("clearchatonjoin")) {
            for (int i = 1; i < 64; i++) {
                event.getPlayer().sendMessage("                ");
            }
        }

        for (String line : config.getStringList("messages.motd")) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    line.replace("{PLAYER}", event.getPlayer().getDisplayName())));
        }

        groupsMap.put(event.getPlayer().getName(), "default");
        for (PermissionAttachmentInfo permission : event.getPlayer().getEffectivePermissions()) {
            String permissionNode = permission.getPermission();
            if (permissionNode.startsWith("group.") && permission.getValue()) {
                groupsMap.put(event.getPlayer().getName(), permissionNode.substring(permissionNode.lastIndexOf('.')));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.translateAlternateColorCodes
                ('&', config.getString("messages.quit").replace("{PLAYER}", event.getPlayer().getDisplayName())));
        groupsMap.remove(event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        String group = groupsMap.get(event.getPlayer().getName());
        event.setFormat(ChatColor.translateAlternateColorCodes('&', config.getString("messages.chatformat." + group)
                .replace("{PLAYER}", event.getPlayer().getDisplayName()).replace("{MESSAGE}", event.getMessage())));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(ChatColor.translateAlternateColorCodes
                ('&', config.getString("messages.death").replace("{PLAYER}", event.getEntity().getDisplayName())));
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Location spawn = event.getPlayer().getWorld().getSpawnLocation();
        spawn.setPitch(((float) config.getInt("spawndata.pitch")));
        spawn.setYaw(((float) config.getInt("spawndata.yaw")));
        event.setRespawnLocation(spawn);
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if((config.getBoolean("voidtp")) && (event.getEntity() instanceof Player) && (event.getCause().equals(EntityDamageEvent.DamageCause.VOID))) {
            event.setCancelled(true);
            Location spawn = event.getEntity().getWorld().getSpawnLocation();
            spawn.setPitch(((float) config.getInt("spawndata.pitch")));
            spawn.setYaw(((float) config.getInt("spawndata.yaw")));
            event.getEntity().teleport(spawn);
            event.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.voidtp")));
        }
    }
}
