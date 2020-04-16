package de.rainbow.manager;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Event_onCraft implements Listener {



    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        try {
            Material itemType = e.getRecipe().getResult().getType();
            Byte itemData = e.getRecipe().getResult().getData().getData();
            if (itemType == Material.DIAMOND_HELMET || itemType == Material.DIAMOND_CHESTPLATE || itemType == Material.DIAMOND_LEGGINGS || itemType == Material.DIAMOND_BOOTS || itemType == Material.DIAMOND_SWORD || itemType == Material.DIAMOND_BLOCK || itemType == Material.IRON_CHESTPLATE || itemType == Material.IRON_BOOTS || itemType == Material.IRON_HELMET || itemType == Material.IRON_LEGGINGS || itemType == Material.IRON_SWORD || itemType == Material.ENCHANTING_TABLE || itemType == Material.POLISHED_ANDESITE || itemType == Material.POLISHED_ANDESITE_SLAB || itemType == Material.POLISHED_ANDESITE_STAIRS || itemType == Material.POLISHED_DIORITE || itemType == Material.POLISHED_DIORITE_SLAB || itemType == Material.POLISHED_DIORITE_STAIRS || itemType == Material.POLISHED_GRANITE || itemType == Material.POLISHED_GRANITE_SLAB || itemType == Material.POLISHED_GRANITE_STAIRS
                    || itemType == Material.ANDESITE_SLAB || itemType == Material.ANDESITE_STAIRS || itemType == Material.STONE_STAIRS || itemType == Material.STONE_SLAB || itemType == Material.COBBLESTONE_SLAB || itemType == Material.COBBLESTONE_STAIRS || itemType == Material.DIORITE_SLAB || itemType == Material.DIORITE_STAIRS || itemType == Material.GRANITE_SLAB || itemType == Material.GRANITE_STAIRS || itemType == Material.IRON_PICKAXE || itemType == Material.IRON_AXE || itemType == Material.IRON_BARS || itemType == Material.IRON_HOE || itemType == Material.IRON_SHOVEL || itemType == Material.SHEARS || itemType == Material.BUCKET || itemType == Material.GOLD_NUGGET ) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
            }
        } catch (NullPointerException ex) {

        }
    }
}
