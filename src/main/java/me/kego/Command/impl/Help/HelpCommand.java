package me.kego.Command.impl.Help;

import me.kego.Bootstrap;
import me.kego.Command.CommandListener;
import me.kego.Command.annotation.Command;

import org.bukkit.entity.Player;

@Command(name = "help", usage = "help <1-5>", desc = "Shows you list of all commands")
public class HelpCommand extends CommandListener {

    @Override
    public void execute(Bootstrap instance, Player player, String[] args) {
        if (args.length <= 1 ) {
            player.sendMessage(HelpCommand.class.getAnnotation(Command.class).usage());
            return;
        }
        if (args[1].equalsIgnoreCase("1")) {

            player.sendMessage(HelpCommand.class.getAnnotation(Command.class).name() + " l " + HelpCommand.class.getAnnotation(Command.class).desc());

        }
    }
}
