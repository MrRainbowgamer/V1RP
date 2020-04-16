package de.rainbow.manager;

import de.rainbow.main.Roleplay;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class Event_onChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();


        String msgfinal = msg.replace("%", "%%");
        String msgfinal2 = msgfinal.replace("&", "§");

        if(Roleplay.crange.get(p) == 1) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                Location loc = p.getLocation();
                Location aloc = all.getLocation();
                e.setCancelled(true);
                if(aloc.distance(loc) < 1) {
                    all.sendMessage("§f" + p.getDisplayName() + " flüstert: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 3) {
                    all.sendMessage("§7" + p.getDisplayName() + " flüstert: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 5) {
                    all.sendMessage("§8" + p.getDisplayName() + " flüstert: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                }
            }
        } else if(Roleplay.crange.get(p) == 2) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                Location loc = p.getLocation();
                Location aloc = all.getLocation();
                e.setCancelled(true);
                if(aloc.distance(loc) < 7) {
                    all.sendMessage("§f" + p.getDisplayName() + " sagt: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 15) {
                    all.sendMessage("§7" + p.getDisplayName() + " sagt: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 25) {
                    all.sendMessage("§8" + p.getDisplayName() + " sagt: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                }
            }
        } else if(Roleplay.crange.get(p) == 3) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                Location loc = p.getLocation();
                Location aloc = all.getLocation();
                e.setCancelled(true);
                if(aloc.distance(loc) < 50) {
                    all.sendMessage("§f" + p.getDisplayName() + " schreit: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 100) {
                    all.sendMessage("§7" + p.getDisplayName() + " schreit: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                } else if(aloc.distance(loc) < 150) {
                    all.sendMessage("§8" + p.getDisplayName() + " schreit: " + msgfinal2);
                    Bukkit.getConsoleSender().sendMessage("§cCHAT: " + p.getDisplayName() + " >> " + msgfinal2);
                }
            }
        }
    }
}