package me.hammy.xtracommands.xtracmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftWolf;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.java.JavaPlugin;

public class xtracmds extends JavaPlugin {
	
	@Override
    public void onEnable() {
		getLogger().info("onEnable has been invoked!");
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }
    
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fun")) { 
			sender.sendMessage(ChatColor.RED + "Hello! " + ChatColor.GREEN + "This is a fun command!");
    		return true;
    	} 
		if (cmd.getName().equalsIgnoreCase("tpalldogs")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Wolf.class)) {
				  if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName())) {
				    if(e instanceof Wolf) {
				    	Player player = (Player) sender;
				    	Location bl = player.getLocation();
				    	e.teleport(bl);
				    }
				    
				  }
				}
			
    	}
					
		    		return true;
		    	}
		if (cmd.getName().equalsIgnoreCase("tpnamedog")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Wolf.class)) {
				    String name = e.getName();
				    if(args.length > 0)
				    {
				    	if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName()) && name.equalsIgnoreCase(args[0])) {
				    		if(e instanceof Wolf) {
				    			Player player = (Player) sender;
				    			Location bl = player.getLocation();
				    			e.teleport(bl);
				    		}
				     
				    }
				   } else {
				    	 sender.sendMessage(ChatColor.DARK_RED + "Usage: /tpnamedog [Dog Name]");
				   }
			}
			
    	   }
					
		    		return true;
		    	}
		if (cmd.getName().equalsIgnoreCase("tpnamehorse")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Horse.class)) {
				  String name = e.getName();
				  if(args.length > 0)
				  {
					  if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName()) && name.equalsIgnoreCase(args[0])) {
						  if(e instanceof Horse) {
							  Player player = (Player) sender;
							  Location bl = player.getLocation();
							  e.teleport(bl);
				    }
				    
				  }
			     } else {
			    	 sender.sendMessage(ChatColor.DARK_RED + "Usage: /tpnamehorse [Horse Name]");
			     }
				}
			
    	}
					
		    		return true;
		    	}
		if (cmd.getName().equalsIgnoreCase("tpallhorses")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Horse.class)) {
				  if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName())) {
				    if(e instanceof Horse) {
				    	Player player = (Player) sender;
				    	Location bl = player.getLocation();
				    	e.teleport(bl);
				    }
				    
				  }
				}
			
    	}
					
		    		return true;
		    	}
		if (cmd.getName().equalsIgnoreCase("dogattack")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Wolf.class)) {
				    if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName())) {
				      if(e instanceof Wolf) {
				    	if(args.length > 0)
				    	{
				    	  @SuppressWarnings("deprecation")
						Player p = Bukkit.getPlayer(args[0]);
				    	  if (p != null) {
				    		  ((CraftWolf) e).setTarget(p);
				    	  } else {
				    		  sender.sendMessage(ChatColor.DARK_RED + "Player is not online");
				    	  }
				    	  
				    	} else {
				    		sender.sendMessage(ChatColor.DARK_RED + "Usage: /dogattack [Player]");
				    	}
				     }
				     
				    }
				   }
			
    	   }
					
		    		return true;
		    	}
		if (cmd.getName().equalsIgnoreCase("stopattack")) { 
			for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntitiesByClasses(Wolf.class)) {
				    if(((Tameable)e).isTamed() && ((Tameable)e).getOwner().getName().equals(sender.getName())) {
				      if(e instanceof Wolf) {
				    	((CraftWolf) e).setTarget(null);
				     }
				     
				    }
				   }
			
    	   }
					
		    		return true;
		    	}
		//If this has happened the function will return true. 
            // If this hasn't happened the value of false will be returned. 
		
		
	return false;
 }
}

