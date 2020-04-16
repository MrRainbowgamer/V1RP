package de.rainbow.commands;

import com.sun.istack.internal.NotNull;
import de.rainbow.main.Roleplay;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMD_Spawnshop implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("rp.spawn.shop")) {
                if (args.length == 0) {
                    p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Schmied/Steinmetz/Jäger/Holzfäller");
                } else {
                    if (args[0].equalsIgnoreCase("Schmied")) {
                        if (args.length == 1) {
                            p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Schmied Meisterschmied/Rüstungsschmied/Schmied");
                        } else {
                            if (args[1].equalsIgnoreCase("Meisterschmied")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Meisterschmied");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else if (args[1].equalsIgnoreCase("Rüstungsschmied")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Rüstungsschmied");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else if (args[1].equalsIgnoreCase("Schmied")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Schmied");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else {
                                p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Schmied Meisterschmied/Rüstungsschmied/Schmied");
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("Steinmetz")) {
                        if (args.length == 1) {
                            p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Schmied Meisterschmied/");
                        } else {
                            if (args[1].equalsIgnoreCase("Steinmetz")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Steinmetz");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else if (args[1].equalsIgnoreCase("Meistersteinmetz")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Meistersteinmetz");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else {
                                p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Steinmetz Steinmetz/Meistersteinmetz");
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("Jäger")) {
                        if (args.length == 1) {
                            p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Jäger Jäger");
                        } else {
                            if (args[1].equalsIgnoreCase("Jäger")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Jäger");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else {
                                p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Jäger Jäger");
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("Holzfäller")) {
                        if (args.length == 1) {
                            p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Holzfäller Holzfäller");
                        } else {
                            if (args[1].equalsIgnoreCase("Holzfäller")) {
                                Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                v.setCustomName("§7Holzfäller");
                                v.setCustomNameVisible(true);
                                v.setCollidable(false);
                                v.setAI(false);
                            } else {
                                p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Holzfäller Holzfäller");
                            }
                        }
                    } else {
                        p.sendMessage(Roleplay.prefix + "Bitte Probiere /spawnshop Schmied/Steinmetz/Jäger/Holzfäller");
                    }
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onKill(PlayerInteractEntityEvent e) {
        Villager v = (Villager) e.getRightClicked();

        ItemStack blaze_rod = new ItemStack(Material.BLAZE_ROD);
        ItemMeta img = blaze_rod.getItemMeta();
        img.setDisplayName("§4Villager Delete Tool");
        blaze_rod.setItemMeta(img);

        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();

        if (item.getType() == Material.BLAZE_ROD) {
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§4Villager Delete Tool")) {
                v.setHealth(0);
            }
        }
    }
}
