package me.kego.Command;

import me.kego.Bootstrap;
import me.kego.Command.annotation.Command;
import org.bukkit.entity.Player;

@Command(name = "", usage = "", desc = "")
public abstract class CommandListener {

    public abstract void execute(Bootstrap instance, Player player, String[] args);

}
