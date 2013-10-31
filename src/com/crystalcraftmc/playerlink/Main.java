package com.crystalcraftmc.playerlink;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
	// When the plugin first starts...
	@Override
    public void onEnable()
	{
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("PlayerLink has been enabled!");
		
		// ...link plugin with online stats.
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e){
			// Failed to submit the stats :-(
		}
		
		// ...generate the config.yml file.
		this.saveDefaultConfig();
		
		// ...load the configuration file and copy the defaults into the plugin...
		this.getConfig().options().copyDefaults(true);
		
		// ...and save the configuration file.
        this.saveConfig();
        
        // ...see if the config file allows auto-updating...
        if (this.getConfig().getBoolean("auto-update"))
        {
        	// ...and if so, run the auto-update class.
        	@SuppressWarnings("unused")
			Updater updater = new Updater(this, "playerlink", this.getFile(), Updater.UpdateType.DEFAULT, true);
        }
        
		getCommand("website").setExecutor(new Website(this));
		
		getCommand("vote").setExecutor(new Vote(this));
		
		getCommand("forums").setExecutor(new Forums(this));
		
		getCommand("shop").setExecutor(new Shop(this));
		
		getCommand("voice").setExecutor(new Voice(this));
		
		getCommand("dynmap").setExecutor(new DynMap(this));
		
		getCommand("wiki").setExecutor(new Wiki(this));
		
		getCommand("Facebook").setExecutor(new Facebook(this));
		
		getCommand("Twitter").setExecutor(new Twitter(this));
		
		getCommand("YouTube").setExecutor(new YouTube(this));
		
		getCommand("Google+").setExecutor(new GooglePlus(this));
		
		getCommand("Instagram").setExecutor(new Instagram(this));
		
		getCommand("link").setExecutor(new Link(this));
		
		getCommand("playerlink").setExecutor(new PlayerLinkCmd(this));
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("PlayerLink has been disabled!");
    }
}