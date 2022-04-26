package com.aspectx.fixmc.fixmcshopgui;

import com.aspectx.fixmc.fixmcshopgui.commands.ShopCommand;
import com.aspectx.fixmc.fixmcshopgui.events.InventoryEvent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class FixmcShopGui extends JavaPlugin {
    private File shopConfigFile = new File(getDataFolder().getAbsolutePath(), "shop.yml");
    private FileConfiguration shopConfig = YamlConfiguration.loadConfiguration(shopConfigFile);

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FixMC] Enabled");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryEvent(), this);
        getCommand("shop").setExecutor(new ShopCommand());

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[FixMC] Disabled");
    }

    public FileConfiguration getConfig() {
        return shopConfig;
    }


}

