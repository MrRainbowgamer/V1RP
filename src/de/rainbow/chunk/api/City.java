package de.rainbow.chunk.api;

import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class City {

    private final String name;
    private String alias;
    private String message;
    private final HashSet<SkyPlayer> members = new HashSet<>();
    private final HashSet<SkyPlayer> invites = new HashSet<>();
    private final HashSet<City> allies = new HashSet<>();
    private final HashSet<City> allyRequests = new HashSet<>();
    private final HashMap<City, Long> enemies = new HashMap<>();
    private final Inventory chest;
    private Location home;
    private int money;
    private int level;
    private int upgradep;

    public City(FileConfiguration cfg, String name) {
        this.name = cfg.getString("cities." + name + ".name");
        this.alias = cfg.getString("cities." + name + ".alias");
        if(cfg.isInt("cities." + name + ".home.x")) {
            this.home = new Location(Bukkit.getWorld(Roleplay.getWorld()), cfg.getInt("cities." + name + ".home.x"), cfg.getInt("cities." + name + ".home.y"), cfg.getInt("cities." + name + ".home.z"));
        }
        this.money = cfg.getInt("cities." + name + ".money");
        this.level = cfg.getInt("cities." + name + ".level");
        this.message = cfg.getString("cities." + name + ".message");
        this.upgradep = cfg.getInt("cities." + name + ".upgradepoints");
        chest = null;
//		cfg = YamlConfiguration.loadConfiguration(new File(Roleplay.getInstance().getDataFolder(), "chests.yml");
    }

    @Override
    public String toString() {
        return "§a" + name + " §7[§6#" + alias + "§7]";
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".alias", alias);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEnemy(City c, long l) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".enemies." + c.getConfigName(), l);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeEnemy(City c) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".enemies." + c.getConfigName(), null);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<SkyPlayer> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public Location getHome() {
        return home;
    }

    public void setHome(Location home) {
        this.home = home;
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if(home == null) {
            cfg.set("cities." + getConfigName() + ".home", null);
        } else {
            cfg.set("cities." + getConfigName() + ".home.x", home.getBlockX());
            cfg.set("cities." + getConfigName() + ".home.y", home.getBlockY());
            cfg.set("cities." + getConfigName() + ".home.z", home.getBlockZ());
        }
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasHome() {
        return home != null;
    }

    public int sendChunkAmmount() {
        int i = 0;
        for(SurvivalChunk sc : Roleplay.getChunks()) {
            if(sc.getCity() == this) i++;
        }

        return i;
    }

    public void sendInfo(CommandSender cs, boolean debug) {
        cs.sendMessage(Roleplay.PREFIX + "§a" + name + " §7[§6#" + alias + "§7]");
        int i = 0;
        for(SurvivalChunk c : Roleplay.getChunks()) {
            if(c.getCity() == this) i++;
        }
        if(debug) {
            cs.sendMessage(Roleplay.PREFIX + "§6Money: §7" + money + " Gold");
            cs.sendMessage(Roleplay.PREFIX + "§6Chunks: §7" + i);
            try {
                cs.sendMessage(Roleplay.PREFIX + "§6Home: §7x=" + home.getBlockX() + ", y=" + home.getBlockY() + ", z=" + home.getBlockZ());
            } catch(NullPointerException ex) {
                cs.sendMessage(Roleplay.PREFIX + "§6Home: §7Nicht gesetzt!");
            }
        }
        String major = "";
        StringBuilder staff = new StringBuilder();
        StringBuilder members = new StringBuilder();
        for(SkyPlayer cp : this.members) {
            if(cp.getCityrang() == CityRang.MAJOR) major = cp.getName();
            else if(cp.getCityrang() == CityRang.STAFF) {
                staff.append(cp.getName());
                staff.append(" ");
            } else {
                members.append(cp.getName());
                members.append(" ");
            }
        }
        cs.sendMessage(Roleplay.PREFIX + "§6Major: §7" + major);
        cs.sendMessage(Roleplay.PREFIX + "§6Staff: §7" + staff.toString());
        cs.sendMessage(Roleplay.PREFIX + "§6Member: §7" + members.toString());
    }

    public String getConfigName() {
        return name.toLowerCase();
    }

    public HashSet<SkyPlayer> getInvites() {
        return invites;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".money", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.money = money;
    }

    public boolean addMoney(int amount) {
        if(this.money + amount < 0) return false;
        this.money += amount;
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".money", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void broadcast(String string) {
        for(SkyPlayer ct : members) {
            if(ct.isOnline()) {
                ct.getPlayer().sendMessage(string);
            }
        }
    }

    public HashSet<City> getAllies() {
        return allies;
    }

    public HashSet<City> getAllyRequests() {
        return allyRequests;
    }

    public void addAlliance(City city) {
        allies.add(city);
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String[] ally = new String[allies.size()];
        int i = 0;
        for(City c : allies) {
            ally[i] = c.getName();
            i++;
        }
        cfg.set("cities." + getConfigName() + ".allies", ally);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeAlliance(City city) {
        allies.remove(city);
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String[] ally = new String[allies.size()];
        int i = 0;
        for(City c : allies) {
            ally[i] = c.getName();
            i++;
        }
        cfg.set("cities." + getConfigName() + ".allies", ally);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Inventory getChest() {
        return chest;
    }

    public HashMap<City, Long> getEnemies() {
        return enemies;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel(int amount) {
        this.level += amount;
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".level", level);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUpgradep() {
        return upgradep;
    }

    public void setUpgradep(int upgradep) {
        this.upgradep = upgradep;
    }

    public void addUpgradep(int amount) {
        this.upgradep += amount;
        File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("cities." + getConfigName() + ".upgradepoints", upgradep);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
