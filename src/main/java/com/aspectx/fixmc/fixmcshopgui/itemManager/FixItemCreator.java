package com.aspectx.fixmc.fixmcshopgui.itemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class FixItemCreator {

    public static ItemStack FixItemCreator(String Name, Material Material, int Amount, List<String> lore) {
        ItemStack item = new ItemStack(Material, Amount);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Name);
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
    }
}
