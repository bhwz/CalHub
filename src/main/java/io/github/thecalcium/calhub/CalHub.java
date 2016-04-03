package io.github.thecalcium.calhub;

import io.github.thecalcium.calhub.commands.SetSpawnCommand;
import io.github.thecalcium.calhub.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CalHub extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getCommand("SetSpawn").setExecutor(new SetSpawnCommand(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
