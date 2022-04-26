package com.aspectx.fixmc.fixmcshopgui.inventories;

import com.aspectx.fixmc.fixmcshopgui.FixmcShopGui;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import static com.aspectx.fixmc.fixmcshopgui.itemManager.Items.noItem;

public class categoryGui implements InventoryHolder {
    FixmcShopGui fixmcShopGui = new FixmcShopGui();
    FileConfiguration config = fixmcShopGui.getConfig();
    public Inventory inv;

    public categoryGui(String Category) {
        inv = Bukkit.createInventory(this, 54, Category + "Shop");
        init(Category);
    }

    private void init(String Category) {
        inv.setItem(1, noItem);
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
