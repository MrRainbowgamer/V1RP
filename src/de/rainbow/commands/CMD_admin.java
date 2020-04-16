package de.rainbow.commands;

import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class CMD_admin implements CommandExecutor {

    public static HashMap<Player, Boolean> v = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(args.length == 1) {
                if(p.isOp()) {
                    if(args[0].equalsIgnoreCase("vanish") || args[0].equalsIgnoreCase("v")) {
                        if(v.containsKey(p)) {
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(p);
                                p.setGameMode(GameMode.SURVIVAL);
                                all.sendMessage("§7" + p.getName() + " ist aufgewacht!");
                            }
                            v.remove(p);
                        } else {
                            for(Player all : Bukkit.getOnlinePlayers()) {
                                all.hidePlayer(p);
                                p.setGameMode(GameMode.CREATIVE);
                                all.sendMessage("§7" + p.getName() + " hat sich hingelegt!");
                            }
                            v.put(p, true);
                        }

                    } else if(args[0].equalsIgnoreCase("invsee")) {
                        p.sendMessage("/admin invsee [name]");
                    } else if(args[0].equalsIgnoreCase("debug")) {
                        SkyPlayer cp = Roleplay.getOnlinePlayer(p.getUniqueId());
                        if(cp.isGodduty() == false) {
                            cp.setGodduty(true);
                            cp.update();
                            p.sendMessage("Debug Mode aktiviert!");
                        } else {
                            cp.setGodduty(false);
                            cp.update();
                            p.sendMessage("Debug Mode deaktiviert!");
                        }
                    } else if(args[0].equalsIgnoreCase("villager")) {
                        ItemStack blaze_rod = new ItemStack(Material.BLAZE_ROD);
                        ItemMeta img = blaze_rod.getItemMeta();
                        img.setDisplayName("§4Villager Delete Tool");
                        blaze_rod.setItemMeta(img);

                        p.getInventory().addItem(blaze_rod);
                        p.sendMessage("Du hast dir das §4Villager Delete Tool §fgegeben!");
                    }
                }

            } else if(args.length == 2) {
                if(p.isOp()) {
                    if(args[0].equalsIgnoreCase("invsee")) {
                        Player p2 = Bukkit.getServer().getPlayer(args[1]);
                        p.sendMessage(p2.getName() + "");
                        p.openInventory(p2.getInventory());
                    }
                }
            } else if(args.length == 3) {

                if(p.isOp()) {
                    if(args[0].equalsIgnoreCase("taler")) {
                        Player p2 = Bukkit.getServer().getPlayer(args[1]);
                        int amount = Integer.valueOf(args[2]);

                        ItemStack gold = new ItemStack(Material.GOLD_NUGGET, amount);
                        ItemMeta img = gold.getItemMeta();
                        img.setDisplayName("§6Goldtaler");
                        gold.setItemMeta(img);

                        p2.getInventory().addItem(gold);
                        p2.sendMessage("Du hast §6" + amount + " §6Goldtaler §ferhalten!");
                        p.sendMessage(p2.getName() + " hat §6" + amount + " §6Goldtaler §ferhalten!");


                    }
                }
            }
        }


        return false;
    }
}
