package de.rainbow.shops;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop_ItemBuilder {

    public static void buildInv54(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta iclose = close.getItemMeta();
        iclose.setDisplayName("§cSchließen");
        close.setItemMeta(iclose);
        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(45, b_glass);
        inv.setItem(46, b_glass);
        inv.setItem(47, b_glass);
        inv.setItem(48, b_glass);
        inv.setItem(49, close);
        inv.setItem(50, b_glass);
        inv.setItem(51, b_glass);
        inv.setItem(52, b_glass);
        inv.setItem(53, b_glass);
    }

    public static void buildInv45(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta iclose = close.getItemMeta();
        iclose.setDisplayName("§cSchließen");
        close.setItemMeta(iclose);
        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(36, b_glass);
        inv.setItem(37, b_glass);
        inv.setItem(38, b_glass);
        inv.setItem(39, b_glass);
        inv.setItem(40, close);
        inv.setItem(41, b_glass);
        inv.setItem(42, b_glass);
        inv.setItem(43, b_glass);
        inv.setItem(44, b_glass);
    }

    public static void buildInv36(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta iclose = close.getItemMeta();
        iclose.setDisplayName("§cSchließen");
        close.setItemMeta(iclose);
        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(27, b_glass);
        inv.setItem(28, b_glass);
        inv.setItem(29, b_glass);
        inv.setItem(30, b_glass);
        inv.setItem(31, close);
        inv.setItem(32, b_glass);
        inv.setItem(33, b_glass);
        inv.setItem(34, b_glass);
        inv.setItem(35, b_glass);
    }

    public static void addGold(Inventory inv, int amount) {
        ItemStack SWEET_BERRIES = new ItemStack(Material.GOLD_NUGGET, amount);
        ItemMeta img = SWEET_BERRIES.getItemMeta();
        img.setDisplayName("§6Goldtaler");
        SWEET_BERRIES.setItemMeta(img);
        inv.addItem(SWEET_BERRIES);
    }

    public static void setGold(Inventory inv, int amount, int slot) {
        ItemStack SWEET_BERRIES = new ItemStack(Material.GOLD_NUGGET, amount);
        ItemMeta img = SWEET_BERRIES.getItemMeta();
        img.setDisplayName("§6Goldtaler");
        SWEET_BERRIES.setItemMeta(img);
        inv.setItem(slot, SWEET_BERRIES);
    }

    public static void buildVillagerHome(Inventory inv) {
        ItemStack b_glass = new     ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta iclose = close.getItemMeta();
        iclose.setDisplayName("§cSchließen");
        close.setItemMeta(iclose);

        ItemStack EssenVerkauf = new ItemStack(Material.BREAD);
        ItemMeta iEssenVerkauf = EssenVerkauf.getItemMeta();
        iEssenVerkauf.setDisplayName("§aEssen verkaufen");
        EssenVerkauf.setItemMeta(iEssenVerkauf);

        ItemStack Verkaufen = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta iVerkaufen = Verkaufen.getItemMeta();
        iVerkaufen.setDisplayName("§aVerkaufen");
        Verkaufen.setItemMeta(iVerkaufen);

        ItemStack Kaufen = new ItemStack(Material.CHEST);
        ItemMeta iKaufen = Kaufen.getItemMeta();
        iKaufen.setDisplayName("§aKaufen");
        Kaufen.setItemMeta(iKaufen);

        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(18, b_glass);
        inv.setItem(19, b_glass);
        inv.setItem(20, b_glass);
        inv.setItem(21, b_glass);
        inv.setItem(22, close);
        inv.setItem(23, b_glass);
        inv.setItem(24, b_glass);
        inv.setItem(25, b_glass);
        inv.setItem(26, b_glass);

        inv.setItem(9, b_glass);
        inv.setItem(10, Verkaufen);
        inv.setItem(11, b_glass);
        inv.setItem(12, b_glass);
        inv.setItem(13, Kaufen);
        inv.setItem(14, b_glass);
        inv.setItem(15, b_glass);
        inv.setItem(16, EssenVerkauf);
        inv.setItem(17, b_glass);
    }

    public static void buildInv27wSell(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack verkauf = new ItemStack(Material.BREAD);
        ItemMeta iverkauf = verkauf.getItemMeta();
        iverkauf.setDisplayName("§aVerkaufen");
        verkauf.setItemMeta(iverkauf);


        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(18, verkauf);
        inv.setItem(19, b_glass);
        inv.setItem(20, b_glass);
        inv.setItem(21, b_glass);
        inv.setItem(22, b_glass);
        inv.setItem(23, b_glass);
        inv.setItem(24, b_glass);
        inv.setItem(25, b_glass);
        inv.setItem(26, b_glass);
    }
    
    public static void buildInv27(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta iclose = close.getItemMeta();
        iclose.setDisplayName("§cSchließen");
        close.setItemMeta(iclose);


        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(18, b_glass);
        inv.setItem(19, b_glass);
        inv.setItem(20, b_glass);
        inv.setItem(21, b_glass);
        inv.setItem(22, close);
        inv.setItem(23, b_glass);
        inv.setItem(24, b_glass);
        inv.setItem(25, b_glass);
        inv.setItem(26, b_glass);
    }

    public static void buildJeager(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack ROTTEN_FLASH = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta ROTTEN_FLASH_M = ROTTEN_FLASH.getItemMeta();
        ROTTEN_FLASH_M.setDisplayName("§7Verrotetes Fleisch");
        ArrayList<String> ROTTEN_FLASH_L = new ArrayList<>();
        ROTTEN_FLASH_L.add("");
        ROTTEN_FLASH_L.add(" §7Linksklick -> Kaufen");
        ROTTEN_FLASH_L.add("  §7Preis: 16x §6" + Shop_Objekte.ROTTEN_FLESH.getSellprice() +" SWEET_BERRIES   ");
        ROTTEN_FLASH_M.setLore(ROTTEN_FLASH_L);
        ROTTEN_FLASH.setItemMeta(ROTTEN_FLASH_M);
        ItemStack SLIME_BALL = new ItemStack(Material.SLIME_BALL);
        ItemMeta SLIME_BALL_M = SLIME_BALL.getItemMeta();
        SLIME_BALL_M.setDisplayName("§7Schmleimball");
        ArrayList<String> SLIME_BALL_L = new ArrayList<>();
        SLIME_BALL_L.add("");
        SLIME_BALL_L.add(" §7Linksklick -> Kaufen");
        SLIME_BALL_L.add("  §7Preis: 1x §6" + Shop_Objekte.SLIME_BALL.getSellprice() +" SWEET_BERRIES   ");
        SLIME_BALL_M.setLore(SLIME_BALL_L);
        SLIME_BALL.setItemMeta(SLIME_BALL_M);
        ItemStack BONE = new ItemStack(Material.BONE);
        ItemMeta BONE_M = BONE.getItemMeta();
        BONE_M.setDisplayName("§7Knochen");
        ArrayList<String> BONE_L = new ArrayList<>();
        BONE_L.add("");
        BONE_L.add(" §7Linksklick -> Kaufen");
        BONE_L.add("  §7Preis: 16x §6" + Shop_Objekte.BONE.getSellprice() +" SWEET_BERRIES   ");
        BONE_M.setLore(BONE_L);
        BONE.setItemMeta(BONE_M);
        ItemStack STRING = new ItemStack(Material.STRING);
        ItemMeta STRING_M = STRING.getItemMeta();
        STRING_M.setDisplayName("§7Faden");
        ArrayList<String> STRING_L = new ArrayList<>();
        STRING_L.add("");
        STRING_L.add(" §7Linksklick -> Kaufen");
        STRING_L.add("  §7Preis: 16x §6" + Shop_Objekte.STRING.getSellprice() +" SWEET_BERRIES   ");
        STRING_M.setLore(STRING_L);
        STRING.setItemMeta(STRING_M);
        ItemStack SUGAR_CANE = new ItemStack(Material.SUGAR_CANE);
        ItemMeta SUGAR_CANE_M = SUGAR_CANE.getItemMeta();
        SUGAR_CANE_M.setDisplayName("§7Zuckerrohr");
        ArrayList<String> SUGAR_CANE_L = new ArrayList<>();
        SUGAR_CANE_L.add("");
        SUGAR_CANE_L.add(" §7Linksklick -> Kaufen");
        SUGAR_CANE_L.add("  §7Preis: 16x §6" + Shop_Objekte.SUGAR_CANE.getSellprice() +" SWEET_BERRIES   ");
        SUGAR_CANE_M.setLore(SUGAR_CANE_L);
        SUGAR_CANE.setItemMeta(SUGAR_CANE_M);
        ItemStack BAMBOO = new ItemStack(Material.BAMBOO);
        ItemMeta BAMBOO_M = BAMBOO.getItemMeta();
        BAMBOO_M.setDisplayName("§7Bambus");
        ArrayList<String> BAMBOO_L = new ArrayList<>();
        BAMBOO_L.add("");
        BAMBOO_L.add(" §7Linksklick -> Kaufen");
        BAMBOO_L.add("  §7Preis: 16x §6" + Shop_Objekte.BAMBOO.getSellprice() +" SWEET_BERRIES   ");
        BAMBOO_M.setLore(BAMBOO_L);
        BAMBOO.setItemMeta(BAMBOO_M);
        ItemStack SWEET_BERRIES = new ItemStack(Material.SWEET_BERRIES);
        ItemMeta SWEET_BERRIES_M = SWEET_BERRIES.getItemMeta();
        SWEET_BERRIES_M.setDisplayName("§7Süßebeere");
        ArrayList<String> SWEET_BERRIES_L = new ArrayList<>();
        SWEET_BERRIES_L.add("");
        SWEET_BERRIES_L.add(" §7Linksklick -> Kaufen");
        SWEET_BERRIES_L.add("  §7Preis: 16x §6" + Shop_Objekte.SWEET_BERRIES.getSellprice() +" SWEET_BERRIES   ");
        SWEET_BERRIES_M.setLore(SWEET_BERRIES_L);
        SWEET_BERRIES.setItemMeta(SWEET_BERRIES_M);

        inv.setItem(9, b_glass);
        inv.setItem(10, BONE);
        inv.setItem(11, STRING);
        inv.setItem(12, SLIME_BALL);
        inv.setItem(13, ROTTEN_FLASH);
        inv.setItem(14, SUGAR_CANE);
        inv.setItem(15, BAMBOO);
        inv.setItem(16, SWEET_BERRIES);
        inv.setItem(17, b_glass);
    }


    public static void buildEssenAnkauf(Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack zurueck = new ItemStack(Material.BARRIER);
        ItemMeta izurueck = zurueck.getItemMeta();
        izurueck.setDisplayName("§cZurück");
        zurueck.setItemMeta(izurueck);

        ItemStack APPLE = new ItemStack(Material.APPLE);
        ItemMeta APPLE_M = APPLE.getItemMeta();
        APPLE_M.setDisplayName("§7Äpfel");
        ArrayList<String> APPLE_L = new ArrayList<>();
        APPLE_L.add("");
        APPLE_L.add("§7Linksklick -> Verkaufen");
        APPLE_L.add("§7Preis: 8x §6" + Shop_Objekte.APPLE.getSellprice() +" Goldtaler");
        APPLE_M.setLore(APPLE_L);
        APPLE.setItemMeta(APPLE_M);

        ItemStack BAKED_POTATO = new ItemStack(Material.BAKED_POTATO);
        ItemMeta BAKED_POTATO_M = BAKED_POTATO.getItemMeta();
        BAKED_POTATO_M.setDisplayName("§7Bratkartoffeln");
        ArrayList<String> BAKED_POTATO_L = new ArrayList<>();
        BAKED_POTATO_L.add("");
        BAKED_POTATO_L.add("§7Linksklick -> Verkaufen");
        BAKED_POTATO_L.add("§7Preis: 16x §6" + Shop_Objekte.BAKED_POTATO.getSellprice() +" Goldtaler");
        BAKED_POTATO_M.setLore(BAKED_POTATO_L);
        BAKED_POTATO.setItemMeta(BAKED_POTATO_M);

        ItemStack CAKE = new ItemStack(Material.CAKE);
        ItemMeta CAKE_M = CAKE.getItemMeta();
        CAKE_M.setDisplayName("§7Kuchen");
        ArrayList<String> CAKE_L = new ArrayList<>();
        CAKE_L.add("");
        CAKE_L.add("§7Linksklick -> Verkaufen");
        CAKE_L.add("§7Preis: 1x §6" + Shop_Objekte.CAKE.getSellprice() +" Goldtaler");
        CAKE_M.setLore(CAKE_L);
        CAKE.setItemMeta(CAKE_M);

        ItemStack COOKED_MUTTON = new ItemStack(Material.COOKED_MUTTON);
        ItemMeta COOKED_MUTTON_M = COOKED_MUTTON.getItemMeta();
        COOKED_MUTTON_M.setDisplayName("§7Gebratenes Schafsfleisch");
        ArrayList<String> COOKED_MUTTON_L = new ArrayList<>();
        COOKED_MUTTON_L.add("");
        COOKED_MUTTON_L.add("§7Linksklick -> Verkaufen");
        COOKED_MUTTON_L.add("§7Preis: 32x §6" + Shop_Objekte.COOKED_MUTTON.getSellprice() +" Goldtaler");
        COOKED_MUTTON_M.setLore(COOKED_MUTTON_L);
        COOKED_MUTTON.setItemMeta(COOKED_MUTTON_M);

        ItemStack COOKED_BEEF = new ItemStack(Material.COOKED_BEEF);
        ItemMeta COOKED_BEEF_M = COOKED_BEEF.getItemMeta();
        COOKED_BEEF_M.setDisplayName("§7Steak");
        ArrayList<String> COOKED_BEEF_L = new ArrayList<>();
        COOKED_BEEF_L.add("");
        COOKED_BEEF_L.add("§7Linksklick -> Verkaufen");
        COOKED_BEEF_L.add("§7Preis: 32x §6" + Shop_Objekte.COOKED_BEEF.getSellprice() +" Goldtaler");
        COOKED_BEEF_M.setLore(COOKED_BEEF_L);
        COOKED_BEEF.setItemMeta(COOKED_BEEF_M);

        ItemStack COOKED_CHICKEN = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta COOKED_CHICKEN_M = COOKED_CHICKEN.getItemMeta();
        COOKED_CHICKEN_M.setDisplayName("§7Gebratenes Hühnchen");
        ArrayList<String> COOKED_CHICKEN_L = new ArrayList<>();
        COOKED_CHICKEN_L.add("");
        COOKED_CHICKEN_L.add("§7Linksklick -> Verkaufen");
        COOKED_CHICKEN_L.add("§7Preis: 32x §6" + Shop_Objekte.COOKED_CHICKEN.getSellprice() +" Goldtaler");
        COOKED_CHICKEN_M.setLore(COOKED_CHICKEN_L);
        COOKED_CHICKEN.setItemMeta(COOKED_CHICKEN_M);

        ItemStack COOKED_PORKCHOP = new ItemStack(Material.COOKED_PORKCHOP);
        ItemMeta COOKED_PORKCHOP_M = COOKED_PORKCHOP.getItemMeta();
        COOKED_PORKCHOP_M.setDisplayName("§7Gebratenes Schweinefleisch");
        ArrayList<String> COOKED_PORKCHOP_L = new ArrayList<>();
        COOKED_PORKCHOP_L.add("");
        COOKED_PORKCHOP_L.add("§7Linksklick -> Verkaufen");
        COOKED_PORKCHOP_L.add("§7Preis: 32x §6" + Shop_Objekte.COOKED_PORKCHOP.getSellprice() +" Goldtaler");
        COOKED_PORKCHOP_M.setLore(COOKED_PORKCHOP_L);
        COOKED_PORKCHOP.setItemMeta(COOKED_PORKCHOP_M);

        inv.setItem(0, b_glass);
        inv.setItem(1, b_glass);
        inv.setItem(2, b_glass);
        inv.setItem(3, b_glass);
        inv.setItem(4, b_glass);
        inv.setItem(5, b_glass);
        inv.setItem(6, b_glass);
        inv.setItem(7, b_glass);
        inv.setItem(8, b_glass);

        inv.setItem(18, b_glass);
        inv.setItem(19, b_glass);
        inv.setItem(20, b_glass);
        inv.setItem(21, b_glass);
        inv.setItem(22, zurueck);
        inv.setItem(23, b_glass);
        inv.setItem(24, b_glass);
        inv.setItem(25, b_glass);
        inv.setItem(26, b_glass);

        inv.setItem(9, b_glass);
        inv.setItem(10, APPLE);
        inv.setItem(11, BAKED_POTATO);
        inv.setItem(12, CAKE);
        inv.setItem(13, COOKED_MUTTON);
        inv.setItem(14, COOKED_BEEF);
        inv.setItem(15, COOKED_CHICKEN);
        inv.setItem(16, COOKED_PORKCHOP);
        inv.setItem(17, b_glass);
    }

    public static void buildHolzfaeller (Inventory inv) {
        ItemStack b_glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack zurueck = new ItemStack(Material.BARRIER);
        ItemMeta izurueck = zurueck.getItemMeta();
        izurueck.setDisplayName("§cZurück");
        zurueck.setItemMeta(izurueck);

        ItemStack OAK_LOG = new ItemStack(Material.OAK_LOG);
        ItemMeta OAK_LOG_M = OAK_LOG.getItemMeta();
        OAK_LOG_M.setDisplayName("§7Eichenstamm");
        ArrayList<String> OAK_LOG_L = new ArrayList<>();
        OAK_LOG_L.add("");
        OAK_LOG_L.add("§7Linksklick -> Kaufen");
        OAK_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.OAK_LOG.getSellprice() +" Goldtaler");
        OAK_LOG_M.setLore(OAK_LOG_L);
        OAK_LOG.setItemMeta(OAK_LOG_M);

        ItemStack SPRUCE_LOG = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta SPRUCE_LOG_M = SPRUCE_LOG.getItemMeta();
        SPRUCE_LOG_M.setDisplayName("§7Fichtenstamm");
        ArrayList<String> SPRUCE_LOG_L = new ArrayList<>();
        SPRUCE_LOG_L.add("");
        SPRUCE_LOG_L.add("§7Linksklick -> Kaufen");
        SPRUCE_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.SPRUCE_LOG.getSellprice() +" Goldtaler");
        SPRUCE_LOG_M.setLore(SPRUCE_LOG_L);
        SPRUCE_LOG.setItemMeta(SPRUCE_LOG_M);

        ItemStack BIRCH_LOG = new ItemStack(Material.BIRCH_LOG);
        ItemMeta BIRCH_LOG_M = BIRCH_LOG.getItemMeta();
        SPRUCE_LOG_M.setDisplayName("§7tBirkenstamm");
        ArrayList<String> BIRCH_LOG_L = new ArrayList<>();
        BIRCH_LOG_L.add("");
        BIRCH_LOG_L.add("§7Linksklick -> Kaufen");
        BIRCH_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.BIRCH_LOG.getSellprice() +" Goldtaler");
        BIRCH_LOG_M.setLore(BIRCH_LOG_L);
        BIRCH_LOG.setItemMeta(BIRCH_LOG_M);

        ItemStack JUNGLE_LOG = new ItemStack(Material.JUNGLE_LOG);
        ItemMeta JUNGLE_LOG_M = JUNGLE_LOG.getItemMeta();
        JUNGLE_LOG_M.setDisplayName("§7Tropenstamm");
        ArrayList<String> JUNGLE_LOG_L = new ArrayList<>();
        JUNGLE_LOG_L.add("");
        JUNGLE_LOG_L.add("§7Linksklick -> Kaufen");
        JUNGLE_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.JUNGLE_LOG.getSellprice() +" Goldtaler");
        JUNGLE_LOG_M.setLore(JUNGLE_LOG_L);
        JUNGLE_LOG.setItemMeta(JUNGLE_LOG_M);

        ItemStack ACACIA_LOG = new ItemStack(Material.ACACIA_LOG);
        ItemMeta ACACIA_LOG_M = ACACIA_LOG.getItemMeta();
        ACACIA_LOG_M.setDisplayName("§7Akazienstamm");
        ArrayList<String> ACACIA_LOG_L = new ArrayList<>();
        ACACIA_LOG_L.add("");
        ACACIA_LOG_L.add("§7Linksklick -> Kaufen");
        ACACIA_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.ACACIA_LOG.getSellprice() +" Goldtaler");
        ACACIA_LOG_M.setLore(ACACIA_LOG_L);
        ACACIA_LOG.setItemMeta(ACACIA_LOG_M);

        ItemStack DARK_OAK_LOG = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta DARK_OAK_LOG_M = DARK_OAK_LOG.getItemMeta();
        DARK_OAK_LOG_M.setDisplayName("§7Fichtenstamm");
        ArrayList<String> DARK_OAK_LOG_L = new ArrayList<>();
        DARK_OAK_LOG_L.add("");
        DARK_OAK_LOG_L.add("§7Linksklick -> Kaufen");
        DARK_OAK_LOG_L.add("§7Preis: 16x §6" + Shop_Objekte.DARK_OAK_LOG.getSellprice() +" Goldtaler");
        DARK_OAK_LOG_M.setLore(DARK_OAK_LOG_L);
        DARK_OAK_LOG.setItemMeta(DARK_OAK_LOG_M);

        inv.setItem(9, b_glass);
        inv.setItem(10, OAK_LOG);
        inv.setItem(11, SPRUCE_LOG);
        inv.setItem(12, BIRCH_LOG);
        inv.setItem(13, b_glass);
        inv.setItem(14, JUNGLE_LOG);
        inv.setItem(15, ACACIA_LOG);
        inv.setItem(16, DARK_OAK_LOG);
        inv.setItem(17, b_glass);
    }
}
