package io.github.thecalcium.calhub;

import io.github.thecalcium.calhub.commands.*;
import io.github.thecalcium.calhub.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CalHub extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new WorldListener(this), this);

        getCommand("SetSpawn").setExecutor(new SetSpawnCommand(this));
        getCommand("Spawn").setExecutor(new SpawnCommand(this));
        getCommand("Motd").setExecutor(new MotdCommand(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
