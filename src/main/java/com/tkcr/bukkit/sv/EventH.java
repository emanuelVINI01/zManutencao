package com.tkcr.bukkit.sv;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventH implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (Main.getPlugin(Main.class).emManu) {
            if(!event.getPlayer().hasPermission(Main.getPlugin(Main.class).getConfig().getString("naotomakick"))){
                event.getPlayer().kickPlayer(Main.getPlugin(Main.class).getConfig().getString("mensagem"));
            }
        }
    }


}
