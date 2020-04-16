package de.rainbow.manager;

import de.rainbow.commands.CMD_admin;
import de.rainbow.main.Roleplay;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sun.java2d.Surface;

public class Event_JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Roleplay.crange.put(p, 2);
        SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());
        sp.setPlayer(p);
        Roleplay.getOnlinePlayers().add(sp);
        e.setJoinMessage("§7" + p.getName() + " ist aufgewacht!");
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(CMD_admin.v.containsKey(all)) {
                p.hidePlayer(all);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(CMD_admin.v.containsKey(p)) {
            e.setQuitMessage("");
            CMD_admin.v.remove(p);
        } else {
            e.setQuitMessage("§7" + p.getName() + " hat sich hingelegt!");
        }
    }
}
