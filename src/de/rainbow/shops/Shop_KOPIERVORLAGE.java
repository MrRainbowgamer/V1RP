package de.rainbow.shops;

import de.rainbow.chunk.api.City;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Shop_KOPIERVORLAGE implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        SkyPlayer cp = Roleplay.getOnlinePlayer(e.getPlayer().getUniqueId());
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            City c = Roleplay.getCityAtChunk(e.getRightClicked().getLocation().getChunk());
            Villager v = (Villager) e.getRightClicked();
            if (v.getCustomName().equalsIgnoreCase("§7Jäger")) {
                e.setCancelled(true);
                if (c == null || cp.getCity() != c)
                    return;
                Inventory inv = Bukkit.createInventory(null, 27, "§8Jäger");
                Shop_ItemBuilder.buildVillagerHome(inv);
                e.getPlayer().openInventory(inv);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        try {
            ItemStack gold = new ItemStack(Material.GOLD_NUGGET, 1);
            ItemMeta img = gold.getItemMeta();
            img.setDisplayName("§6Goldtaler");
            gold.setItemMeta(img);
            Player p = (Player) e.getWhoClicked();
            Inventory invp = e.getInventory();
            if (e.getView().getTitle().equalsIgnoreCase("§8Jäger")) {
                if (e.getRawSlot() < 27) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick() || e.getClick().isRightClick()) {
                        if (e.getCurrentItem().getType() == Material.CHEST) {
                            Inventory inv1 = Bukkit.createInventory(null, 27, "§8Jäger - Dropps");
                            Shop_ItemBuilder.buildInv27(inv1);
                            Shop_ItemBuilder.buildJeager(inv1);
                            p.openInventory(inv1);
                        } else if (e.getCurrentItem().getType() == Material.BREAD) {
                            Inventory inv2 = Bukkit.createInventory(null, 27, "§8Jäger - Ankauf");
                            Shop_ItemBuilder.buildInv27(inv2);
                            Shop_ItemBuilder.buildEssenAnkauf(inv2);
                            p.openInventory(inv2);
                        } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                            p.closeInventory();
                        }
                    }
                }
            } else if (e.getView().getTitle().equalsIgnoreCase("§8Jäger - Dropps")) {
                if (e.getRawSlot() < 27) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick() || e.getClick().isRightClick()) {
                        if (e.getCurrentItem().getType() == Material.BARRIER) {
                            Inventory inv = Bukkit.createInventory(null, 27, "§8Jäger");
                            Shop_ItemBuilder.buildVillagerHome(inv);
                            p.openInventory(inv);
                        } else if (e.getCurrentItem().getType() == Material.BONE) {
                            ItemStack gold1 = new ItemStack(Material.GOLD_NUGGET, Shop_Objekte.BONE.getBuyprice());
                            ItemMeta img1 = gold1.getItemMeta();
                            img1.setDisplayName("§6Goldtaler");
                            gold1.setItemMeta(img1);
                            if (p.getInventory().containsAtLeast(gold1, 1)) {
                                p.getInventory().addItem(new ItemStack(Material.BONE, 16));
                                p.getInventory().removeItem(gold1);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        }
                    }
                }
            } else if (e.getView().getTitle().equalsIgnoreCase("§8Jäger - Ankauf")) {
                if (e.getRawSlot() < 27) {
                    e.setCancelled(true);
                    if (e.getClick().isRightClick() || e.getClick().isLeftClick()) { //§6Goldtaler
                        if (e.getCurrentItem().getType() == Material.BARRIER) {
                            Inventory inv = Bukkit.createInventory(null, 27, "§8Jäger");
                            Shop_ItemBuilder.buildVillagerHome(inv);
                            p.openInventory(inv);
                        } else if (e.getCurrentItem().getType() == Material.APPLE) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 8)) {
                                p.getInventory().removeItem(new ItemStack(Material.APPLE, 8));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.APPLE.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.BAKED_POTATO) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.BAKED_POTATO), 16)) {
                                p.getInventory().removeItem(new ItemStack(Material.BAKED_POTATO, 16));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.BAKED_POTATO.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.CAKE) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 1)) {
                                p.getInventory().removeItem(new ItemStack(Material.CAKE, 1));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.CAKE.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.COOKED_MUTTON) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.COOKED_MUTTON), 32)) {
                                p.getInventory().removeItem(new ItemStack(Material.COOKED_MUTTON, 32));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.COOKED_MUTTON.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.COOKED_BEEF) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.COOKED_BEEF), 32)) {
                                p.getInventory().removeItem(new ItemStack(Material.COOKED_BEEF, 32));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.COOKED_BEEF.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.COOKED_CHICKEN) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.COOKED_CHICKEN), 32)) {
                                p.getInventory().removeItem(new ItemStack(Material.COOKED_CHICKEN, 32));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.COOKED_CHICKEN.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        } else if (e.getCurrentItem().getType() == Material.COOKED_PORKCHOP) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.COOKED_PORKCHOP), 32)) {
                                p.getInventory().removeItem(new ItemStack(Material.COOKED_PORKCHOP, 32));
                                Shop_ItemBuilder.addGold(p.getInventory(), Shop_Objekte.COOKED_PORKCHOP.getBuyprice());
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);

                            }
                        }
                    }
                }
            }
        } catch (NullPointerException ex) {

        }

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntityType() == EntityType.VILLAGER) {
            Villager v = (Villager) e.getEntity();
            try {
                if (v.getCustomName().equalsIgnoreCase("§7Jäger")) {
                    e.setCancelled(true);
                }
            } catch (NullPointerException ex) {
            }

        }
    }
}