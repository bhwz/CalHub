package io.github.thecalcium.calhub;

import io.github.thecalcium.calhub.commands.*;
import io.github.thecalcium.calhub.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CalHub extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new ItemDropListener(), this);
        getServer().getPluginManager().registerEvents(new ItemPickupListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new QuitListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new VoidListener(this), this);
        getServer().getPluginManager().registerEvents(new WeatherListener(this), this);

        getCommand("SetSpawn").setExecutor(new SetSpawnCommand(this));
        getCommand("Spawn").setExecutor(new SpawnCommand(this));
        getCommand("Motd").setExecutor(new MotdCommand(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
