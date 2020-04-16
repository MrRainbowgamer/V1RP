package de.rainbow.chunk.listner;

import de.rainbow.chunk.api.City;
import de.rainbow.chunk.api.CityRang;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import de.rainbow.shops.Shop_ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.Button;
import org.bukkit.material.Door;
import org.bukkit.material.Lever;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerListener implements Listener {



    @EventHandler
    public void on(PlayerMoveEvent e) {
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        if (cp == null) {
            System.out.println("Dafuq: " + e.getPlayer().getName());
            e.getPlayer().kickPlayer("§cEin unerwarterter Fehler ist aufgetreten");
            return;
        }
        City c = Roleplay.getCityAtChunk(e.getTo().getChunk());
        if (c == cp.getLocation()) {
            return;
        }
        if (c != null) {
            if (c == Roleplay.SPAWN) {
                cp.setLocation(c);
                if (cp.isMessages())
                    e.getPlayer().sendTitle("§f" + c.getName(), "§e" + c.getMessage(), 10, 30, 10);
                return;
            }
            if (c == cp.getCity()) {
                cp.setLocation(c);
                if (cp.isMessages())
                    e.getPlayer().sendTitle("§f" + c.getName(), "§e" + c.getMessage(), 10, 30, 10);
                return;
            }
            cp.setLocation(c);
            // if(cp.isDebug() == false && c.getBanned().contains(cp)) {
            // double xdiff = e.getTo().getChunk().getX() -
            // e.getFrom().getChunk().getX() ;
            // double zdiff = e.getTo().getChunk().getZ() -
            // e.getFrom().getChunk().getZ();
            // if(xdiff < 0) {
            // e.getPlayer().setVelocity(new Vector(1, 0.5,
            // e.getPlayer().getVelocity().getZ()));
            // } else if(xdiff > 0){
            // e.getPlayer().setVelocity(new Vector(-1, 0.5,
            // e.getPlayer().getVelocity().getZ()));
            // } else if(zdiff < 0) {
            // e.getPlayer().setVelocity(new
            // Vector(e.getPlayer().getVelocity().getX(), 0.5,
            // 1));
            // } else if(zdiff > 0){
            // e.getPlayer().setVelocity(new
            // Vector(e.getPlayer().getVelocity().getX(), 0.5,
            // -1));
            // }
            // e.getPlayer().sendTitle("", "§cDu bist aus §6" + c.getName() +
            // "§c gebannt!",
            // 10, 30, 10);
            // return;
            // }
            if (cp.getCity() != null && cp.getCity().getEnemies() != null && cp.getCity().getEnemies().containsKey(c)) {
                if (cp.isMessages())
                    e.getPlayer().sendTitle("§c" + c.getName(),  c.getMessage(), 10, 30,
                            10);
                return;
            }
            if (cp.isMessages())
                e.getPlayer().sendTitle("§f" + c.getName(),  c.getMessage(), 10, 30, 10);
            return;
        }
        if (cp.getLocation() == Roleplay.SPAWN) {
            if (cp.isMessages())
                e.getPlayer().sendTitle("§aWildnis", "§eHütet euch Reisender", 10, 30, 10);
            cp.setLocation(null);
            return;
        }
        if (cp.getLocation() == cp.getCity()) {
            if (cp.isMessages())
                e.getPlayer().sendTitle("§aWildnis", "§eHütet euch Reisender", 10, 30, 10);
            cp.setLocation(null);
            return;
        }
        if (cp.getCity() != null && cp.getCity().getEnemies().containsKey(c)) {
            if (cp.isMessages())
                e.getPlayer().sendTitle("§aWildnis", "§eHütet euch Reisender", 10, 30, 10);
            cp.setLocation(null);
            return;
        }
        if (cp.isMessages())
            e.getPlayer().sendTitle("§aWildnis", "§eHütet euch Reisender", 10, 30, 10);
        cp.setLocation(null);
    }

    @EventHandler
    public void on(PlayerInteractEvent e) {
        if (e.getAction() != Action.LEFT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        if (cp.isDebug())
            return;
        City c = Roleplay.getCityAtChunk(e.getClickedBlock().getChunk());
        if (c == null || cp.getCity() == c
                || cp.getCity() != null && cp.getCity().getEnemies().containsKey(c)
                && (e.getClickedBlock() instanceof Chest || e.getClickedBlock() instanceof Door
                || e.getClickedBlock() instanceof Button || e.getClickedBlock() instanceof Lever
                || e.getClickedBlock().getType() == Material.TNT))
            return;
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void on(PlayerInteractEntityEvent e) {
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        if (cp.isDebug())
            return;
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            Villager v = (Villager) e.getRightClicked();
            City c = Roleplay.getCityAtChunk(e.getRightClicked().getLocation().getChunk());
            if (c == null || cp.getCity() == c)
                return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
        SkyPlayer cp = Roleplay.getPlayer(e.getPlayer().getUniqueId());
        if (cp == null) {
            File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            cfg.set("players." + e.getPlayer().getUniqueId() + ".name", e.getPlayer().getName());
            cfg.set("players." + e.getPlayer().getUniqueId() + ".gold", 200);
            cfg.set("players." + e.getPlayer().getUniqueId() + ".allowsToBuild", false);
            try {
                cfg.save(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            cp = new SkyPlayer(cfg, e.getPlayer().getUniqueId().toString());
            Roleplay.getPlayers().add(cp);
        }

       if (cp.getCity() == Roleplay.SPAWN) {
            cp.setDebug(true);
        }

        cp.setPlayer(e.getPlayer());
        Roleplay.getOnlinePlayers().add(cp);
        if (cp.getName().equals(e.getPlayer().getName()))
            return;
/*      }
        cp.setName(e.getPlayer().getName());
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".name", e.getPlayer().getName());
        cfg.set("players." + e.getPlayer().getUniqueId() + ".gold", 200);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".blutsplitter", 0);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".beruf", "Arbeitslos");
        cfg.set("players." + e.getPlayer().getUniqueId() + ".beruflvl", 0);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".water", 20);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".blood", 6);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".muskel", 0);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".fett", 0);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".frak1", false);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".frak2", false);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".frak3", false);
        cfg.set("players." + e.getPlayer().getUniqueId() + ".allowsToBuild", false);

        try {
            cfg.save(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

    }

    @EventHandler
    public void on(PlayerQuitEvent e) {
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        cp.setDebug(false);
        cp.setPlayer(null);
        Roleplay.getOnlinePlayers().remove(cp);
    }

    @EventHandler
    public void on(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player == false)
            return;
        SkyPlayer cp = Roleplay.getPlayer(e.getEntity().getUniqueId());
        if (cp.getLocation() == Roleplay.SPAWN)
            e.setCancelled(false);
    }

    /*
    @EventHandler
    public void on(CreatureSpawnEvent e) {
        City c = Roleplay.getCityAtChunk(e.getLocation().getChunk());
        try {
            if(e.getEntity().getWorld().equals(Bukkit.getWorld("world"))) {
                if(e.getEntity() instanceof Villager) {
                    Villager v = (Villager) e.getEntity();
                    if(v.getCustomName().equalsIgnoreCase("§7Müller")) {
                        e.setCancelled(false);
                    } else if(v.getCustomName().equalsIgnoreCase("§7Holzfäller")) {
                        e.setCancelled(false);
                    }
                } else  if (e.getEntity() instanceof Zombie || e.getEntity() instanceof ZombieVillager) {
                    e.setCancelled(false);
                }
            }

        } catch (NullPointerException ex) {

        }


    }*/

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        SkyPlayer cp = Roleplay.getPlayer(e.getPlayer().getUniqueId());
        Player p = e.getPlayer();
        if(cp.isGodduty() != true) {
                City c = Roleplay.getCityAtChunk(e.getBlock().getChunk());
                if(c != null) {
                    if (cp.getCity() == c) {
                        e.setCancelled(false);

                    } else  {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(false);
                }

        }

    }

    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        SkyPlayer cp = Roleplay.getPlayer(e.getPlayer().getUniqueId());
        Player p = e.getPlayer();
        if(cp.isGodduty() != true) {
                City c = Roleplay.getCityAtChunk(e.getBlock().getChunk());
                if(c != null) {
                    if (cp.getCity() == c) {
                        e.setCancelled(false);

                    } else  {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(false);
                }


        }
    }

    @EventHandler
        public void on(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Animals == false && e.getEntity() instanceof Player == false
                && e.getEntity() instanceof ItemFrame == false)
            return;
        Player p;
        if (e.getDamager() instanceof Projectile) {
            try {
                p = (Player) ((Projectile) e.getDamager()).getShooter();
            } catch (ClassCastException ex) {
                return;
            }
        } else {
            if (e.getDamager() instanceof Player == false)
                return;
            p = (Player) e.getDamager();
        }

        SkyPlayer cp = Roleplay.getOnlinePlayer(p.getUniqueId());
        if (cp.isDebug())
            return;
        City c2 = Roleplay.getCityAtChunk(e.getEntity().getLocation().getChunk());
        if (e.getEntity() instanceof Player == false) {
            if (c2 == null || cp.getCity() == c2)
                return;
            e.setCancelled(true);
            p.sendTitle("", "§cDu darfst hier Entities nicht angreifen!", 10, 30, 10);
            return;
        }

        SkyPlayer ct = Roleplay.getOnlinePlayer(e.getEntity().getUniqueId());
        if (ct.isDebug()) {
            e.setCancelled(true);
        }
        if (ct.hasCity() && cp.hasCity()) {
            if (ct.getCity() == cp.getCity()) {
                e.setCancelled(true);
                p.sendTitle("", "§cDu kannst Mitglieder deiner Stadt nicht angreifen!", 10, 30, 10);
                return;
            }
            if (cp.getCity().getAllies().contains(ct.getCity())) {
                e.setCancelled(true);
                p.sendTitle("", "§cDu kannst Mitglieder eurer Allianz nicht angreifen!", 10, 30, 10);
                return;
            }
            if (ct.getCity().getEnemies().containsKey(cp.getCity()))
                return;
            e.setCancelled(true);
            p.sendTitle("", "§cDu darfst hier nicht kämpfen!", 10, 30, 10);
        }
    }

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        if (cp.hasCity() && cp.getCity().hasHome()) {
            e.setRespawnLocation(cp.getCity().getHome());
        } else {
            //e.setRespawnLocation(Roleplay.SPAWN.getHome());
        }
    }

    @EventHandler
    public void on(EntityExplodeEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
            e.setCancelled(true);
            e.getEntity().getWorld().createExplosion(e.getEntity().getLocation().getX(), e.getEntity().getLocation().getY(),
                    e.getEntity().getLocation().getZ(), e.getYield(), false, false);
        } else {
            e.setCancelled(false);
        }

    }

}
