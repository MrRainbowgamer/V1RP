package de.rainbow.chunk.cmd;

import de.rainbow.chunk.api.City;
import de.rainbow.chunk.api.CityRang;
import de.rainbow.chunk.api.SurvivalChunk;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class CityCommand implements CommandExecutor {

    public final static int CCOSTS = 500, MIN_MEMBERS = 1;
    public final static int COSTS = 5000,
            MAX_NAME = 16, MAX_ALIAS = 4, MIN_NAME = 5, MIN_ALIAS = 2;
    public final static String NAME = "^§!\"$%/()=?��{[]}\\`§*+~#<>|;,.:&";
    public final static String ALIAS = "^§\"/(){[]}\\`§*~<>|;,.:'#";

    public int ammount;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String lable, String[] args) {
        Player p = (Player) commandSender;
        SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());

        try {
            if (args[0].equalsIgnoreCase("info")) {
                if(sp.hasCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§6" + sp.getCity().getName() + " §7[§6#" + sp.getCity().getAlias() + "§7]");
                    p.sendMessage(Roleplay.PREFIX + " ");
                    p.sendMessage(Roleplay.PREFIX + "§6Ländereien: §7" + sp.getCity().sendChunkAmmount());

                    if(sp.getCity().getLevel() == 0) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Einsiedelei");
                    } else if(sp.getCity().getLevel() == 1) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Weiler");
                    } else if(sp.getCity().getLevel() == 2) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Dorf");
                    } else if(sp.getCity().getLevel() == 3) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Adelssitz");
                    } else if(sp.getCity().getLevel() == 4) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Ordenssitz");
                    } else if(sp.getCity().getLevel() == 5) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Stadt");
                    } else if(sp.getCity().getLevel() == 6) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Metropole");
                    } else if(sp.getCity().getLevel() == 7) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Auflassung");
                    } else if(sp.getCity().getLevel() == 8) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Wildlager");
                    } else if(sp.getCity().getLevel() == 9) {
                        p.sendMessage(Roleplay.PREFIX + "§6Stadtlevel: §7Königssitz");
                    }

                    p.sendMessage(Roleplay.PREFIX + "§6Upgradepunkte: §7" + sp.getCity().getUpgradep());



                    String major = "";
                    StringBuilder staff = new StringBuilder();
                    StringBuilder members = new StringBuilder();
                    for (SkyPlayer ccp : sp.getCity().getMembers()) {
                        if (ccp.getCityrang() == CityRang.MAJOR) major = ccp.getName();
                        else if (ccp.getCityrang() == CityRang.STAFF) {
                            staff.append(ccp.getName());
                            staff.append(" ");
                        } else if (ccp.getCityrang() == CityRang.MEMBER) {
                            members.append(ccp.getName());
                            members.append(" ");
                        }
                    }
                    p.sendMessage(Roleplay.PREFIX + "§6Bürgermeister: §7" + major);
                    p.sendMessage(Roleplay.PREFIX + "§6Helfer: §7" + staff.toString());
                    p.sendMessage(Roleplay.PREFIX + "§6Bürger: §7" + members.toString());
                } else {
                    p.sendMessage(Roleplay.PREFIX + "§c Du bist in keiner Stadt!");
                }

            } else if (args[0].equalsIgnoreCase("claim")) {


                //                      CLAIM

                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (p.getWorld().getName().equalsIgnoreCase(Roleplay.getWorld()) == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst nur in der normalen Welt claimen!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                if (sp.getCity().getMembers().size() < MIN_MEMBERS) {
                    p.sendMessage(Roleplay.PREFIX + "§cDeine Stadt braucht mindestens §6" + MIN_MEMBERS
                            + " Mitglieder §cum den Chunk zu claimen!");
                    return true;
                }
                /*
                if(sp.getCity().sendChunkAmmount() > sp.getCity().getMembers().size() * sp.getCity().getMembers().size()) {
                    p.sendMessage(Roleplay.PREFIX + "Deine Stadt wurde schon maximal ausgebaut!");
                    return true;
                }*/


                Chunk chunk = p.getLocation().getChunk();
                SurvivalChunk c = new SurvivalChunk(chunk.getX(), chunk.getZ(), sp.getCity());
                int i = 0;
                boolean neighbour = false;
                for (SurvivalChunk s : Roleplay.getChunks()) {
                    if (s.getCity() == sp.getCity()) {
                        if (s.getX() == c.getX() && s.getZ() + 1 == c.getZ())
                            neighbour = true;
                        if (s.getX() == c.getX() && s.getZ() - 1 == c.getZ())
                            neighbour = true;
                        if (s.getX() + 1 == c.getX() && s.getZ() == c.getZ())
                            neighbour = true;
                        if (s.getX() - 1 == c.getX() && s.getZ() == c.getZ())
                            neighbour = true;
                        i++;
                    }
                    if (s.equals(c)) {
                        p.sendMessage(Roleplay.PREFIX + "§cDieser Chunk ist bereits geclaimed!");
                        return true;
                    }
                }
                int ccosts = CCOSTS + i * 50;
                ccosts = /* 10*/ 0;
                if (neighbour == false && i != 0) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu musst einen angrenzenden Chunk claimen!");
                    return true;
                }
                if (i == 0) {
                    for (SurvivalChunk s : Roleplay.getChunks()) {
                        for (int x = -1; x <= 1; x++) {
                            for (int z = -1; z <= 1; z++) {
                                if (s.getCity() != null && s.getX() == c.getX() + x && s.getZ() + 1 == c.getZ() + z) {
                                    p.sendMessage(Roleplay.PREFIX + "§cDu befindest dich zu nah an einer anderen Stadt!");
                                    return true;
                                }
                            }
                        }
                    }
                }

                ItemStack gold2 = new ItemStack(Material.GOLD_NUGGET, 10);
                ItemMeta img2 = gold2.getItemMeta();
                img2.setDisplayName("§6Goldtaler");
                gold2.setItemMeta(img2);
                if(!p.getInventory().containsAtLeast(gold2, 1)) {
                    p.sendMessage(Roleplay.PREFIX + "§cDeine Stadt benötigt §6" + ccosts + " Goldtaler §cum den Chunk zu claimen!");
                    return true;
                }
                Roleplay.getChunks().add(c);
                sp.getCity().broadcast(Roleplay.PREFIX + "§aDeine Stadt wurde um einen Chunk erweitert!");
                File file = new File(Roleplay.getInstance().getDataFolder(), "chunks.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("chunks." + c.getX() + "." + c.getZ(), c.getCity().getName());
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.getInventory().removeItem(gold2);
                return true;
            } else if (args[0].equalsIgnoreCase("create")) {

                if (args.length != 3) {
                    p.sendMessage(Roleplay.PREFIX + "Du must /stadt create [Name] [Kürzel]");
                    return true;
                }
                //                         CREATE
                if (sp.hasCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist bereits in einer Stadt!");
                    return true;
                }
        /*if(gp.getMoney() < 5000) {
            p.sendMessage(Roleplay.PREFIX + "§cEine Stadt kostet §6" + COSTS + " Gold§c!");
            return true;
        }*/
                if (args[1].length() < MIN_NAME) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Name muss mindestens aus §6" + MIN_NAME + " Zeichen §cbestehen!");
                    return true;
                }
                if (args[1].length() > MAX_NAME) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Name darf maximal §6" + MAX_NAME + " Zeichen §clang sein!");
                    return true;
                }
                if (args[2].length() < MIN_ALIAS) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Alias muss mindestens aus §6" + MIN_ALIAS + " Zeichen §cbestehen!");
                    return true;
                }
                if (args[2].length() > MAX_ALIAS) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Alias darf maximal §6" + MAX_ALIAS + " Zeichen §clang sein!");
                    return true;
                }
                for (City c : Roleplay.getCities()) {
                    if (c.getName().equalsIgnoreCase(args[1])) {
                        p.sendMessage(Roleplay.PREFIX + "§cDer Name §6" + c.getName() + "§c ist bereits vergeben!");
                        return true;
                    }
                    if (c.getAlias().equalsIgnoreCase(args[2])) {
                        p.sendMessage(Roleplay.PREFIX + "§cDer Alias §6" + c.getAlias() + "§c ist bereits vergeben!");
                        return true;
                    }
                }

                File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                String name = args[1].toLowerCase();
                cfg.set("cities." + name + ".name", args[1]);
                cfg.set("cities." + name + ".alias", args[2]);
                cfg.set("cities." + name + ".name", args[1]);
                cfg.set("cities." + name + ".money", 0);
                cfg.set("cities." + name + ".level", 0);
                cfg.set("cities." + name + ".message", "Willkommen in der Einsiedelei " + args[1]);
                cfg.set("cities." + name + ".upgradepoints", 0);
                cfg.set("cities." + name + ".options.build", "MEMBER");
                cfg.set("cities." + name + ".options.pvp", "NOBODY");
                cfg.set("cities." + name + ".options.mobs", "MEMBER");
                cfg.set("cities." + name + ".options.items", "ALL");
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                City c = new City(cfg, name);
                Roleplay.getCities().add(c);
                c.getMembers().add(sp);
                sp.setCity(c);
                sp.setCityrang(CityRang.MAJOR);
                Bukkit.broadcastMessage(Roleplay.PREFIX + "§aDie Stadt §6" + args[1] + " §awurde von §6" + p.getName() + "§a gegründet!");
                return true;
            } else if (args[0].equalsIgnoreCase("invite")) {
                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt invite <Name>");
                    return true;
                }
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                SkyPlayer ct = Roleplay.getPlayer(args[1]);
                if (ct.hasCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist bereits in einer Stadt!");
                    return true;
                }
                if (sp.getCity().getInvites().add(ct) == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist bereits eingeladen!");
                    return true;
                }
                if (ct.isOnline()) {
                    ct.getPlayer().sendMessage(Roleplay.PREFIX + "§aDu bist in die Stadt §6" + sp.getCity().getName() + "§a eingeladen!");
                }
                sp.getCity().broadcast(Roleplay.PREFIX + " §6" + ct.getName() + "§a wurde in die Stadt eingeladen!");
                return true;


            } else if (args[0].equalsIgnoreCase("invites")) {


                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                StringBuilder sb = new StringBuilder("§6Invites: §7");
                HashSet<SkyPlayer> delete = new HashSet<>();
                for (SkyPlayer ct : sp.getCity().getInvites()) {
                    if (ct.hasCity()) {
                        delete.add(ct);
                        continue;
                    }
                    sb.append(ct.getName());
                    sb.append(" ");
                }
                sp.getCity().getInvites().removeAll(delete);
                p.sendMessage(Roleplay.PREFIX + sb.toString());
                return true;
            } else if (args[0].equalsIgnoreCase("join")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt Join <Stadt>");
                    return true;
                }

                if (sp.hasCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist bereits in einer Stadt!");
                    return true;
                }
                City c = Roleplay.getCity(args[1]);
                if (c == null || c == Roleplay.SPAWN) {
                    p.sendMessage(Roleplay.PREFIX + "§cDiese Stadt exisitert nicht!");
                    return true;
                }
                if (c.getInvites().remove(sp) == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist nicht berechtigt dieser Stadt beizutreten!");
                    return true;
                }
                c.broadcast(Roleplay.PREFIX + "§6" + sp.getName() + " §ahat die Stadt betreten!");
                c.getMembers().add(sp);
                sp.setCity(c);
                sp.setCityrang(CityRang.MEMBER);
                p.sendMessage(Roleplay.PREFIX + "§aDu bist der Stadt §6" + c.getName() + "§a beigetreten!");
                return true;

            } else if (args[0].equalsIgnoreCase("list")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt list <Seite>");
                    return true;
                }
                int page = 0;
                if (args.length == 1) {
                    try {
                        page = Integer.parseInt(args[1]) - 1;
                    } catch (NumberFormatException e) {
                        p.sendMessage(Roleplay.PREFIX + "§cDu musst eine Zahl als Seite angeben!");
                        return true;
                    }
                    if (page < 0) {
                        p.sendMessage(Roleplay.PREFIX + "§cDie Zahl muss größer als 0 sein!");
                        return true;
                    }
                }
                p.sendMessage(Roleplay.PREFIX + "§aListe aller Städte: [Seite " + (page + 1) + "]");
                for (int i = page * 5; i < (page + 1) * 5 && i < Roleplay.getCities().size(); i++) {
                    p.sendMessage(Roleplay.PREFIX + Roleplay.getCities().get(i));
                }
                return true;


            } else if (args[0].equalsIgnoreCase("sethome")) {

                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                if (sp.getCity() != Roleplay.getCityAtChunk(p.getLocation().getChunk())) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst das Home nur in eurer Stadt setzen!");
                    return true;
                }
                sp.getCity().setHome(p.getLocation());
                sp.getCity().broadcast(Roleplay.PREFIX + "§aDas Stadt-Home wurde gesetzt!");
                return true;
            } else if (args[0].equalsIgnoreCase("home")) {
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCity().hasHome() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cEuer Stadt-Home ist noch nicht gesetzt!");
                    return true;
                }
                    p.sendMessage(Roleplay.PREFIX + "§cDein Kompass auf deine Stadt fixiert!");
                    p.sendMessage(Roleplay.PREFIX + "Euer Stadt-Home: §6x=" + sp.getCity().getHome().getBlockX() + ", y=" + sp.getCity().getHome().getBlockY() + ", z=" + sp.getCity().getHome().getBlockZ());
                    p.setCompassTarget(sp.getCity().getHome());
                return true;


            } else if (args[0].equalsIgnoreCase("ally")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt ally <Stadt>");
                    return true;
                }
                //                  ALLY
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() != CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                City c = Roleplay.getCity(args[1]);
                if (c == null) {
                    p.sendMessage(Roleplay.PREFIX + "§cDiese Stadt exisitert nicht!");
                    return true;
                }
                if (c == sp.getCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst euch nicht mit euch selbst verbünden!");
                    return true;
                }
                if (sp.getCity().getAllyRequests().remove(c) == false) {
                    if (c.getAllyRequests().remove(sp.getCity())) {
                        p.sendMessage(Roleplay.PREFIX + "§cDu hast deine B§ndnis-Anfrage zurückgezogen!");
                        c.broadcast(Roleplay.PREFIX + "§6" + sp.getCity().getName() + "§c hat die Bündnis-Anfrage zurückgezogen!");
                        return true;
                    }
                    c.getAllyRequests().add(sp.getCity());
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast eine Bündnis-Anfrage gesendet!");
                    c.broadcast(Roleplay.PREFIX + "§6" + sp.getCity().getName() + "§a hat eine Bündnis-Anfrage gesendet!");
                    return true;
                }
                if (c.getAllies().contains(sp.getCity())) {
                    sp.getCity().broadcast(Roleplay.PREFIX + "§cDas Bündnis mit §6" + c.getName() + "§c ist beendet!");
                    c.broadcast(Roleplay.PREFIX + "§6" + sp.getCity().getName() + "§c hat das Bündnis beendet!");
                    c.removeAlliance(sp.getCity());
                    sp.getCity().removeAlliance(c);
                    return true;
                }
                sp.getCity().broadcast(Roleplay.PREFIX + "§aDas Bündnis mit §6" + c.getName() + "§a ist besiegelt!");
                c.broadcast(Roleplay.PREFIX + "§6" + sp.getCity().getName() + "§c hat das Bündnis besiegelt!");
                c.addAlliance(sp.getCity());
                sp.getCity().addAlliance(c);
                return true;

            } else if (args[0].equalsIgnoreCase("disband")) {
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() != CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst nur als Major die Stadt aufl§sen!");
                    return true;
                }
                Roleplay.getCities().remove(sp.getCity());

                File file = new File(Roleplay.getInstance().getDataFolder(), "cities.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("cities." + sp.getCity().getConfigName(), null);
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                file = new File(Roleplay.getInstance().getDataFolder(), "chunks.yml");
                cfg = YamlConfiguration.loadConfiguration(file);
                HashSet<SurvivalChunk> delete = new HashSet<>();
                for (SurvivalChunk c : Roleplay.getChunks()) {
                    if (sp.getCity() == c.getCity()) {
                        cfg.set("chunks." + c.getX() + "." + c.getZ(), null);
                        delete.add(c);
                        c.setCity(null);
                    }
                }
                Roleplay.getChunks().removeAll(delete);
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                file = new File(Roleplay.getInstance().getDataFolder(), "players.yml");
                cfg = YamlConfiguration.loadConfiguration(file);
                sp.getCity().broadcast(Roleplay.PREFIX + "§cDeine Stadt wurde aufgel§st!");
                for (SkyPlayer ct : sp.getCity().getMembers()) {
                    cfg.set("players." + ct.getUniqueId() + ".city", null);
                    cfg.set("players." + ct.getUniqueId() + ".cityrang", null);
                    sp.setCity(null);
                    sp.setCityrang(null);
                }
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;

            } else if (args[0].equalsIgnoreCase("kick")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt kick <Name>");
                    return true;
                }
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                SkyPlayer ct = Roleplay.getPlayer(args[1]);
                if (ct == null || ct.getCity() != sp.getCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist nicht Teil eurer Stadt!");
                    return true;
                }
                if (sp == ct) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst dich nicht selber kicken!");
                    return true;
                }
                if (sp.getCityrang() != CityRang.MAJOR && ct.getCityrang() != CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist nicht berechtigt diese Person zu kicken!");
                    return true;
                }
                ct.setCity(null);
                ct.setCityrang(null);
                sp.getCity().getMembers().remove(ct);
                if (ct.isOnline()) {
                    ct.getPlayer().sendMessage(Roleplay.PREFIX + "§cDu wurdest aus der Stadt geworfen!");
                }
                sp.getCity().broadcast(Roleplay.PREFIX + "§6" + ct.getName() + "§c wurde aus der Stadt geworfen!");
                return true;

            } else if (args[0].equalsIgnoreCase("leave")) {


                //                      LEAVE
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst als Major die Stadt nicht verlassen!");
                    return true;
                }
                sp.getCity().getMembers().remove(sp);
                sp.getCity().broadcast(Roleplay.PREFIX + "§6" + sp.getName() + " §chat die Stadt verlassen!");
                sp.setCity(null);
                p.sendMessage(Roleplay.PREFIX + "§aDu hast deine Stadt verlassen!");
                return true;
            } else if (args[0].equalsIgnoreCase("major")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt invite <Name>");
                    return true;
                }

                //                  MAJOR
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() != CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                SkyPlayer ct = Roleplay.getPlayer(args[1]);
                if (ct == null || ct.getCity() != sp.getCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist nicht Teil eurer Stadt!");
                    return true;
                }
                if (sp == ct) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst dich nicht selber zum Major erkl§ren!");
                    return true;
                }
                ct.setCityrang(CityRang.MAJOR);
                sp.setCityrang(CityRang.STAFF);
                ct.getCity().broadcast(Roleplay.PREFIX + "§6" + ct.getName() + " §awurde zum §6MAJOR §apromoted!");
                ct.getCity().broadcast(Roleplay.PREFIX + "§6" + sp.getName() + " §cwurde zum §6MAJOR §cdemoted!");
                return true;

            } else if (args[0].equalsIgnoreCase("staff")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt staff <Name>");
                    return true;
                }

                //                      STAFF
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() != CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                SkyPlayer ct = Roleplay.getPlayer(args[1]);
                if (ct == null || ct.getCity() != sp.getCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist nicht Teil eurer Stadt!");
                    return true;
                }
                if (sp == ct) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu kannst dich nicht selber zum Staff erkl§ren!");
                    return true;
                }
                if (ct.getCityrang() == CityRang.STAFF) {
                    ct.setCityrang(CityRang.MEMBER);
                    sp.getCity().broadcast(Roleplay.PREFIX + "§6" + ct.getName() + "§c wurde zum §6MEMBER §cdemoted!");
                    return true;
                }
                ct.setCityrang(CityRang.STAFF);
                sp.getCity().broadcast(Roleplay.PREFIX + "§6" + ct.getName() + "§a wurde zum §6STAFF §apromoted!");
                return true;

            } else if (args[0].equalsIgnoreCase("messages")) {


                //        MESSAGES
                if (sp.isMessages()) {
                    sp.setMessages(false);
                    p.sendMessage(Roleplay.PREFIX + "§cDu erh§lst nun keine Benachrichtigung für die Stadtgrenzen mehr!");
                    return true;
                }
                sp.setMessages(true);
                p.sendMessage(Roleplay.PREFIX + "§aDu erh§lst nun wieder Benachrichtigung für die Stadtgrenzen!");
                return true;
            } else if (args[0].equalsIgnoreCase("money")) {


                //              MONEY
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                p.sendMessage(Roleplay.PREFIX + "§aDeine Stadt besitzt §6" + sp.getCity().getMoney() + " Gold§a!");
                return true;

            } else if (args[0].equalsIgnoreCase("pay")) {

                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt pay <Betrag>");
                    return true;
                }

                //                    PAY
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }

                try {
                    ammount = Integer.parseInt(args[1]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    p.sendMessage(Roleplay.PREFIX + "§cBitte verwender /stadt pay <Amount>");
                }


                if (ammount <= 0) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Wert ist zu klein!");
                    return true;
                }

                if(sp.getGold() <= ammount) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu besitzt nicht genung Gold!");
                    return true;
                }


                sp.removeGold(ammount);

                sp.update();
                sp.getCity().addMoney(ammount);
                sp.getCity().broadcast(Roleplay.PREFIX + "§6" + sp.getName() + " §ahat §6" + ammount + " Gold §ader Stadt gespendet!");
                ammount = 0;
                return true;



            } else if (args[0].equalsIgnoreCase("unclaim")) {


                //                 UNCLAIM

                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                Chunk chunk = p.getLocation().getChunk();
                SurvivalChunk c = new SurvivalChunk(chunk.getX(), chunk.getZ());
                if (Roleplay.getCityAtChunk(p.getWorld(), c) != sp.getCity()) {
                    p.sendMessage(Roleplay.PREFIX + "§cDieser Chunk geh§rt eurer Stadt nicht!");
                    return true;
                }
                if(c.equals(sp.getCity().hasHome())) {
                    if (c.equals(sp.getCity().getHome().getChunk())) {
                        p.sendMessage(Roleplay.PREFIX + "§cDu kannst den Chunk mit eurem Home nicht unclaimen!");
                        return true;
                    }
                }

                SurvivalChunk sc = null;
                for (SurvivalChunk s : Roleplay.getChunks()) {
                    if (s.equals(c))
                        sc = s;
                }
                sp.getCity().addMoney(CCOSTS / 3);
                Roleplay.getChunks().remove(sc);
                File file = new File(Roleplay.getInstance().getDataFolder(), "chunks.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("chunks." + c.getX() + "." + c.getZ(), null);
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    p.sendMessage("§cBeim Speichern in die Datei ist ein Fehler aufgetreten!");
                }
                sp.getCity().broadcast(Roleplay.PREFIX + "§aEure Stadt wurde um einen Chunk verkleinert");
                return true;

            } else if (args[0].equalsIgnoreCase("uninvite")) {
                if (args.length != 2) {
                    p.sendMessage(Roleplay.PREFIX + "§7Bitte verwende /stadt uninvite <Name>");
                    return true;
                }

                //                 UNINVITE
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
                    return true;
                }
                if (sp.getCityrang() == CityRang.MEMBER) {
                    p.sendMessage(Roleplay.PREFIX + "§cDu hast keine Berechtigung für diesen Befehl!");
                    return true;
                }
                SkyPlayer ct = Roleplay.getPlayer(args[1]);
                if (sp.getCity().getInvites().remove(ct) == false) {
                    p.sendMessage(Roleplay.PREFIX + "§cDer Spieler ist nicht eingeladen!");
                    return true;
                }
                if (ct.isOnline()) {
                    ct.getPlayer().sendMessage(Roleplay.PREFIX + "§cDu wurdest aus der Stadt §6" + sp.getCity().getName() + "§c ausgeladen!");
                }
                sp.getCity().broadcast(Roleplay.PREFIX + "§6" + ct.getName() + "§c wurde aus der Stadt aufgeladen!");
                return true;

            } else if(args[0].equalsIgnoreCase("debug")) {
                if(p.hasPermission("city.debug")) {
                    if(sp.isDebug() == true) {
                        sp.setDebug(false);
                        p.sendMessage(Roleplay.PREFIX + "Du bist nun nicht mehr im Debug Modus!");
                    } else {
                        sp.setDebug(true);
                        p.sendMessage(Roleplay.PREFIX + "Du bist nun im Debug Modus!");
                    }
                }
            } else if (args.length == 0) {
                //                       INFO
                p.sendMessage(Roleplay.PREFIX + "§aHilfe für das Städte-System:");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt list [Seite] §8- §7Zeigt dir alle Städte an");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt info §8- §7Zeigt dir Informationen zu deinem Standort");
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt create <Name> <Alias> §8- §7Erstellt eine Stadt für 5.000 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt join <Stadt> §8- §7Tritt eingeladenen Städten bei");
                    return true;
                }
                p.sendMessage(Roleplay.PREFIX + "§6/stadt home §8- §7Teleportiert dich zu eurem Stadt-Home");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt money §8- §7Zeigt dir den Kontostand deiner Stadt an");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt pay <Betrag> §8- §7Spenden für deine Stadt");

                if (sp.getCityrang() == CityRang.MEMBER || sp.getCityrang() == CityRang.STAFF) {
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt leave §8- §7Verlässt deine Stadt");
                }
                if (sp.getCityrang() == CityRang.STAFF || sp.getCityrang() == CityRang.MAJOR) {

                    p.sendMessage(Roleplay.PREFIX + "§6/stadt invite <Spieler> §8- §7Lädt den Spieler in die Stadt ein");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt invites §8- §7Zeigt dir alle Einladungen an");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt claim §8- §7Kauft einen Chunk für 500 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt unclaim §8- §7Verkauft einen für 166 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt kick <Spieler> §8- §7Entfernt einen Spieler aus der Stadt");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt sethome §8- §7Setzt das Stadt-Home");

                    if (sp.getCityrang() == CityRang.MAJOR) {
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt disband §8- §7Löst deine Stadt auf");
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt staff <Spieler> §8- §7Gibt einem Spieler Staff Rechte");
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt major <Spieler> §8- §7übergibt einem Spieler die Stadt");
                    }
                }
            } else {
                //                       INFO
                p.sendMessage(Roleplay.PREFIX + "§aHilfe für das Städte-System:");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt list [Seite] §8- §7Zeigt dir alle Städte an");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt info §8- §7Zeigt dir Informationen zu deinem Standort");
                if (sp.hasCity() == false) {
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt create <Name> <Alias> §8- §7Erstellt eine Stadt für 5.000 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt join <Stadt> §8- §7Tritt eingeladenen Städten bei");
                    return true;
                }
                p.sendMessage(Roleplay.PREFIX + "§6/stadt home §8- §7Teleportiert dich zu eurem Stadt-Home");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt money §8- §7Zeigt dir den Kontostand deiner Stadt an");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt pay <Betrag> §8- §7Spenden für deine Stadt");

                if (sp.getCityrang() == CityRang.MEMBER || sp.getCityrang() == CityRang.STAFF) {
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt leave §8- §7Verlässt deine Stadt");
                }
                if (sp.getCityrang() == CityRang.STAFF || sp.getCityrang() == CityRang.MAJOR) {

                    p.sendMessage(Roleplay.PREFIX + "§6/stadt invite <Spieler> §8- §7Lädt den Spieler in die Stadt ein");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt invites §8- §7Zeigt dir alle Einladungen an");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt claim §8- §7Kauft einen Chunk für 500 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt unclaim §8- §7Verkauft einen für 166 Gold");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt kick <Spieler> §8- §7Entfernt einen Spieler aus der Stadt");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt sethome §8- §7Setzt das Stadt-Home");

                    if (sp.getCityrang() == CityRang.MAJOR) {
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt disband §8- §7Löst deine Stadt auf");
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt staff <Spieler> §8- §7Gibt einem Spieler Staff Rechte");
                        p.sendMessage(Roleplay.PREFIX + "§6/stadt major <Spieler> §8- §7Übergibt einem Spieler die Stadt");
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //                       INFO
            p.sendMessage(Roleplay.PREFIX + "§aHilfe für das Städte-System:");
            p.sendMessage(Roleplay.PREFIX + "§6/stadt list [Seite] §8- §7Zeigt dir alle Städte an");
            p.sendMessage(Roleplay.PREFIX + "§6/stadt info §8- §7Zeigt dir Informationen zu deinem Standort");
            if (sp.hasCity() == false) {
                p.sendMessage(Roleplay.PREFIX + "§6/stadt create <Name> <Alias> §8- §7Erstellt eine Stadt für 5.000 Gold");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt join <Stadt> §8- §7Tritt eingeladenen Städten bei");
                return true;
            }
            p.sendMessage(Roleplay.PREFIX + "§6/stadt home §8- §7Teleportiert dich zu eurem Stadt-Home");
            p.sendMessage(Roleplay.PREFIX + "§6/stadt money §8- §7Zeigt dir den Kontostand deiner Stadt an");
            p.sendMessage(Roleplay.PREFIX + "§6/stadt pay <Betrag> §8- §7Spenden für deine Stadt");

            if (sp.getCityrang() == CityRang.MEMBER || sp.getCityrang() == CityRang.STAFF) {
                p.sendMessage(Roleplay.PREFIX + "§6/stadt leave §8- §7Verlässt deine Stadt");
            }
            if (sp.getCityrang() == CityRang.STAFF || sp.getCityrang() == CityRang.MAJOR) {

                p.sendMessage(Roleplay.PREFIX + "§6/stadt invite <Spieler> §8- §7Lädt den Spieler in die Stadt ein");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt invites §8- §7Zeigt dir alle Einladungen an");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt claim §8- §7Kauft einen Chunk für 500 Gold");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt unclaim §8- §7Verkauft einen für 166 Gold");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt kick <Spieler> §8- §7Entfernt einen Spieler aus der Stadt");
                p.sendMessage(Roleplay.PREFIX + "§6/stadt sethome §8- §7Setzt das Stadt-Home");

                if (sp.getCityrang() == CityRang.MAJOR) {
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt disband §8- §7Löst deine Stadt auf");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt staff <Spieler> §8- §7Gibt einem Spieler Staff Rechte");
                    p.sendMessage(Roleplay.PREFIX + "§6/stadt major <Spieler> §8- §7Übergibt einem Spieler die Stadt");
                }
            }
        }




        return true;
    }

}

