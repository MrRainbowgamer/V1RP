package de.rainbow.main;

import de.rainbow.chunk.api.City;
import de.rainbow.chunk.api.SurvivalChunk;
import de.rainbow.chunk.cmd.AllyChatCMD;
import de.rainbow.chunk.cmd.CityChatCMD;
import de.rainbow.chunk.cmd.CityCommand;
import de.rainbow.chunk.listner.PlayerListener;
import de.rainbow.commands.CMD_Spawnshop;
import de.rainbow.commands.CMD_changeChatRange;
import de.rainbow.commands.CMD_admin;
import de.rainbow.fraktionmanager.Adligen;
import de.rainbow.fraktionmanager.Aufgeklärte;
import de.rainbow.fraktionmanager.CMD_acceptinvite;
import de.rainbow.fraktionmanager.Templer;
import de.rainbow.manager.*;
import de.rainbow.shops.Event_AktivateVillager;
import de.rainbow.shops.Shop_Schmied;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import javax.management.relation.Role;
import java.io.File;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.nio.BufferUnderflowException;
import java.sql.BatchUpdateException;
import java.util.*;

public class Roleplay extends JavaPlugin {

    public static HashMap<Player, Integer> crange = new HashMap<>();
    public static HashMap<Player, String> invites = new HashMap<>();
    private static Roleplay instance;
    public static String prefix = "§4•§c● Server §8➜ §7";
    public static final String PREFIX = "§6•§e● Stadt §8●§7 ";

    private final HashSet<SurvivalChunk> chunks = new HashSet<>();
    private final ArrayList<City> cities = new ArrayList<>();
    public final HashSet<SkyPlayer> players = new HashSet<>();
    private final HashSet<SkyPlayer> onlinePlayers = new HashSet<>();

