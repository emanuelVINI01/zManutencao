package com.tkcr.bukkit.sv;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Manu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender.hasPermission(Main.getPlugin(Main.class).getConfig().getString("adminperm"))){
            if(Main.getPlugin(Main.class).emManu){
                Main.getPlugin(Main.class).emManu = false;
                commandSender.sendMessage("§cManutenção desativada.");
                Main.getPlugin(Main.class).reloadConfig();
            }else{
                Main.getPlugin(Main.class).emManu = true;
                commandSender.sendMessage("§cManutenção ativada.");
                kickAll(Main.getPlugin(Main.class).getConfig().getString("mensagem"),Main.getPlugin(Main.class).getConfig().getString("naotomakick"));
                Main.getPlugin(Main.class).reloadConfig();
            }

        }else{
            commandSender.sendMessage(Main.getPlugin(Main.class).getConfig().getString("noperm"));
        }

        return false;
    }
    public void kickAll(String msg,String perm){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(!p.hasPermission(perm)){
                p.kickPlayer(msg);
            }

        }
    }

}
