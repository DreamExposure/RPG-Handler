package org.dreamexposure.rpghandler.handler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.dreamexposure.rpghandler.RPGHandler;

import java.util.List;

/**
 * @author NovaFox161
 * Date Created: 10/24/2018
 * For Project: RPG-Handler
 * Author Website: https://www.novamaday.com
 * Company Website: https://www.dreamexposure.org
 * Contact: nova@dreamexposure.org
 */
public class FollowerHandler {
    public static void follow(Player player, String god) {
        List<String> followers = RPGHandler.get().followers.get().getStringList(god);
        
        if (!followers.contains(player.getUniqueId().toString())) {
            followers.add(player.getUniqueId().toString());
            RPGHandler.get().followers.get().set(god, followers);
            RPGHandler.get().followers.save();
            
            player.sendMessage(ChatColor.DARK_GREEN + "You are now following: " + god);
        } else {
            player.sendMessage(ChatColor.YELLOW + "You are already following that God!");
        }
    }
    
    public static void unfollow(Player player, String god) {
        List<String> followers = RPGHandler.get().followers.get().getStringList(god);
    
        if (!followers.contains(player.getUniqueId().toString())) {
            followers.remove(player.getUniqueId().toString());
            RPGHandler.get().followers.get().set(god, followers);
            RPGHandler.get().followers.save();
        
            player.sendMessage(ChatColor.DARK_RED + "You are no longer following: " + god);
        } else {
            player.sendMessage(ChatColor.YELLOW + "You are not following that God!");
        }
    }
    
    public static boolean isFollowingGod(Player player) {
        for (String g : RPGHandler.get().config.get().getStringList("Gods")) {
            if (RPGHandler.get().followers.get().getStringList(g).contains(player.getUniqueId().toString()))
                return true;
        }
        return false;
    }
    
    public static boolean godExists(String godName) {
        List<String> gods = RPGHandler.get().config.get().getStringList("Gods");
        return gods.contains(godName.toLowerCase());
    }
}