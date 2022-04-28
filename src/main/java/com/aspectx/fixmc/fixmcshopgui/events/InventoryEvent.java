package com.aspectx.fixmc.fixmcshopgui.events;

import com.aspectx.fixmc.fixmcshopgui.FixmcShopGui;
import com.aspectx.fixmc.fixmcshopgui.inventories.categoryGui;
import com.aspectx.fixmc.fixmcshopgui.inventories.mainShopGui;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class InventoryEvent implements Listener {
    private FixmcShopGui fixmc;
    public InventoryEvent(FixmcShopGui fixmc) {
        this.fixmc = fixmc;
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
            if (e.getClickedInventory() == null) { return; }
            if (e.getClickedInventory().getHolder() instanceof mainShopGui) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                if (e.getCurrentItem() == null) { return; }
                player.sendMessage(String.valueOf(e.getSlot()));

                if(e.getSlot() == 10) {
                    player.sendMessage("aB");
                    BukkitScheduler scheduler = Bukkit.getScheduler();
                    Plugin plugin = JavaPlugin.getPlugin(FixmcShopGui.class);
                    scheduler.runTask(plugin, () -> {
                        categoryGui category = new categoryGui("Blocks", fixmc);
                        player.openInventory(category.getInventory());
                        player.sendMessage(String.valueOf(fixmc.getConfig().getString("shop.Blocks.Grass.item")));
                    });
                } else if(e.getSlot() == 11) {
                    categoryGui category = new categoryGui("Foods", fixmc);
                    player.openInventory(category.getInventory());
                } else if(e.getSlot() == 12) {
                    categoryGui category = new categoryGui("Valuables", fixmc);
                    player.openInventory(category.getInventory());
                } else if(e.getSlot() == 13) {
                    categoryGui category = new categoryGui("Pvp", fixmc);
                    player.openInventory(category.getInventory());
                } else if(e.getSlot() == 14) {
                    categoryGui category = new categoryGui("Potion", fixmc);
                    player.openInventory(category.getInventory());
                } else if(e.getSlot() == 15) {
                    categoryGui category = new categoryGui("Mob Drops", fixmc);
                    player.openInventory(category.getInventory());
                } else if(e.getSlot() == 16) {
                    categoryGui category = new categoryGui("Spawners", fixmc);
                    player.openInventory(category.getInventory());
                }
            }
    }
}
