package org.dreamexposure.rpghandler;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.dreamexposure.novalib.api.NovaLibAPI;
import org.dreamexposure.novalib.api.bukkit.file.CustomConfig;
import org.dreamexposure.rpghandler.utils.FileManager;
import org.dreamexposure.rpghandler.utils.MessageManager;

public class RPGHandler extends JavaPlugin {
    public static Plugin plugin;
    private static RPGHandler pl;
    
    public CustomConfig config = new CustomConfig(this, "", "config.yml");
    public CustomConfig messages = new CustomConfig(this, "", "messages.yml");
    
    @Override
    public void onEnable() {
        plugin = this;
        pl = this;
    
        getLogger().info("===== RPG Handler =====");
        getLogger().info("Developed by DreamExposure");
        getLogger().info("Status: Enabling");
    
        NovaLibAPI.getApi().hookBukkitPlugin(this);
    
        //Handle file stuffs
        config.update(FileManager.getSettings());
        messages.update(MessageManager.getMessages());
    
        getLogger().info("Registering commands...");
    
        getLogger().info("Registering event listeners...");
    
        //Spawn holograms
    
        getLogger().info("========================");
        
    }
    
    @Override
    public void onDisable() {
        getLogger().info("===== RPG Handler =====");
        getLogger().info("Developed by DreamExposure");
        getLogger().info("Status: Disabling");
    
        //Remove holograms
    
        getLogger().info("========================");
    }
    
    public static RPGHandler get() {
        return pl;
    }
}