package de.rainbow.shops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop_Objekte_test {

    public enum Shop_Objects {

        COBBLESTONE(new ItemStack(Material.COBBLESTONE, 32));

        ItemStack im;

        private Shop_Objects(ItemStack im1) {
            this.im = im1;
        }
    }

    public void objekte() {
        ItemStack cobble = new ItemStack(Material.COBBLESTONE);
        ItemStack diorite = new ItemStack(Material.DIORITE);
        ItemStack andesite = new ItemStack(Material.ANDESITE);
        ItemStack stone = new ItemStack(Material.STONE);
        ItemStack granite = new ItemStack(Material.GRANITE);

        ItemStack cobble32 = new ItemStack(Material.COBBLESTONE, 32);
        ItemStack diorite32 = new ItemStack(Material.DIORITE, 32);
        ItemStack andesite32 = new ItemStack(Material.ANDESITE, 32);
        ItemStack stone32 = new ItemStack(Material.STONE, 32);
        ItemStack granite32 = new ItemStack(Material.GRANITE, 32);

        ItemStack apple = new ItemStack(Material.APPLE);
        ItemStack chicken = new ItemStack(Material.COOKED_CHICKEN);
        ItemStack beef = new ItemStack(Material.COOKED_BEEF);
        ItemStack porkchop = new ItemStack(Material.COOKED_PORKCHOP);
        ItemStack mutton = new ItemStack(Material.COOKED_MUTTON);

        ItemStack apple8 = new ItemStack(Material.APPLE, 8);
        ItemStack chicken32 = new ItemStack(Material.COOKED_CHICKEN, 32);
        ItemStack beef32 = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack porkchop32 = new ItemStack(Material.COOKED_PORKCHOP, 32);
        ItemStack mutton32 = new ItemStack(Material.COOKED_MUTTON, 32);

        ItemStack stonest = new ItemStack(Material.STONE_STAIRS);
        ItemStack cobblest = new ItemStack(Material.COBBLESTONE_STAIRS);
        ItemStack dioritest = new ItemStack(Material.DIORITE_STAIRS);
        ItemStack andesitest = new ItemStack(Material.ANDESITE_STAIRS);
        ItemStack granitest = new ItemStack(Material.GRANITE_STAIRS);

        ItemStack stonest16 = new ItemStack(Material.STONE_STAIRS, 16);
        ItemStack cobblest16 = new ItemStack(Material.COBBLESTONE_STAIRS, 16);
        ItemStack dioritest16 = new ItemStack(Material.DIORITE_STAIRS, 16);
        ItemStack andesitest16 = new ItemStack(Material.ANDESITE_STAIRS, 16);
        ItemStack granitest16 = new ItemStack(Material.GRANITE_STAIRS, 16);
    }

    public void nuggets() {
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
    }
}
