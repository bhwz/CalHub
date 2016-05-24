package io.github.thecalcium.calhub.listeners;

import io.github.thecalcium.calhub.CalHub;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {

    FileConfiguration cfg;

    public WeatherListener (CalHub plugin){
        cfg = plugin.getConfig();
    }

    @EventHandler
    public void onWeatherChange (WeatherChangeEvent event) {
        if (event.toWeatherState() && cfg.getBoolean("noweather")) {
            event.setCancelled(true);
        }
    }
}
