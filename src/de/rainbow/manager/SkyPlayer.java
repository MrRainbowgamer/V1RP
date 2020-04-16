package de.rainbow.manager;

import de.rainbow.chunk.api.City;
import de.rainbow.chunk.api.CityRang;
import de.rainbow.main.Roleplay;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class SkyPlayer {
    private Player player;
    private final UUID uuid;
    private String name;
    private City city;
    private CityRang cityRang;
    private boolean debug = false;
    private City location;
    private int teleportations;
    private boolean messages;
    private boolean godduty = false;

    private int gold;

    public SkyPlayer(FileConfiguration cfg, String s) {
        this.uuid = UUID.fromString(s);
        this.name = cfg.getString("players." + s + ".name");
        this.gold = cfg.getInt("players." + s + ".gold");


        this.setMessages(cfg.getBoolean("players." + s + ".messages", true));
        this.city = Roleplay.getCity(cfg.getString("players." + s + ".city"));
        if(city != null) {
            this.city.getMembers().add(this);
            try {
                this.cityRang = CityRang.valueOf(cfg.getString("players." + s + ".cityrang"));
            } catch(Exception e) {
                this.cityRang = CityRang.MEMBER;
            }
        }
    }

    public void update() {
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + uuid + ".name", name);
        cfg.set("players." + uuid + ".gold", gold);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + uuid + ".name", name);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City c) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + uuid + ".city", c == null ? null : c.getName());
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.city = c;
    }

    public CityRang getCityrang() {
        return cityRang;
    }
    public void setCityrang(CityRang cityrang) {
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + uuid + ".cityrang", cityrang == null ? null : cityrang.name());
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cityRang = cityrang;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public boolean hasCity() {
        return city != null;
    }

    public boolean isDebug() {
        return debug;
    }
    public void setDebug(boolean debug) {
        this.debug = debug;
        System.out.println("Debug: " + this.name + ": " + debug);
    }

    public City getLocation() {
        return location;
    }
    public void setLocation(City location) {
        this.location = location;
    }

    public int getTeleportations() {
        return teleportations;
    }
    public void setTeleportations(int teleportations) {
        this.teleportations = teleportations;
    }
    public void increaseTeleportations() {
        this.teleportations++;
    }

    public boolean isMessages() {
        return messages;
    }

    public void setMessages(boolean messages) {
        this.messages = messages;
        File file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("players." + uuid + ".messages", messages);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


    public boolean isOnline() {
        return player != null;
    }



    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void addGold(int gold) {
        this.gold = this.gold + gold;
    }
    public void removeGold(int gold) {
        this.gold = this.gold - gold;
    }


    public boolean isGodduty() {return godduty; }
    public void setGodduty(boolean godduty) {
        this.godduty = godduty;
    }
}
