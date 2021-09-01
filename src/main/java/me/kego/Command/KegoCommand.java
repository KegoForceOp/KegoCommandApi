package me.kego.Command;

import me.kego.Command.annotation.Command;

public class KegoCommand {
    private final CommandListener command;
    private final Command annotation;


    public KegoCommand(CommandListener command, Command cmd){
        this.command = command;
        this.annotation = cmd;
    }

    public CommandListener getCommand(){
        return this.command;
    }

    public Command getCommandInfo(){
        return this.annotation;
    }
}
