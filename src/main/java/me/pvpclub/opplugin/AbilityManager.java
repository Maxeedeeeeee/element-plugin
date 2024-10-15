package me.pvpclub.opplugin;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class AbilityManager {
    private final HashMap<Player, Long> cooldowns = new HashMap<>();

    public void useAbility(Player player, String ability) {
        long currentTime = System.currentTimeMillis();
        if (cooldowns.containsKey(player) && currentTime < cooldowns.get(player)) {
            player.sendMessage("Ability on cooldown!");
            return;
        }

        switch (ability) {
            case "AirFly":
                AirAbilities.airFly(player);
                break;
            case "AirPush":
                AirAbilities.airPush(player);
                break;
            case "Fireball":
                FireAbilities.fireball(player);
                break;
            case "Firewall":
                FireAbilities.firewall(player);
                break;
            case "WaterStun":
                WaterAbilities.waterStun(player);
                break;
            case "WaterDash":
                WaterAbilities.waterDash(player);
                break;
            case "Earthquake":
                EarthAbilities.earthquake(player);
                break;
            case "LightningStrike":
                LightningAbilities.lightningStrike(player);
                break;
            case "IceDash":
                IceAbilities.iceDash(player);
                break;
            // Additional abilities...
            default:
                player.sendMessage("Invalid ability!");
        }

        cooldowns.put(player, currentTime + getCooldown(ability)); // Set cooldown
    }

    private long getCooldown(String ability) {
        switch (ability) {
            case "AirFly":
                return 60000; // 60 seconds
            case "AirPush":
                return 75000; // 75 seconds
            case "Fireball":
                return 75000; // 75 seconds
            case "Firewall":
                return 90000; // 90 seconds
            case "WaterStun":
                return 45000; // 45 seconds
            case "WaterDash":
                return 30000; // 30 seconds
            case "Earthquake":
                return 75000; // 75 seconds
            case "LightningStrike":
                return 45000; // 45 seconds
            case "IceDash":
                return 30000; // 30 seconds
            // Add other cooldowns...
            default:
                return 0;
        }
    }
}