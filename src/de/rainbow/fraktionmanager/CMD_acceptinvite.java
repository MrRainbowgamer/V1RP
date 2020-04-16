package de.rainbow.fraktionmanager;

import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_acceptinvite implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        /*        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(args.length == 1) {
                if (Roleplay.invites.containsKey(p)) {

                    if (args[0].equalsIgnoreCase("Adligen")) {
                        if (Roleplay.invites.get(p) == "Adligen") {
                            SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());
                            sp.setCity("Adligen");
                            sp.setCityRang(1);
                            Roleplay.invites.remove(p);
                            p.sendMessage(Roleplay.prefix + "Du hast die Einladung angenommen");
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                SkyPlayer spa = Roleplay.getPlayer(p.getUniqueId());
                                if(spa.getCity().equalsIgnoreCase("Adligen")) {
                                    all.sendMessage(Roleplay.prefix + p.getName()  +" wurde bei den Adligen aufgenommen");
                                }
                            }
                            sp.update();
                        } else {
                            p.sendMessage(Roleplay.prefix + "Du hast keine Einladung erhalten");
                        }
                    } else if (args[0].equalsIgnoreCase("Aufgeklärte")) {
                        if (Roleplay.invites.get(p) == "Aufgeklärte") {
                            SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());
                            sp.setCity("Aufgeklärte");
                            sp.setCityRang(1);
                            Roleplay.invites.remove(p);
                            p.sendMessage(Roleplay.prefix + "Du hast die Einladung angenommen");
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                SkyPlayer spa = Roleplay.getPlayer(p.getUniqueId());
                                if(spa.getCity().equalsIgnoreCase("Aufgeklärte")) {
                                    all.sendMessage(Roleplay.prefix + p.getName()  +" wurde bei den Aufgeklärten aufgenommen");
                                }
                            }
                            sp.update();
                        } else {
                            p.sendMessage(Roleplay.prefix + "Du hast keine Einladung erhalten");
                        }
                    } else if (args[0].equalsIgnoreCase("Templer")) {
                        if (Roleplay.invites.get(p) == "Templer") {
                            SkyPlayer sp = Roleplay.getPlayer(p.getUniqueId());
                            sp.setCity("Templer");
                            sp.setCityRang(1);
                            Roleplay.invites.remove(p);
                            p.sendMessage(Roleplay.prefix + "Du hast die Einladung angenommen");
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                SkyPlayer spa = Roleplay.getPlayer(p.getUniqueId());
                                if(spa.getCity().equalsIgnoreCase("Templer")) {
                                    all.sendMessage(Roleplay.prefix + p.getName()  +" wurde bei den Templer aufgenommen");
                                }
                            }
                            sp.update();
                        } else {
                            p.sendMessage(Roleplay.prefix + "Du hast keine Einladung erhalten");
                        }
                    } else {
                        p.sendMessage(Roleplay.prefix + "Bitte gebe noch Adligen/Aufgeklärte/Templer ein");
                    }
                } else {
                    p.sendMessage(Roleplay.prefix + "Du hast keine Einladung erhalten");
                }
            } else {
                p.sendMessage(Roleplay.prefix + "Da fehlt was");
            }


        }*/
        return false;
    }
}
