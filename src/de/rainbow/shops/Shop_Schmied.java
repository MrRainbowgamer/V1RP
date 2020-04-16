package de.rainbow.shops;

        import com.mojang.datafixers.types.templates.List;
        import net.minecraft.server.v1_14_R1.EntityItem;
        import org.bukkit.Bukkit;
        import org.bukkit.Material;
        import org.bukkit.Sound;
        import org.bukkit.entity.*;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.entity.EntityDamageByEntityEvent;
        import org.bukkit.event.entity.EntityDamageEvent;
        import org.bukkit.event.inventory.InventoryClickEvent;
        import org.bukkit.event.player.PlayerInteractEntityEvent;
        import org.bukkit.inventory.Inventory;
        import org.bukkit.inventory.ItemStack;
        import org.bukkit.inventory.meta.ItemMeta;
        import org.bukkit.inventory.meta.LeatherArmorMeta;

        import java.util.ArrayList;

public class Shop_Schmied implements Listener {



    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        if(e.getRightClicked().getType() == EntityType.VILLAGER) {
            Villager v = (Villager) e.getRightClicked();
            if(v.getCustomName().equalsIgnoreCase("§7Meisterschmied")) {
                e.setCancelled(true);
                Inventory inv = Bukkit.createInventory(null, 54, "§8Meisterschmied");
                Shop_ItemBuilder.buildInv54(inv);
                ItemStack Iron_helemt = new ItemStack(Material.IRON_HELMET);
                ItemMeta Iron_helmet_m = Iron_helemt.getItemMeta();
                Iron_helmet_m.setDisplayName("§7Eisenhelm");
                ArrayList<String> Iron_helemt_l = new ArrayList<>();
                Iron_helemt_l.add("");
                Iron_helemt_l.add(" §7Rechtsklick -> Herrstellen");
                Iron_helemt_l.add(" §7Preis: §65 Eisenblöcke");
                Iron_helemt_l.add("           §61 Lederhelm");
                Iron_helemt_l.add(" §7Linksklick -> Kaufen");
                Iron_helemt_l.add("  §7Preis: §640 Gold   ");
                Iron_helmet_m.setLore(Iron_helemt_l);
                Iron_helemt.setItemMeta(Iron_helmet_m);
                ItemStack Iron_cheastplate = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta Iron_cheastplate_m = Iron_helemt.getItemMeta();
                Iron_cheastplate_m.setDisplayName("§7Eisenbrustplatte");
                ArrayList<String> Iron_cheastplate_l = new ArrayList<>();
                Iron_cheastplate_l.add("");
                Iron_cheastplate_l.add(" §7Rechtsklick -> Herrstellen");
                Iron_cheastplate_l.add(" §7Preis: §68 Eisenblöcke");
                Iron_cheastplate_l.add("           §61 Lederbrustplatte");
                Iron_cheastplate_l.add(" §7Linksklick -> Kaufen");
                Iron_cheastplate_l.add("  §7Preis: §680 Gold   ");
                Iron_cheastplate_m.setLore(Iron_cheastplate_l);
                Iron_cheastplate.setItemMeta(Iron_cheastplate_m);
                ItemStack Iron_leggins = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta Iron_leggins_m = Iron_helemt.getItemMeta();
                Iron_leggins_m.setDisplayName("§7Eisenhose");
                ArrayList<String> Iron_leggins_l = new ArrayList<>();
                Iron_leggins_l.add("");
                Iron_leggins_l.add(" §7Rechtsklick -> Herrstellen");
                Iron_leggins_l.add(" §7Preis: §67 Eisenblöcke");
                Iron_leggins_l.add("           §61 Lederhose");
                Iron_leggins_l.add(" §7Linksklick -> Kaufen");
                Iron_leggins_l.add("  §7Preis: §660 Gold   ");
                Iron_leggins_m.setLore(Iron_leggins_l);
                Iron_leggins.setItemMeta(Iron_leggins_m);
                ItemStack Iron_boots = new ItemStack(Material.IRON_BOOTS);
                ItemMeta Iron_boots_m = Iron_helemt.getItemMeta();
                Iron_boots_m.setDisplayName("§7Eisenstiefel");
                ArrayList<String> Iron_boots_l = new ArrayList<>();
                Iron_boots_l.add("");
                Iron_boots_l.add(" §7Rechtsklick -> Herrstellen");
                Iron_boots_l.add(" §7Preis: §64 Eisenblöcke");
                Iron_boots_l.add("           §61 Lederschuh");
                Iron_boots_l.add(" §7Linksklick -> Kaufen");
                Iron_boots_l.add("  §7Preis: §620 Gold   ");
                Iron_boots_m.setLore(Iron_boots_l);
                Iron_boots.setItemMeta(Iron_boots_m);
                inv.setItem(10, Iron_helemt);
                inv.setItem(19, Iron_cheastplate);
                inv.setItem(28, Iron_leggins);
                inv.setItem(37, Iron_boots);

                //e.getPlayer().closeInventory();
                e.getPlayer().openInventory(inv);
            } else if(v.getCustomName().equalsIgnoreCase("§7Schmied")) {
                e.setCancelled(true);
                Inventory inv = Bukkit.createInventory(null, 36, "§8Schmied");
                ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);


                ArrayList<String> pricelore1 = new ArrayList<>();
                pricelore1.add("");
                pricelore1.add(" §7Rechtsklick -> Herrstellen");
                pricelore1.add(" §7Preis: §61 Eisenblöcke");
                pricelore1.add("           §62 Stöcke");
                pricelore1.add(" §7Linksklick -> Kaufen");
                pricelore1.add("  §7Preis: §65 Gold   ");
                ArrayList<String> pricelore2 = new ArrayList<>();
                pricelore2.add("");
                pricelore2.add(" §7Rechtsklick -> Herrstellen");
                pricelore2.add(" §7Preis: §62 Eisenblöcke");
                pricelore2.add(" §7Linksklick -> Kaufen");
                pricelore2.add("  §7Preis: §68 Gold   ");
                ArrayList<String> pricelore3 = new ArrayList<>();
                pricelore3.add("");
                pricelore3.add(" §7Rechtsklick -> Herrstellen");
                pricelore3.add(" §7Preis: §63 Eisenbarren");
                pricelore3.add(" §7Linksklick -> Kaufen");
                pricelore3.add("  §7Preis: §615 Gold   ");
                ArrayList<String> pricelore24 = new ArrayList<>();
                pricelore24.add("");
                pricelore24.add(" §7Rechtsklick -> Herrstellen");
                pricelore24.add(" §7Preis: §62 Eisenbarren");
                pricelore24.add(" §7Linksklick -> Kaufen");
                pricelore24.add("  §7Preis: §62 Gold   ");
                ArrayList<String> pricelore22 = new ArrayList<>();
                pricelore22.add("");
                pricelore22.add(" §7Rechtsklick -> Herrstellen");
                pricelore22.add(" §7Preis: §62 Eisenblöcke");
                pricelore22.add("           §62 Stöcke");
                pricelore22.add(" §7Linksklick -> Kaufen");
                pricelore22.add("  §7Preis: §620 Gold   ");
                ArrayList<String> pricelore23 = new ArrayList<>();
                pricelore23.add("");
                pricelore23.add(" §7Rechtsklick -> Herrstellen");
                pricelore23.add(" §7Preis: §62 Eisenblöcke");
                pricelore23.add("           §61 Stöcke");
                pricelore23.add(" §7Linksklick -> Kaufen");
                pricelore23.add("  §7Preis: §625 Gold   ");
                ArrayList<String> pricelore33 = new ArrayList<>();
                pricelore33.add("");
                pricelore33.add(" §7Rechtsklick -> Herrstellen");
                pricelore33.add(" §7Preis: §63 Eisenblöcke");
                pricelore33.add("           §62 Stöcke");
                pricelore33.add(" §7Linksklick -> Kaufen");
                pricelore33.add("  §7Preis: §625 Gold   ");
                ArrayList<String> pricelore6 = new ArrayList<>();
                pricelore6.add("");
                pricelore6.add(" §7Rechtsklick -> Herrstellen");
                pricelore6.add(" §7Preis: §66 Eisenbarren");
                pricelore6.add(" §7Linksklick -> Kaufen");
                pricelore6.add("  §7Preis: §62 Gold   ");

                ItemStack SWORD = new ItemStack(Material.IRON_SWORD);
                ItemMeta SWORD_M = SWORD.getItemMeta();
                SWORD_M.setDisplayName("§7Eisenschwert");
                SWORD_M.setLore(pricelore23);
                SWORD.setItemMeta(SWORD_M);
                ItemStack PICKAXE = new ItemStack(Material.IRON_PICKAXE);
                ItemMeta PICKAXE_M = PICKAXE.getItemMeta();
                PICKAXE_M.setDisplayName("§7Eisenspitzhacke");
                PICKAXE_M.setLore(pricelore33);
                PICKAXE.setItemMeta(PICKAXE_M);
                ItemStack AXE = new ItemStack(Material.IRON_AXE);
                ItemMeta AXE_M = AXE.getItemMeta();
                AXE_M.setDisplayName("§7Eisenaxt");
                AXE_M.setLore(pricelore33);
                AXE.setItemMeta(AXE_M);
                ItemStack SHOVEL = new ItemStack(Material.IRON_SHOVEL);
                ItemMeta SHOVEL_M = SHOVEL.getItemMeta();
                SHOVEL_M.setDisplayName("§7Eisenschaufel");
                SHOVEL_M.setLore(pricelore1);
                SHOVEL.setItemMeta(SHOVEL_M);
                ItemStack HOE = new ItemStack(Material.IRON_HOE);
                ItemMeta HOE_M = HOE.getItemMeta();
                HOE_M.setDisplayName("§7Eisenhacke");
                HOE_M.setLore(pricelore22);
                HOE.setItemMeta(HOE_M);
                ItemStack BUCKET = new ItemStack(Material.BUCKET);
                ItemMeta BUCKET_M = BUCKET.getItemMeta();
                BUCKET_M.setDisplayName("§7Eimer");
                BUCKET_M.setLore(pricelore3);
                BUCKET.setItemMeta(BUCKET_M);
                ItemStack SHEARS = new ItemStack(Material.SHEARS);
                ItemMeta SHEARS_M = SHEARS.getItemMeta();
                SHEARS_M.setDisplayName("§7Schere");
                SHEARS_M.setLore(pricelore24);
                SHEARS.setItemMeta(SHEARS_M);
                ItemStack BARRS = new ItemStack(Material.IRON_BARS);
                ItemMeta BARRS_M = BARRS.getItemMeta();
                BARRS_M.setLore(pricelore6);
                BARRS.setItemMeta(BARRS_M);


                inv.setItem(0, b_glass);
                inv.setItem(1, b_glass);
                inv.setItem(2, b_glass);
                inv.setItem(3, b_glass);
                inv.setItem(4, b_glass);
                inv.setItem(5, b_glass);
                inv.setItem(6, b_glass);
                inv.setItem(7, b_glass);
                inv.setItem(8, b_glass);

                inv.setItem(11, SWORD);
                inv.setItem(12, PICKAXE);
                inv.setItem(13, AXE);
                inv.setItem(14, SHOVEL);
                inv.setItem(15, HOE);
                inv.setItem(20, BUCKET);
                inv.setItem(22, SHEARS);
                inv.setItem(24, BARRS);

                inv.setItem(27, b_glass);
                inv.setItem(28, b_glass);
                inv.setItem(29, b_glass);
                inv.setItem(30, b_glass);
                inv.setItem(31, b_glass);
                inv.setItem(32, b_glass);
                inv.setItem(33, b_glass);
                inv.setItem(34, b_glass);
                inv.setItem(35, b_glass);

                //e.getPlayer().closeInventory();
                e.getPlayer().openInventory(inv);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        try {
            ItemStack Iron_helemt = new ItemStack(Material.IRON_HELMET);
            ItemMeta Iron_helmet_m = Iron_helemt.getItemMeta();
            Iron_helmet_m.setDisplayName("§7Eisenhelm");
            Iron_helemt.setItemMeta(Iron_helmet_m);

            ItemStack Iron_cheastplate = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta Iron_cheastplate_m = Iron_helemt.getItemMeta();
            Iron_cheastplate_m.setDisplayName("§7Eisenbrustplatte");
            Iron_cheastplate.setItemMeta(Iron_cheastplate_m);

            ItemStack Iron_leggins = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta Iron_leggins_m = Iron_helemt.getItemMeta();
            Iron_leggins_m.setDisplayName("§7Eisenhose");
            Iron_leggins.setItemMeta(Iron_leggins_m);

            ItemStack Iron_boots = new ItemStack(Material.IRON_BOOTS);
            ItemMeta Iron_boots_m = Iron_helemt.getItemMeta();
            Iron_boots_m.setDisplayName("§7Eisenstiefel");
            Iron_boots.setItemMeta(Iron_boots_m);


            ItemStack SWORD = new ItemStack(Material.IRON_SWORD);
            ItemMeta SWORD_M = SWORD.getItemMeta();
            SWORD_M.setDisplayName("§7Eisenschwert");
            SWORD.setItemMeta(SWORD_M);

            ItemStack PICKAXE = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta PICKAXE_M = PICKAXE.getItemMeta();
            PICKAXE_M.setDisplayName("§7Eisenspitzhacke");
            PICKAXE.setItemMeta(PICKAXE_M);

            ItemStack AXE = new ItemStack(Material.IRON_AXE);
            ItemMeta AXE_M = AXE.getItemMeta();
            AXE_M.setDisplayName("§7Eisenaxt");
            AXE.setItemMeta(AXE_M);

            ItemStack SHOVEL = new ItemStack(Material.IRON_SHOVEL);
            ItemMeta SHOVEL_M = SHOVEL.getItemMeta();
            SHOVEL_M.setDisplayName("§7Eisenschaufel");
            SHOVEL.setItemMeta(SHOVEL_M);

            ItemStack HOE = new ItemStack(Material.IRON_HOE);
            ItemMeta HOE_M = HOE.getItemMeta();
            HOE_M.setDisplayName("§7Eisenhacke");
            HOE.setItemMeta(HOE_M);

            ItemStack BUCKET = new ItemStack(Material.BUCKET);
            ItemMeta BUCKET_M = BUCKET.getItemMeta();
            BUCKET_M.setDisplayName("§7Eimer");
            BUCKET.setItemMeta(BUCKET_M);

            ItemStack SHEARS = new ItemStack(Material.SHEARS);
            ItemMeta SHEARS_M = SHEARS.getItemMeta();
            SHEARS_M.setDisplayName("§7Schere");
            SHEARS.setItemMeta(SHEARS_M);


            Player p = (Player) e.getWhoClicked();
            Inventory inv = e.getInventory();
            if(e.getView().getTitle().equalsIgnoreCase("§8Meisterschmied")) {
                if(e.getRawSlot() < 54) {
                    e.setCancelled(true);
                    if(e.getClick().isLeftClick()) {

                        ItemStack gold1 = new ItemStack(Material.GOLD_NUGGET, 80);
                        ItemMeta img1 = gold1.getItemMeta();
                        img1.setDisplayName("§6Goldtaler");
                        gold1.setItemMeta(img1);
                        ItemStack gold2 = new ItemStack(Material.GOLD_NUGGET, 60);
                        ItemMeta img2 = gold2.getItemMeta();
                        img2.setDisplayName("§6Goldtaler");
                        gold2.setItemMeta(img2);
                        ItemStack gold3 = new ItemStack(Material.GOLD_NUGGET, 40);
                        ItemMeta img3 = gold3.getItemMeta();
                        img3.setDisplayName("§6Goldtaler");
                        gold3.setItemMeta(img3);
                        ItemStack gold4 = new ItemStack(Material.GOLD_NUGGET, 20);
                        ItemMeta img4 = gold4.getItemMeta();
                        img4.setDisplayName("§6Goldtaler");
                        gold4.setItemMeta(img4);


                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhelm")) {
                            if(p.getInventory().containsAtLeast(gold3, 1)) {
                                p.getInventory().addItem(Iron_helemt);
                                p.getInventory().removeItem(gold3);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenbrustplatte")) {

                            if(p.getInventory().containsAtLeast(gold1, 1)) {
                                p.getInventory().addItem(Iron_cheastplate);
                                p.getInventory().removeItem(gold1);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhose")) {
                            if(p.getInventory().containsAtLeast(gold2, 1)) {
                                p.getInventory().addItem(Iron_leggins);
                                p.getInventory().removeItem(gold2);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenstiefel")) {
                            if(p.getInventory().containsAtLeast(gold4, 1)) {
                                p.getInventory().addItem(Iron_boots);
                                p.getInventory().removeItem(gold4);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        }
                    } else if(e.getClick().isRightClick()) {
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhelm")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 5) && p.getInventory().containsAtLeast(new ItemStack(Material.LEATHER_HELMET), 1)) {
                                p.getInventory().addItem(Iron_helemt);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 5));
                                p.getInventory().removeItem(new ItemStack((Material.LEATHER_HELMET)));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenbrustplatte")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 8) && p.getInventory().containsAtLeast(new ItemStack(Material.LEATHER_CHESTPLATE), 1)) {
                                p.getInventory().addItem(Iron_cheastplate);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 8));
                                p.getInventory().removeItem(new ItemStack((Material.LEATHER_CHESTPLATE)));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhose")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 7) && p.getInventory().containsAtLeast(new ItemStack(Material.LEATHER_LEGGINGS), 1)) {
                                p.getInventory().addItem(Iron_leggins);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 7));
                                p.getInventory().removeItem(new ItemStack((Material.LEATHER_LEGGINGS)));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenstiefel")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 4) && p.getInventory().containsAtLeast(new ItemStack(Material.LEATHER_BOOTS), 1)) {
                                p.getInventory().addItem(Iron_boots);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 4));
                                p.getInventory().removeItem(new ItemStack((Material.LEATHER_BOOTS)));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        }
                    }
                }
            } else if(e.getView().getTitle().equalsIgnoreCase("§8Schmied")) {
                if(e.getRawSlot() < 36) {
                    e.setCancelled(true);
                    if(e.getClick().isLeftClick()) {

                        ItemStack gold1 = new ItemStack(Material.GOLD_NUGGET, 1);
                        ItemMeta img1 = gold1.getItemMeta();
                        img1.setDisplayName("§6Goldtaler");
                        gold1.setItemMeta(img1);
                        ItemStack gold2 = new ItemStack(Material.GOLD_NUGGET, 15);
                        ItemMeta img2 = gold2.getItemMeta();
                        img2.setDisplayName("§6Goldtaler");
                        gold2.setItemMeta(img2);
                        ItemStack gold3 = new ItemStack(Material.GOLD_NUGGET, 10);
                        ItemMeta img3 = gold3.getItemMeta();
                        img3.setDisplayName("§6Goldtaler");
                        gold3.setItemMeta(img3);
                        ItemStack gold5 = new ItemStack(Material.GOLD_NUGGET, 7);
                        ItemMeta img5 = gold5.getItemMeta();
                        img5.setDisplayName("§6Goldtaler");
                        gold5.setItemMeta(img5);
                        ItemStack gold6 = new ItemStack(Material.GOLD_NUGGET, 2);
                        ItemMeta img6 = gold6.getItemMeta();
                        img6.setDisplayName("§6Goldtaler");
                        gold6.setItemMeta(img6);
                        ItemStack gold = new ItemStack(Material.GOLD_NUGGET, 3);
                        ItemMeta img = gold.getItemMeta();
                        img.setDisplayName("§6Goldtaler");
                        gold.setItemMeta(img);
                        ItemStack gold4 = new ItemStack(Material.GOLD_NUGGET, 25);
                        ItemMeta img4 = gold4.getItemMeta();
                        img4.setDisplayName("§6Goldtaler");
                        gold4.setItemMeta(img4);


                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenschwert")) {
                            if(p.getInventory().containsAtLeast(gold1, 25)) {
                                p.getInventory().addItem(SWORD);
                                p.getInventory().removeItem(gold4);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenspitzhacke")) {

                            if(p.getInventory().containsAtLeast(gold2, 1)) {
                                p.getInventory().addItem(PICKAXE);
                                p.getInventory().removeItem(gold2);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenaxt")) {
                            if(p.getInventory().containsAtLeast(gold2, 1)) {
                                p.getInventory().addItem(AXE);
                                p.getInventory().removeItem(gold2);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenschaufel")) {
                            if(p.getInventory().containsAtLeast(gold5, 1)) {
                                p.getInventory().addItem(SHOVEL);
                                p.getInventory().removeItem(gold5);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhacke")) {
                            if(p.getInventory().containsAtLeast(gold3, 1)) {
                                p.getInventory().addItem(HOE);
                                p.getInventory().removeItem(gold3);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }
                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eimer")) {
                            if(p.getInventory().containsAtLeast(gold6, 1)) {
                                p.getInventory().addItem(BUCKET);
                                p.getInventory().removeItem(gold6);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schere")) {
                            if(p.getInventory().containsAtLeast(gold6, 1)) {
                                p.getInventory().addItem(SHEARS);
                                p.getInventory().removeItem(gold6);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getType() == Material.IRON_BARS) {
                            if(p.getInventory().containsAtLeast(gold, 1)) {
                                p.getInventory().addItem(new ItemStack(Material.IRON_BARS, 16));
                                p.getInventory().removeItem(gold);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        }
                    } else if(e.getClick().isRightClick()) {
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenschwert")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 2) && p.getInventory().containsAtLeast(new ItemStack(Material.STICK), 1)) {
                                p.getInventory().addItem(SWORD);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 2));
                                p.getInventory().removeItem(new ItemStack((Material.STICK)));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenspitzhacke")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 3) && p.getInventory().containsAtLeast(new ItemStack(Material.STICK), 2)) {
                                p.getInventory().addItem(PICKAXE);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 3));
                                p.getInventory().removeItem(new ItemStack((Material.STICK), 2));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenaxt")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 3) && p.getInventory().containsAtLeast(new ItemStack(Material.STICK), 2)) {
                                p.getInventory().addItem(AXE);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 3));
                                p.getInventory().removeItem(new ItemStack((Material.STICK), 2));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenschaufel")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 1) && p.getInventory().containsAtLeast(new ItemStack(Material.STICK), 2)) {
                                p.getInventory().addItem(SHOVEL);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 1));
                                p.getInventory().removeItem(new ItemStack((Material.STICK), 2));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenhacke")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_BLOCK), 2) && p.getInventory().containsAtLeast(new ItemStack(Material.STICK), 2)) {
                                p.getInventory().addItem(HOE);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_BLOCK), 2));
                                p.getInventory().removeItem(new ItemStack((Material.STICK), 2));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Eimer")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 3)) {
                                p.getInventory().addItem(BUCKET);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_INGOT), 3));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schere")) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 2)) {
                                p.getInventory().addItem(SHEARS);
                                p.getInventory().removeItem(new ItemStack((Material.IRON_INGOT), 2));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

                            }

                        } else if(e.getCurrentItem().getType() == Material.IRON_BARS) {
                            if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 6)) {
                                p.getInventory().addItem(new ItemStack(Material.IRON_BARS, 16));
                                p.getInventory().removeItem(new ItemStack((Material.IRON_INGOT), 6));
                            } else {
                                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 1, 1);

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
            try {
                if(v.getCustomName().equalsIgnoreCase("§7Meisterschmied")) {
                    e.setCancelled(true);
                } else if(v.getCustomName().equalsIgnoreCase("§7Schmied")) {
                    e.setCancelled(true);
                }
            } catch (NullPointerException ex) {
            }

        }
    }
}
