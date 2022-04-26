package com.aspectx.fixmc.fixmcshopgui.itemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class Items {
    public static ItemStack noItem = FixItemCreator.FixItemCreator("", Material.GRAY_STAINED_GLASS_PANE, 1, Collections.singletonList(""));

    public static ItemStack BlocksCategory = FixItemCreator.FixItemCreator("§1§lBlocks", Material.GRASS_BLOCK, 1, Collections.singletonList(""));
    public static ItemStack FoodCategory = FixItemCreator.FixItemCreator("§2§lFood", Material.COOKED_BEEF, 1, Collections.singletonList(""));
    public static ItemStack ValuablesCategory = FixItemCreator.FixItemCreator("§3§lValuables", Material.DIAMOND, 1, Collections.singletonList(""));
    public static ItemStack PvpCategory = FixItemCreator.FixItemCreator("§4§lPvp", Material.NETHERITE_SWORD, 1, Collections.singletonList(""));
    public static ItemStack PotionsCategory = FixItemCreator.FixItemCreator("§5§lPotions", Material.POTION, 1, Collections.singletonList(""));
    public static ItemStack MobDropsCategory = FixItemCreator.FixItemCreator("§6§lMob Drops", Material.GUNPOWDER, 1, Collections.singletonList(""));
    public static ItemStack SpawnersCategory = FixItemCreator.FixItemCreator("§7§lSpawners", Material.SPAWNER, 1, Collections.singletonList(""));

}
