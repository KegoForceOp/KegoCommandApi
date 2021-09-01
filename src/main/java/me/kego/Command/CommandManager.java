package me.kego.Command;

import me.kego.Bootstrap;
import me.kego.Command.impl.Login;
import me.kego.Command.utils.ReflectionsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager implements Listener {

    public final ArrayList<KegoCommand> kegocommands = new ArrayList<>();
    private static CommandManager instance;

    public CommandManager(){
        instance = this;
        try {
            ReflectionsUtil.loadCommands();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        Bukkit.getPluginManager().registerEvents(this, Bootstrap.getInstance());
    }


    public CommandListener getCommand(String name){
        for(KegoCommand kegoCommand : this.kegocommands){
            if(kegoCommand.getCommandInfo().name().toLowerCase().equalsIgnoreCase(name) || Arrays.asList(kegoCommand.getCommandInfo().aliases()).contains(name)){
                return kegoCommand.getCommand();
            }
        }

        return null;
    }
/*
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        CommandListener command = this.getCommand(event.getMessage());
        String[] split = new String[0];

        if (Register.isLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
            if (command != null) {
                if (event.getMessage().contains(" ")) {
                    split = command.toString().split(" ");
                }
                command.execute(Bootstrap.getInstance(), event.getPlayer(), split);
            } else {
                event.getPlayer().sendMessage(Prefix.PREFIX("Unknown Command. Run " + Color.Bold + Color.Aqua + "help 1" + Color.Reset + " for list of commands!"));
            }
        }
    }
*/
    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        try {
            final Player player = event.getPlayer();
            String replace = event.getMessage().toLowerCase().contains(" ") ? event.getMessage().toLowerCase().substring(0, event.getMessage().indexOf(" ")) : event.getMessage();
            String[] split = new String[0];
            if (event.getMessage().contains(" ")) {
                split = event.getMessage().split(" ");
            }

            if (Login.auth.contains(player.getName())) {
                event.setCancelled(true);

                CommandListener command = this.getCommand(replace);
                if (command == null) {
                    player.sendMessage("Unknown Command.");
                    return;
                }

                command.execute(Bootstrap.getInstance(), event.getPlayer(), split);
            }
        } catch (Exception ignored) {

        }
    }

    public static CommandManager getInstance() {
        return instance;
    }
}
