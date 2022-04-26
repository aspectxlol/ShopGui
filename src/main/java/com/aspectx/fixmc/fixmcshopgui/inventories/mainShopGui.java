package com.aspectx.fixmc.fixmcshopgui.inventories;

import com.aspectx.fixmc.fixmcshopgui.itemManager.FixItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

import static com.aspectx.fixmc.fixmcshopgui.itemManager.Items.*;

public class mainShopGui implements InventoryHolder{
    public static Inventory inv;

    public mainShopGui() {
        inv = Bukkit.createInventory(this, 27, "Fix MC Shop Gui");
        init();
    }

    private void init() {
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, noItem);
        }
        inv.setItem(9, noItem);
        inv.setItem(10, BlocksCategory);
        inv.setItem(11, FoodCategory);
        inv.setItem(12, ValuablesCategory);
        inv.setItem(13, PvpCategory);
        inv.setItem(14, PotionsCategory);
        inv.setItem(15, MobDropsCategory);
        inv.setItem(16, SpawnersCategory);
        inv.setItem(17, noItem);
        for (int i = 18; i < 27; i++) {
            inv.setItem(i, noItem);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
