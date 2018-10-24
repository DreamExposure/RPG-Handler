package org.dreamexposure.rpghandler.utils;

import java.util.LinkedHashMap;

/**
 * @author NovaFox161
 * Date Created: 10/24/2018
 * For Project: RPG-Handler
 * Author Website: https://www.novamaday.com
 * Company Website: https://www.dreamexposure.org
 * Contact: nova@dreamexposure.org
 */
public class FileManager {
    public static LinkedHashMap<String, Object> getSettings() {
        LinkedHashMap<String, Object> s = new LinkedHashMap<>();
        
        s.put("DO NOT DELETE.A", "RPGHandler is developed and managed by DreamExposure");
        
        s.put("Updates.Check", true);
        s.put("Updates.Download", false);
        s.put("Console.Debug", false);
        s.put("Console.Verbose", false);
        s.put("Language", "EN_US");
        
        return s;
    }
}