    public static City SPAWN;

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new Event_onCraft(), this);
        Bukkit.getPluginManager().registerEvents(new Event_onChat(), this);
        Bukkit.getPluginManager().registerEvents(new Event_JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new CMD_Spawnshop(), this);
        Event_AktivateVillager.activate(this);

        this.getCommand("chr").setExecutor(new CMD_changeChatRange());
        this.getCommand("spawnshop").setExecutor(new CMD_Spawnshop());
        this.getCommand("admin").setExecutor(new CMD_admin());
        this.getCommand("adel").setExecutor(new Adligen());
        this.getCommand("templer").setExecutor(new Templer());
        this.getCommand("aufgeklärte").setExecutor(new Aufgeklärte());
        this.getCommand("acceptinvite").setExecutor(new CMD_acceptinvite());
        this.getCommand("stadt").setExecutor(new CityCommand());
        this.getCommand("citychat").setExecutor(new CityChatCMD());
        this.getCommand("allychat").setExecutor(new AllyChatCMD());

        instance = this;

        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                for (City c : cities) {
                    for (Map.Entry<City, Long> entry : c.getEnemies().entrySet()) {
                        if (entry.getValue() != -1 && entry.getValue() < System.currentTimeMillis()) {
                            c.removeEnemy(entry.getKey());
                            entry.getKey().removeEnemy(c);
                            entry.getKey().broadcast("§aDer Frieden mit " + c.getName() + " ist beschlossen!");
                            c.broadcast("§aDer Frieden mit " + entry.getKey().getName() + " ist beschlossen!");
                        }
                    }
                }
            }
        }, 0L, 60L);


        for(Player all : Bukkit.getOnlinePlayers()) {
            crange.put(all, 2);
        }

        File file = new File(getDataFolder(), "cities.yml");
        if (file.exists() == false) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        try {
            for (String key : cfg.getConfigurationSection("cities").getKeys(false)) {
                cities.add(new City(cfg, key));
            }
        } catch (NullPointerException e) {
        }
        file = new File(getDataFolder(), "players.yml");
        if (file.exists() == false) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfg = YamlConfiguration.loadConfiguration(file);
        try {
            for (String key : cfg.getConfigurationSection("players").getKeys(false)) {
                players.add(new SkyPlayer(cfg, key));
            }
        } catch (NullPointerException e) {
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            SkyPlayer sp = getPlayer(p.getUniqueId());
            if (sp == null) {
                cfg.set("players." + p.getUniqueId() + ".name", p.getName());
                sp = new SkyPlayer(cfg, p.getUniqueId().toString());
                players.add(sp);
            }
            sp.setPlayer(p);
            Roleplay.getOnlinePlayers().add(sp);
        }
        try {
            cfg.save(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        file = new File(getDataFolder(), "cities.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        try {
            for (City c : cities) {
                for (String s : cfg.getStringList("cities." + c.getConfigName() + ".allies")) {
                    c.getAllies().add(Roleplay.getCity(s));
                }
                for (String s : cfg.getConfigurationSection("cities." + c.getConfigName() + ".enemies")
                        .getKeys(false)) {
                    c.getEnemies().put(Roleplay.getCity(s),
                            cfg.getLong("cities." + c.getConfigName() + ".enemies." + s));
                }
            }
        } catch (NullPointerException e) {
        }
        SPAWN = getCity("Spawn");
        file = new File(getDataFolder(), "chunks.yml");
        if (file.exists() == false) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        cfg = YamlConfiguration.loadConfiguration(file);
        try {
            for (String key1 : cfg.getConfigurationSection("chunks").getKeys(false)) {
                try {
                    int x = Integer.parseInt(key1);
                    for (String key2 : cfg.getConfigurationSection("chunks." + x).getKeys(false)) {
                        try {
                            int z = Integer.parseInt(key2);
                            chunks.add(new SurvivalChunk(x, z, getCity(cfg.getString("chunks." + x + "." + z))));
                        } catch (NumberFormatException ex) {
                            System.err.println("SurvivalChunk wrong formated x=" + key1 + ", z=" + key2);
                        }
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("SurvivalChunk wrong formated x=" + key1);
                }
            }
        } catch (NullPointerException e) {
        }

    }



    public static HashSet<SurvivalChunk> getChunks() {
        return getInstance().chunks;
    }

    public static City getCityAtChunk(World w, int x, int z) {
        return getCityAtChunk(w, new SurvivalChunk(x, z));
    }

    public static City getCityAtChunk(World w, SurvivalChunk survivalChunk) {
        if (!w.getName().equals(getWorld()))
            return null;

        for(SurvivalChunk c : getInstance().chunks) {
            if(c.equals(survivalChunk)) return c.getCity();
        }
        return null;
    }

    public static City getCityAtChunk(Chunk c) {
        return getCityAtChunk(c.getWorld(), c.getX(), c.getZ());
    }

    public static Roleplay getInstance() {
        return JavaPlugin.getPlugin(Roleplay.class);
    }

    public static ArrayList<City> getCities() {
        return getInstance().cities;
    }

    public static HashSet<SkyPlayer> getPlayers() {
        return getInstance().players;
    }

    public static SkyPlayer getPlayer(UUID uuid) {
        for (SkyPlayer p : getPlayers()) {
            if (p.getUniqueId().equals(uuid))
                return p;
        }
        return null;
    }

    public static SkyPlayer getPlayer(String name) {
        for (SkyPlayer p : getPlayers()) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public static City getCity(String string) {
        if (string == null)
            return null;
        if (string.startsWith("#")) {
            string = string.substring(1, string.length());
            for (City c : getCities()) {
                if (c.getAlias().equalsIgnoreCase(string))
                    return c;
            }
        } else {
            for (City c : getCities()) {
                if (c.getName().equalsIgnoreCase(string))
                    return c;
            }
        }
        return null;
    }

    public static String getWorld() {
        return "world";
    }

    public static HashSet<SkyPlayer> getOnlinePlayers() {
        return getInstance().onlinePlayers;
    }

    public static SkyPlayer getOnlinePlayer(UUID uuid) {
        for (SkyPlayer p : getOnlinePlayers()) {
            if (p.getUniqueId().equals(uuid))
                return p;
        }
        return null;
    }

    public static SkyPlayer getOnlinePlayer(String name) {
        for (SkyPlayer p : getOnlinePlayers()) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }



}
