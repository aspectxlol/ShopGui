package com.aspectx.fixmc.fixmcshopgui.commands;

import com.aspectx.fixmc.fixmcshopgui.inventories.mainShopGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) sender.sendMessage("Only Players Can Execute this command");
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("shop")) {
            mainShopGui shopGui = new mainShopGui();
            player.openInventory(shopGui.getInventory());
        }
        return false;
    }
}
