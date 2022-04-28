package com.aspectx.fixmc.fixmcshopgui;

import com.aspectx.fixmc.fixmcshopgui.commands.ShopCommand;
import com.aspectx.fixmc.fixmcshopgui.events.InventoryEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public final class FixmcShopGui extends JavaPlugin {
    private File shopConfigFile;
    private FileConfiguration shopConfig;

    private static Economy econ = null;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FixMc] Vault Not Found, Disabling");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else {
            getServer().getConsoleSender().sendMessage("Vault Found");
        }

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FixMC] Enabled");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryEvent(this), this);
        getCommand("shop").setExecutor(new ShopCommand());

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[FixMC] Disabled");
    }

    public FileConfiguration getConfig() {
        if (shopConfig == null) {
            try {
                reloadCustomConfig();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return shopConfig;
    }

    public Economy getEcomnomy() {
        return econ;
    }

    public void reloadCustomConfig() throws UnsupportedEncodingException {
        if (shopConfigFile == null) {
            shopConfigFile = new File(getDataFolder().getAbsolutePath(), "shop.yml");
        }
        shopConfig = YamlConfiguration.loadConfiguration(shopConfigFile);

        // Look for defaults in the jar
        Reader defConfigStream = new InputStreamReader(this.getResource("shop.yml"), "UTF8");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            shopConfig.setDefaults(defConfig);
        }
    }
}

