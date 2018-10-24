package org.dreamexposure.rpghandler.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.dreamexposure.novalib.api.bukkit.command.CommandInfo;
import org.dreamexposure.novalib.api.bukkit.command.ICommand;
import org.dreamexposure.rpghandler.handler.FollowerHandler;
import org.dreamexposure.rpghandler.utils.MessageManager;

import java.util.ArrayList;

/**
 * @author NovaFox161
 * Date Created: 10/24/2018
 * For Project: RPG-Handler
 * Author Website: https://www.novamaday.com
 * Company Website: https://www.dreamexposure.org
 * Contact: nova@dreamexposure.org
 */
public class FollowCommand implements ICommand {
    @Override
    public String getCommand() {
        return "follow";
    }
    
    @Override
    public ArrayList<String> getAliases() {
        return new ArrayList<>();
    }
    
    @Override
    public CommandInfo getCommandInfo() {
        CommandInfo info = new CommandInfo("follow");
        info.setDescription("Follows the specified God.");
        info.setExample("/follow DudeBro");
        return info;
    }
    
    @Override
    public boolean issueCommand(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("rpg.command.follow")) {
                if (!FollowerHandler.isFollowingGod(player)) {
                    if (args.length == 1) {
                        String godName = args[0].toLowerCase();
                        if (FollowerHandler.godExists(godName)) {
                            FollowerHandler.follow(player, godName);
                            return true;
                        } else {
                            player.sendMessage("That god does not exist! Did you make a typo?");
                        }
                    } else {
                        player.sendMessage("You must specify the God to follow!");
                    }
                } else {
                    player.sendMessage(ChatColor.YELLOW + "You are already following a God!");
                }
            } else {
                player.sendMessage(MessageManager.getMessage("NoPerm"));
            }
        } else {
            commandSender.sendMessage("You must be a player to use this command!");
        }
        return false;
    }
}
