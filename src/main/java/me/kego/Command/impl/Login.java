package me.kego.Command.impl;

import me.kego.Bootstrap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class Login implements Listener {

    public static ArrayList<String> auth = new ArrayList<>();

    public Login() {
        Bukkit.getPluginManager().registerEvents(this, Bootstrap.getInstance());
    }

    @EventHandler
    public void login(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (e.getMessage().equalsIgnoreCase("login")) {
            e.setCancelled(true);
            auth.add(p.getName());
            p.sendMessage("Logged in");
        }
    }

}
