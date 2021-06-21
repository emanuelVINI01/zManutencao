package com.tkcr.bukkit.sv;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public boolean emManu = false;
    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventH(),this);
        getCommand("manu").setExecutor(new Manu());
    }



}
