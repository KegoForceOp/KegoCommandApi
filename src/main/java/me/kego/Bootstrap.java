package me.kego;

import me.kego.Command.CommandManager;
import me.kego.Command.impl.Login;
import org.bukkit.plugin.java.JavaPlugin;

public class Bootstrap extends JavaPlugin {

    private static Bootstrap INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        new CommandManager();
        new Login();
    }

    @Override
    public void onDisable() {

    }

    public static Bootstrap getInstance() {
        return INSTANCE;
    }
}
