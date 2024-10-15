package me.pvpclub.opplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerEvents implements Listener {
    private final OPPlugin plugin;
    private final String[] titles = {"Air", "Fire", "Water", "Earth", "Lightning", "Ice"};

    public PlayerEvents(OPPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Display random title for 15 seconds
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            String title = titles[rand.nextInt(titles.length)];
            player.sendMessage(ChatColor.GOLD + "You are now attuned to " + title + "!");
            try {
                Thread.sleep(5000); // Display each title for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Assign initial item based on random title
        player.getInventory().addItem(ItemManager.getRandomAbilityItem());
    }
}