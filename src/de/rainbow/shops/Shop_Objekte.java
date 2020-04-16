package de.rainbow.shops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Shop_Objekte {

    COBBLESTONE(new ItemStack(Material.COBBLESTONE, 32), 2, 1),
    COBBLESTONE_STAIRS(new ItemStack(Material.COBBLESTONE_STAIRS, 16), 2, 1),
    COBBLESTONE_SLAB(new ItemStack(Material.COBBLESTONE_SLAB, 16), 2, 1),
    COBBLESTONE_WALL(new ItemStack(Material.COBBLESTONE_WALL, 16), 2, 1),

    STONE(new ItemStack(Material.STONE, 32), 2, 1),
    STONE_STAIRS(new ItemStack(Material.STONE_STAIRS, 16), 2, 1),
    STONE_SLAB(new ItemStack(Material.STONE_SLAB, 16), 2, 1),

    DIORITE(new ItemStack(Material.DIORITE, 32), 2, 1),
    DIORITE_STAIRS(new ItemStack(Material.DIORITE_STAIRS, 16), 2, 1),
    DIORITE_SLAB(new ItemStack(Material.DIORITE_SLAB, 16), 2, 1),
    DIORITE_WALL(new ItemStack(Material.DIORITE_WALL, 16), 2, 1),

    ANDESITE(new ItemStack(Material.ANDESITE, 32), 2, 1),
    ANDESITE_STAIRS(new ItemStack(Material.ANDESITE_STAIRS, 16), 2, 1),
    ANDESITE_SLAB(new ItemStack(Material.ANDESITE_SLAB, 16), 2, 1),
    ANDESITE_WALL(new ItemStack(Material.ANDESITE_WALL, 16), 2, 1),

    GRANITE(new ItemStack(Material.GRANITE, 32), 2, 1),
    GRANITE_STAIRS(new ItemStack(Material.GRANITE_STAIRS, 16), 2, 1),
    GRANITE_SLAB(new ItemStack(Material.GRANITE_SLAB, 16), 2, 1),
    GRANITE_WALL(new ItemStack(Material.GRANITE_WALL, 16), 2, 1),

    ROTTEN_FLESH(new ItemStack(Material.ROTTEN_FLESH, 16), 1, 1),
    SPIDER_EYE(new ItemStack(Material.SPIDER_EYE, 1), 1, 1),
    BONE(new ItemStack(Material.BONE, 16), 1, 1),
    SLIME_BALL(new ItemStack(Material.SLIME_BALL, 1), 4, 4),

    STRING(new ItemStack(Material.STRING, 16), 1, 1),
    GUNPOWDER(new ItemStack(Material.GUNPOWDER, 1), 15, 15),
    ENDER_PEARL(new ItemStack(Material.ENDER_PEARL, 1), 10, 10),
    ARROW(new ItemStack(Material.ARROW, 16), 2, 2),

    OAK_LEAVES(new ItemStack(Material.OAK_LEAVES, 64), 2, 2),

    IRON_SWORD(new ItemStack(Material.IRON_SWORD, 1), 25, 4),
    IRON_PICKAXE(new ItemStack(Material.IRON_PICKAXE, 1), 25, 25),
    IRON_AXE(new ItemStack(Material.IRON_AXE, 1), 25, 25),
    IRON_SHOVEL(new ItemStack(Material.IRON_SHOVEL, 16), 5, 5),

    OAK_LOG(new ItemStack(Material.OAK_LOG, 16), 1, 1),
    SPRUCE_LOG(new ItemStack(Material.SPRUCE_LOG, 16), 1,1),
    BIRCH_LOG(new ItemStack(Material.BIRCH_LOG), 16, 1),
    JUNGLE_LOG(new ItemStack(Material.JUNGLE_LOG, 16), 1,1),
    ACACIA_LOG(new ItemStack(Material.ACACIA_LOG,16),1,1),
    DARK_OAK_LOG(new ItemStack(Material.DARK_OAK_LOG,16),1,1),

    //***************************************

    RABBIT_FOOT(new ItemStack(Material.RABBIT_FOOT, 1), 1, 1),
    SUGAR_CANE(new ItemStack(Material.SUGAR_CANE, 16), 2, 2),
    SWEET_BERRIES(new ItemStack(Material.SWEET_BERRIES, 16), 2, 2),
    BAMBOO(new ItemStack(Material.BAMBOO, 16), 1, 1),
    BAKED_POTATO(new ItemStack(Material.BAKED_POTATO, 16), 1, 1),
    CAKE(new ItemStack(Material.CAKE, 1), 2, 2),

    //*************************************

    APPLE(new ItemStack(Material.APPLE, 8), 2, 2),
    COOKED_CHICKEN(new ItemStack(Material.COOKED_CHICKEN, 32), 3, 3),
    COOKED_BEEF(new ItemStack(Material.COOKED_BEEF, 32), 3, 3),
    COOKED_PORKCHOP(new ItemStack(Material.COOKED_PORKCHOP, 32), 3, 3),
    COOKED_MUTTON(new ItemStack(Material.COOKED_MUTTON, 32), 3, 3);


    ItemStack material;
    int buyprice;
    int sellprice;

    private Shop_Objekte(ItemStack material, int buyprice, int sellprice) {
        this.material = material;
        this .buyprice = buyprice;
        this.sellprice = sellprice;
    }

    public ItemStack getMaterial() {
        return material;
    }

    public int getBuyprice() {
        return buyprice;
    }

    public int getSellprice() {
        return sellprice;
    }
}
