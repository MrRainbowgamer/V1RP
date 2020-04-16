package de.rainbow.fraktionmanager;

import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Adligen implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        /*
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());
            if(p.hasPermission("frak.managemant.admin") || sp.getCity().equalsIgnoreCase("Adligen")) {
                if(args.length == 0) {
                    p.sendMessage("/adel setleader [name]");
                    p.sendMessage("/adel invite [name]");
                    p.sendMessage("/adel kick [name]");
                    p.sendMessage("/adel promote [name]");
                    p.sendMessage("/adel demote [name]");
                } else if(args.length == 2) {
                    if(args[0].equalsIgnoreCase("setleader")) {
                        if(sp.getCityRang() == 4 || p.hasPermission("frak.managemant.admin")) {
                            Player p2 = Bukkit.getServer().getPlayer(args[1]);
                            SkyPlayer sp2 = Roleplay.getPlayer(p2.getUniqueId());
                            if(p2 == p) {
                                sp2.setCityRang(4);
                                sp2.setCity("Adligen");
                            } else {
                                sp2.setCityRang(4);
                                sp.setCityRang(3);
                            }
                            sp.update();
                            sp2.update();
                            p.sendMessage(Roleplay.prefix + "Du hast erfolgreich " + p2.getName() + " zum Fraktions Leader erklärt");
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                SkyPlayer spa = Roleplay.getPlayer(p.getUniqueId());
                                if(spa.getCity().equalsIgnoreCase("Adligen")) {
                                    all.sendMessage(Roleplay.prefix + p2.getName()  +" wurde zum Fraktionsleader erklärt");
                                }
                            }
                        }
                    } else if(args[0].equalsIgnoreCase("invite")) {
                        if(sp.getCityRang() > 3 || p.hasPermission("frak.managemant.admin")) {
                            Player p2 = Bukkit.getServer().getPlayer(args[1]);
                            Roleplay.invites.put(p2, "Adligen");
                            p.sendMessage(Roleplay.prefix + "Du hast " + p2.getName() + " eine einladunge geschickt");
                            p2.sendMessage(Roleplay.prefix + "Du hat eine Einladung bekommen [/acceptinvite Adligen]");

                        }
                    } else if(args[0].equalsIgnoreCase("kick")) {
                        if(sp.getCityRang() == 4 || p.hasPermission("frak.managemant.admin")) {
                            Player p2 = Bukkit.getServer().getPlayer(args[1]);
                            SkyPlayer sp2 = Roleplay.getPlayer(p2.getUniqueId());
                            sp2.setCity("Keine Fraktion");
                            sp2.setCityRang(0);
                            p2.sendMessage(Roleplay.prefix + "Du wurdest aus der Fraktion geworfen");
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                SkyPlayer spa = Roleplay.getPlayer(p.getUniqueId());
                                if(spa.getCity().equalsIgnoreCase("Adligen")) {
                                    all.sendMessage(Roleplay.prefix + p.getName()  +" wurde aus der Fraktion geworfen!");
                                }
                            }
                            sp2.update();
                            sp.update();
                        }
                    } else if(args[0].equalsIgnoreCase("promote")) {
                        if(sp.getCityRang() == 4 || p.hasPermission("frak.managemant.admin")) {
                            Player p2 = Bukkit.getServer().getPlayer(args[1]);
                            SkyPlayer sp2 = Roleplay.getPlayer(p2.getUniqueId());
                            if(sp2.getCityRang() == 1) {
                                sp2.setCityRang(2);
                                p2.sendMessage(Roleplay.prefix + "Du wurdestbefördert!");
                                p.sendMessage(Roleplay.prefix + "Du hast " + p2.getName() + " befördert");
                            } else if(sp2.getCityRang() == 2) {
                                sp2.setCityRang(3);
                                p2.sendMessage(Roleplay.prefix + "Du wurdestbefördert!");
                                p.sendMessage(Roleplay.prefix + "Du hast " + p2.getName() + " befördert");
                            } else {
                                p.sendMessage(Roleplay.prefix + "Dieser Spieler kann nicht mehr Promotet werden");
                            }

                            sp2.update();
                            sp.update();
                        }
                    } else if(args[0].equalsIgnoreCase("demote")) {
                        if(sp.getCityRang() == 4 || p.hasPermission("frak.managemant.admin")) {
                            Player p2 = Bukkit.getServer().getPlayer(args[1]);
                            SkyPlayer sp2 = Roleplay.getPlayer(p2.getUniqueId());
                            if(sp2.getCityRang() == 1) {
                                p.sendMessage(Roleplay.prefix + "Dieser Spieler kann nicht mehr Promotet werden");
                            } else if(sp2.getCityRang() == 2) {
                                sp2.setCityRang(1);
                                p2.sendMessage(Roleplay.prefix + "Du wurdest degradiert!");
                                p.sendMessage(Roleplay.prefix + "Du hast " + p2.getName() + " degradiert");
                            } else if(sp2.getCityRang() == 3) {
                                sp2.setCityRang(2);
                                p2.sendMessage(Roleplay.prefix + "Du wurdest degradiert!");
                                p.sendMessage(Roleplay.prefix + "Du hast " + p2.getName() + " degradiert");
                            }

                            sp2.update();
                            sp.update();
                        }
                    }
                }
            }
        }*/
        return false;
    }
}
