package org.dreamexposure.rpghandler.command;

import org.bukkit.Bukkit;
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
public class UnfollowCommand implements ICommand {
    @Override
    public String getCommand() {
        return "unfollow";
    }
    
    @Override
    public ArrayList<String> getAliases() {
        return new ArrayList<>();
    }
    
    @Override
    public CommandInfo getCommandInfo() {
        CommandInfo info = new CommandInfo("unfollow");
        info.setDescription("Unfollows the specified God.");
        info.setExample("/unfollow DudeBro");
        return info;
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public boolean issueCommand(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("rpg.command.unfollow")) {
                if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    String godName = args[1].toLowerCase();
                    if (target != null) {
                        if (FollowerHandler.godExists(godName)) {
                            if (FollowerHandler.isFollowingGod(target)) {
                                FollowerHandler.unfollow(target, godName);
                                player.sendMessage("Success!");
                                return true;
                            } else {
                                player.sendMessage("The target player is not following a God!");
                            }
                        } else {
                            player.sendMessage("That God does not exist, did you make a typo?");
                        }
                    } else {
                        player.sendMessage("The player does not exist or is offline!");
                    }
                } else {
                    player.sendMessage("You must specify the player and god to unfollow (/unfollow <player> <god>)");
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
