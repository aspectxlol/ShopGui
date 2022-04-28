package com.aspectx.fixmc.fixmcshopgui.inventories;

import com.aspectx.fixmc.fixmcshopgui.FixmcShopGui;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import static com.aspectx.fixmc.fixmcshopgui.itemManager.Items.noItem;

public class categoryGui implements InventoryHolder {
    private FixmcShopGui fixmcShopGui;
    FileConfiguration config;
    public Inventory inv;

    public categoryGui(String Category, FixmcShopGui fixmc) {
        this.fixmcShopGui = fixmc;
        this.config = fixmc.getConfig();
        inv = Bukkit.createInventory(this, 54, Category + "Shop");
        init(Category);
    }

    private void init(String Category) {
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, noItem);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
