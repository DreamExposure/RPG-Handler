package org.dreamexposure.rpghandler.utils;

import org.bukkit.ChatColor;
import org.dreamexposure.rpghandler.RPGHandler;

import java.util.LinkedHashMap;

/**
 * @author NovaFox161
 * Date Created: 10/24/2018
 * For Project: RPG-Handler
 * Author Website: https://www.novamaday.com
 * Company Website: https://www.dreamexposure.org
 * Contact: nova@dreamexposure.org
 */
@SuppressWarnings("ConstantConditions")
public class MessageManager {
        public static LinkedHashMap<String, Object> getMessages() {
            LinkedHashMap<String, Object> m = new LinkedHashMap<>();
            
            m.put("DO NOT DELETE.A", "RPGHandler is developed and managed by DreamExposure");
            
            m.put("NoPerm", "&4You do not have permission to do that!");
            m.put("NoAccess", "&4You do not have permission to go there!");
            m.put("WrongArgs", "&4Incorrect argument count!");
            
            return m;
        }
        
        public static String getMessage(String path) {
            return ChatColor.translateAlternateColorCodes('&', RPGHandler.get().messages.get().getString(path));
        }
        
        public static String getMessage(String path, String toReplace, String replaceWith) {
            String msgRaw = RPGHandler.get().messages.get().getString(path).replaceAll(toReplace, replaceWith);
            return ChatColor.translateAlternateColorCodes('&', msgRaw);
        }
}