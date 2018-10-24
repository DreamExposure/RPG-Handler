package org.dreamexposure.rpghandler;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.dreamexposure.novalib.api.NovaLibAPI;
import org.dreamexposure.novalib.api.bukkit.command.CommandCenter;
import org.dreamexposure.novalib.api.bukkit.file.CustomConfig;
import org.dreamexposure.rpghandler.command.FollowCommand;
import org.dreamexposure.rpghandler.command.UnfollowCommand;
import org.dreamexposure.rpghandler.utils.FileManager;
import org.dreamexposure.rpghandler.utils.MessageManager;

public class RPGHandler extends JavaPlugin {
    public static Plugin plugin;
    private static RPGHandler pl;
    
    private CommandCenter commandCenter = new CommandCenter(this);
    
    public CustomConfig config = new CustomConfig(this, "", "config.yml");
    public CustomConfig messages = new CustomConfig(this, "", "messages.yml");
    public CustomConfig followers = new CustomConfig(this, "", "followers.yml");
    
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
        followers.update(FileManager.getFollowers());
    
        getLogger().info("Registering commands...");
    
        getLogger().info("Registering event listeners...");
        commandCenter.registerCommand(new FollowCommand());
        commandCenter.registerCommand(new UnfollowCommand());
        commandCenter.enable();
    
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