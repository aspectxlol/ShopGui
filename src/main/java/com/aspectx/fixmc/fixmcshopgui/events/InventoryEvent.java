package com.aspectx.fixmc.fixmcshopgui.events;

import com.aspectx.fixmc.fixmcshopgui.inventories.categoryGui;
import com.aspectx.fixmc.fixmcshopgui.inventories.mainShopGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import static com.aspectx.fixmc.fixmcshopgui.itemManager.Items.*;

public class InventoryEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        e.getWhoClicked().sendMessage("a");
        if (e.getClickedInventory() == null) { return; }
        if (e.getClickedInventory().getHolder() instanceof mainShopGui) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            player.sendMessage("aA");
            if (e.getCurrentItem() == null) { return; }

            if(e.getSlot() == 10) {
                categoryGui category = new categoryGui("Blocks");
                player.openInventory(category.getInventory());
                player.sendMessage("aB");
            } else if(e.getSlot() == 11) {
                categoryGui category = new categoryGui("Foods");
                player.openInventory(category.getInventory());
            } else if(e.getSlot() == 12) {
                categoryGui category = new categoryGui("Valuables");
                player.openInventory(category.getInventory());
            } else if(e.getSlot() == 13) {
                categoryGui category = new categoryGui("Pvp");
                player.openInventory(category.getInventory());
            } else if(e.getSlot() == 14) {
                categoryGui category = new categoryGui("Potion");
                player.openInventory(category.getInventory());
            } else if(e.getSlot() == 15) {
                categoryGui category = new categoryGui("Mob Drops");
                player.openInventory(category.getInventory());
            } else if(e.getSlot() == 16) {
                categoryGui category = new categoryGui("Spawners");
                player.openInventory(category.getInventory());
            }
        }
    }
}
