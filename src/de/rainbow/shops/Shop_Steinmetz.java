package de.rainbow.shops;

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
import java.util.HashMap;

public class Shop_Steinmetz implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            Villager v = (Villager) e.getRightClicked();
            if (v.getCustomName().equalsIgnoreCase("§7Steinmetz")) {
                e.setCancelled(true);
                Inventory inv = Bukkit.createInventory(null, 27, "§8Steinmetz");
                Shop_ItemBuilder.buildInv27wSell(inv);
                ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                ItemStack b_stone = new ItemStack(Material.STONE);
                ItemStack b_stone_stairs = new ItemStack(Material.STONE_STAIRS);

                inv.setItem(11, b_stone);
                inv.setItem(15, b_stone_stairs);
                e.getPlayer().openInventory(inv);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        try {
            ItemStack gold = new ItemStack(Material.GOLD_NUGGET);
            ItemMeta img = gold.getItemMeta();
            img.setDisplayName("§6Goldtaler");
            gold.setItemMeta(img);
            ItemStack gold1 = new ItemStack(Material.GOLD_NUGGET, 1);
            ItemMeta img1 = gold1.getItemMeta();
            img1.setDisplayName("§6Goldtaler");
            gold1.setItemMeta(img1);
            ItemStack gold2 = new ItemStack(Material.GOLD_NUGGET, 2);
            ItemMeta img2 = gold2.getItemMeta();
            img2.setDisplayName("§6Goldtaler");
            gold2.setItemMeta(img2);
            ItemStack gold3 = new ItemStack(Material.GOLD_NUGGET, 3);
            ItemMeta img3 = gold3.getItemMeta();
            img3.setDisplayName("§6Goldtaler");
            gold3.setItemMeta(img3);

            Player p = (Player) e.getWhoClicked();
            Inventory invp = e.getInventory();
            if (e.getView().getTitle().equalsIgnoreCase("§8Steinmetz")) {
                if (e.getRawSlot() < 27) {
                    e.setCancelled(true);
                    if (e.getClick().isRightClick() || e.getClick().isLeftClick()) {
                        if (e.getCurrentItem().getType() == Material.STONE) {
                            Inventory inv2 = Bukkit.createInventory(null, 27, "§8Steinmetz - Stein");
                            Shop_ItemBuilder.buildInv27(inv2);
                            ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                            ItemStack b_stone = new ItemStack(Material.STONE);
                            ItemMeta b_stone_m = b_stone.getItemMeta();
                            ArrayList<String> b_stone_l = new ArrayList<>();
                            b_stone_l.add("");
                            b_stone_l.add(" §7Linksklick -> Kaufen");
                            b_stone_l.add("  §7Preis: §62 Goldtaler   ");
                            b_stone_m.setLore(b_stone_l);
                            b_stone.setItemMeta(b_stone_m);
                            ItemStack b_cobble = new ItemStack(Material.COBBLESTONE);
                            ItemMeta b_cobble_m = b_cobble.getItemMeta();
                            ArrayList<String> b_cobble_l = new ArrayList<>();
                            b_cobble_l.add("");
                            b_cobble_l.add(" §7Linksklick -> Kaufen");
                            b_cobble_l.add("  §7Preis: §62 Goldtaler   ");
                            b_cobble_m.setLore(b_cobble_l);
                            b_cobble.setItemMeta(b_cobble_m);
                            ItemStack b_diorit = new ItemStack(Material.DIORITE);
                            ItemMeta b_diorit_m = b_diorit.getItemMeta();
                            ArrayList<String> b_diorit_l = new ArrayList<>();
                            b_diorit_l.add("");
                            b_diorit_l.add(" §7Linksklick -> Kaufen");
                            b_diorit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_diorit_m.setLore(b_diorit_l);
                            b_diorit.setItemMeta(b_diorit_m);
                            ItemStack b_andesit = new ItemStack(Material.ANDESITE);
                            ItemMeta b_andesit_m = b_andesit.getItemMeta();
                            ArrayList<String> b_andesit_l = new ArrayList<>();
                            b_andesit_l.add("");
                            b_andesit_l.add(" §7Linksklick -> Kaufen");
                            b_andesit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_andesit_m.setLore(b_andesit_l);
                            b_andesit.setItemMeta(b_andesit_m);
                            ItemStack b_granit = new ItemStack(Material.GRANITE);
                            ItemMeta b_granit_m = b_granit.getItemMeta();
                            ArrayList<String> b_granit_l = new ArrayList<>();
                            b_granit_l.add("");
                            b_granit_l.add(" §7Linksklick -> Kaufen");
                            b_granit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_granit_m.setLore(b_granit_l);
                            b_granit.setItemMeta(b_granit_m);

                            inv2.setItem(11, b_stone);
                            inv2.setItem(12, b_cobble);
                            inv2.setItem(13, b_diorit);
                            inv2.setItem(14, b_andesit);
                            inv2.setItem(15, b_granit);


                            p.openInventory(inv2);
                        }  else if (e.getCurrentItem().getType() == Material.BREAD) {
                            System.out.println("Test");
                            Inventory inv2 = Bukkit.createInventory(null, 27, "§8Steinmetz - Ankauf");
                            Shop_ItemBuilder.buildInv27(inv2);
                            Shop_ItemBuilder.buildEssenAnkauf(inv2);
                            p.openInventory(inv2);
                        } else if (e.getCurrentItem().getType() == Material.STONE_STAIRS) {
                            Inventory inv2 = Bukkit.createInventory(null, 45, "§8Steinmetz - Spezial");
                            Shop_ItemBuilder.buildInv45(inv2);
                            ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                            ItemStack b_stone = new ItemStack(Material.STONE_STAIRS);
                            ItemMeta b_stone_m = b_stone.getItemMeta();
                            ArrayList<String> b_stone_l = new ArrayList<>();
                            b_stone_l.add("");
                            b_stone_l.add(" §7Linksklick -> Kaufen");
                            b_stone_l.add("  §7Preis: §62 Goldtaler   ");
                            b_stone_m.setLore(b_stone_l);
                            b_stone.setItemMeta(b_stone_m);
                            ItemStack b_cobble = new ItemStack(Material.COBBLESTONE_STAIRS);
                            ItemMeta b_cobble_m = b_cobble.getItemMeta();
                            ArrayList<String> b_cobble_l = new ArrayList<>();
                            b_cobble_l.add("");
                            b_cobble_l.add(" §7Linksklick -> Kaufen");
                            b_cobble_l.add("  §7Preis: §62 Goldtaler   ");
                            b_cobble_m.setLore(b_cobble_l);
                            b_cobble.setItemMeta(b_cobble_m);
                            ItemStack b_diorit = new ItemStack(Material.DIORITE_STAIRS);
                            ItemMeta b_diorit_m = b_diorit.getItemMeta();
                            ArrayList<String> b_diorit_l = new ArrayList<>();
                            b_diorit_l.add("");
                            b_diorit_l.add(" §7Linksklick -> Kaufen");
                            b_diorit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_diorit_m.setLore(b_diorit_l);
                            b_diorit.setItemMeta(b_diorit_m);
                            ItemStack b_andesit = new ItemStack(Material.ANDESITE_STAIRS);
                            ItemMeta b_andesit_m = b_andesit.getItemMeta();
                            ArrayList<String> b_andesit_l = new ArrayList<>();
                            b_andesit_l.add("");
                            b_andesit_l.add(" §7Linksklick -> Kaufen");
                            b_andesit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_andesit_m.setLore(b_andesit_l);
                            b_andesit.setItemMeta(b_andesit_m);
                            ItemStack b_granit = new ItemStack(Material.GRANITE_STAIRS);
                            ItemMeta b_granit_m = b_granit.getItemMeta();
                            ArrayList<String> b_granit_l = new ArrayList<>();
                            b_granit_l.add("");
                            b_granit_l.add(" §7Linksklick -> Kaufen");
                            b_granit_l.add("  §7Preis: §62 Goldtaler   ");
                            b_granit_m.setLore(b_granit_l);
                            b_granit.setItemMeta(b_granit_m);
                            ItemStack b_stoneslab = new ItemStack(Material.STONE_SLAB);
                            ItemMeta b_stoneslab_m = b_stoneslab.getItemMeta();
                            ArrayList<String> b_stoneslab_l = new ArrayList<>();
                            b_stoneslab_l.add("");
                            b_stoneslab_l.add(" §7Linksklick -> Kaufen");
                            b_stoneslab_l.add("  §7Preis: §62 Goldtaler   ");
                            b_stoneslab_m.setLore(b_stoneslab_l);
                            b_stoneslab.setItemMeta(b_stoneslab_m);
                            ItemStack b_cobbleslab = new ItemStack(Material.COBBLESTONE_SLAB);
                            ItemMeta b_cobbleslab_m = b_cobbleslab.getItemMeta();
                            ArrayList<String> b_cobbleslab_l = new ArrayList<>();
                            b_cobbleslab_l.add("");
                            b_cobbleslab_l.add(" §7Linksklick -> Kaufen");
                            b_cobbleslab_l.add("  §7Preis: §62 Goldtaler   ");
                            b_cobbleslab_m.setLore(b_cobbleslab_l);
                            b_cobbleslab.setItemMeta(b_cobbleslab_m);
                            ItemStack b_dioritslab = new ItemStack(Material.DIORITE_SLAB);
                            ItemMeta b_dioritslab_m = b_dioritslab.getItemMeta();
                            ArrayList<String> b_dioritslab_l = new ArrayList<>();
                            b_dioritslab_l.add("");
                            b_dioritslab_l.add(" §7Linksklick -> Kaufen");
                            b_dioritslab_l.add("  §7Preis: §62 Goldtaler   ");
                            b_dioritslab_m.setLore(b_dioritslab_l);
                            b_dioritslab.setItemMeta(b_dioritslab_m);
                            ItemStack b_andesitslab = new ItemStack(Material.ANDESITE_SLAB);
                            ItemMeta b_andesitslab_m = b_andesitslab.getItemMeta();
                            ArrayList<String> b_andesitslab_l = new ArrayList<>();
                            b_andesitslab_l.add("");
                            b_andesitslab_l.add(" §7Linksklick -> Kaufen");
                            b_andesitslab_l.add("  §7Preis: §62 Goldtaler   ");
                            b_andesitslab_m.setLore(b_andesitslab_l);
                            b_andesitslab.setItemMeta(b_andesitslab_m);
                            ItemStack b_granitslab = new ItemStack(Material.GRANITE_SLAB);
                            ItemMeta b_granitslab_m = b_granitslab.getItemMeta();
                            ArrayList<String> b_granitslab_l = new ArrayList<>();
                            b_granitslab_l.add("");
                            b_granitslab_l.add(" §7Linksklick -> Kaufen");
                            b_granitslab_l.add("  §7Preis: §62 Goldtaler   ");
                            b_granitslab_m.setLore(b_granitslab_l);
                            b_granitslab.setItemMeta(b_granitslab_m);


                            ItemStack b_cobblewall = new ItemStack(Material.COBBLESTONE_WALL);
                            ItemMeta b_cobblewall_m = b_cobblewall.getItemMeta();
                            b_cobblewall_m.setLore(b_cobble_l);
                            b_cobblewall.setItemMeta(b_cobblewall_m);
                            ItemStack b_dioritwall = new ItemStack(Material.DIORITE_WALL);
                            ItemMeta b_dioritwall_m = b_dioritwall.getItemMeta();
                            b_dioritwall_m.setLore(b_diorit_l);
                            b_dioritwall.setItemMeta(b_dioritwall_m);
                            ItemStack b_andesitwall = new ItemStack(Material.ANDESITE_WALL);
                            ItemMeta b_andesitwall_m = b_andesitwall.getItemMeta();
                            b_andesitwall_m.setLore(b_andesit_l);
                            b_andesitwall.setItemMeta(b_andesitwall_m);
                            ItemStack b_granitwall = new ItemStack(Material.GRANITE_WALL);
                            ItemMeta b_granitwall_m = b_granitwall.getItemMeta();
                            b_granitwall_m.setLore(b_granit_l);
                            b_granitwall.setItemMeta(b_granitwall_m);

                            ItemStack close = new ItemStack(Material.BARRIER);
                            ItemMeta iclose = close.getItemMeta();
                            iclose.setDisplayName("§cSchließen");
                            close.setItemMeta(iclose);



                            inv2.setItem(11, b_stone);
                            inv2.setItem(12, b_cobble);
                            inv2.setItem(13, b_diorit);
                            inv2.setItem(14, b_andesit);
                            inv2.setItem(15, b_granit);
                            inv2.setItem(20, b_stoneslab);
                            inv2.setItem(21, b_cobbleslab);
                            inv2.setItem(22, b_dioritslab);
                            inv2.setItem(23, b_andesitslab);
                            inv2.setItem(24, b_granitslab);

                            inv2.setItem(30, b_cobblewall);
                            inv2.setItem(31, b_dioritwall);
                            inv2.setItem(32, b_andesitwall);
                            inv2.setItem(33, b_granitwall);


                            p.openInventory(inv2);
                        }
                    }
                }
                } else if (e.getView().getTitle().equalsIgnoreCase("§8Steinmetz - Stein")) {
                    if (e.getRawSlot() < 27) {
                        e.setCancelled(true);
                        if (e.getClick().isRightClick()) { //§6Goldtaler
                            if (e.getCurrentItem().getType() == Material.BARRIER) {
                                p.closeInventory();
                            }
                        } else if (e.getClick().isLeftClick()) { //§6Goldtaler
                            if (e.getCurrentItem().getType() == Material.BARRIER) {
                                p.closeInventory();
                            } else if (e.getCurrentItem().getType() == Material.COBBLESTONE) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(Shop_Objekte.COBBLESTONE.getMaterial());
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.STONE) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.STONE, 32));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.DIORITE) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.DIORITE, 32));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.ANDESITE) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.ANDESITE, 32));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.GRANITE) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.GRANITE, 32));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            }
                        }
                    }
                } else if (e.getView().getTitle().equalsIgnoreCase("§8Steinmetz - Spezial")) {
                    if (e.getRawSlot() < 46) {
                        e.setCancelled(true);
                        if (e.getClick().isRightClick()) { //§6Goldtaler
                            if (e.getCurrentItem().getType() == Material.BARRIER) {
                                p.closeInventory();
                            }
                        } else if (e.getClick().isLeftClick()) { //§6Goldtaler
                            if (e.getCurrentItem().getType() == Material.BARRIER) {
                                p.closeInventory();
                            } else if (e.getCurrentItem().getType() == Material.COBBLESTONE_STAIRS) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE_STAIRS, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.STONE_STAIRS) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.STONE_STAIRS, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.DIORITE_STAIRS) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.DIORITE_STAIRS, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.ANDESITE_STAIRS) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.ANDESITE_STAIRS, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.GRANITE_STAIRS) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.GRANITE_STAIRS, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.COBBLESTONE_SLAB) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE_SLAB, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.STONE_SLAB) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.STONE_SLAB, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.DIORITE_SLAB) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.DIORITE_SLAB, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.ANDESITE_SLAB) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.ANDESITE_SLAB, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.GRANITE_SLAB) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.GRANITE_SLAB, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.COBBLESTONE_WALL) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE_WALL, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.DIORITE_WALL) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.DIORITE_WALL, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.ANDESITE_WALL) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.ANDESITE_WALL, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            } else if (e.getCurrentItem().getType() == Material.GRANITE_WALL) {
                                if (p.getInventory().containsAtLeast(gold, 2)) {
                                    p.getInventory().addItem(new ItemStack(Material.GRANITE_WALL, 16));
                                    p.getInventory().removeItem(gold2);
                                } else {
                                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                                }
                            }

                        }
                    }
                } else if (e.getView().getTitle().equalsIgnoreCase("§8Steinmetz - Ankauf")) {

                if (e.getRawSlot() < 27) {
                    e.setCancelled(true);
                    if (e.getClick().isRightClick() || e.getClick().isLeftClick()) { //§6Goldtaler
                        if (e.getCurrentItem().getType() == Material.BARRIER) {
                            Inventory inv = Bukkit.createInventory(null, 27, "§8Steinmetz");
                            Shop_ItemBuilder.buildVillagerHome(inv);
                            p.openInventory(inv);
                        } else if (e.getCurrentItem().getType() == Material.APPLE) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.APPLE), 8)) {
                                p.getInventory().removeItem( new ItemStack(Material.APPLE, 8));
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
        if(e.getEntityType() == EntityType.VILLAGER) {
            Villager v = (Villager) e.getEntity();
            if(v.getCustomName().equalsIgnoreCase("§7Steinmetz")) {
                e.setCancelled(true);
            }
        }
    }
}
