package com.crystalcraftmc.playerlink;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Voice implements CommandExecutor
{
	Main plugin;
	public Voice(Main plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Make the letter 'p' a variable for the command sender (or the player).
		Player p = (Player) sender;
		
		// If the sender of the command has this permission...
		if(p.hasPermission("playerlink.voice"))
		{
			// ...and the player typed /voice...
	    	if (cmd.getName().equalsIgnoreCase("voice"))
	    	{
	    		// ...and the sender of the command is NOT a player...
	    		if (!(sender instanceof Player))
	    		{
	    			// ...do not let the command be run.
	    			sender.sendMessage("This command can only be run by a player.");
	    		}
	    		
	    		p.sendMessage(ChatColor.GOLD + "=-=-=-=-> " + ChatColor.YELLOW + plugin.getConfig().getString("server-name") + "'s Voice Server IP!" + ChatColor.GOLD + " <-=-=-=-=");
	    		p.sendMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "PL" + ChatColor.GOLD + "] " + ChatColor.AQUA + plugin.getConfig().getString("voice.url"));
	    		p.sendMessage(ChatColor.GOLD + "=-=-=-=-> " + ChatColor.YELLOW + plugin.getConfig().getString("server-name") + "'s Voice Server IP!" + ChatColor.GOLD + " <-=-=-=-=");
	    		if (plugin.getConfig().getBoolean("voice.enable-broadcast"))
	    		{
	    			Bukkit.broadcastMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.GREEN + " used " + ChatColor.ITALIC + "/voice " + ChatColor.RESET + ChatColor.GREEN + "to get the voice server IP for " + (plugin.getConfig().getString("server-name")));
	    		}
	    		
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	
	    	// Otherwise, if the sender of the command doesn't have the permission...
	    	else
			{
	    		// ...do not let the command be run.
    			p.sendMessage("You do not have permission to use that command.");
			}
    	}
    	// If this hasn't happened, a value of false will be returned.
    	return false;
	}
}