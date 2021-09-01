package me.kego.Command.utils;

import me.kego.Command.CommandListener;
import me.kego.Command.CommandManager;
import me.kego.Command.KegoCommand;
import me.kego.Command.annotation.Command;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;

public class ReflectionsUtil {

    public static void loadCommands() throws Exception {
        Reflections reflections = new Reflections("me.kego.Command.impl");

        for(Class<? extends CommandListener> kegocommand : reflections.getSubTypesOf(CommandListener.class)) {
            Constructor commandconstructor = kegocommand.getDeclaredConstructor();
            commandconstructor.setAccessible(true);
            CommandListener command = (CommandListener) commandconstructor.newInstance();

            Command info = kegocommand.getDeclaredAnnotation(Command.class);
            if(info == null){
                continue;
            }
            System.out.println("Loading Command: " + info.name());
            CommandManager.getInstance().kegocommands.add(new KegoCommand(command, info));
        }
    }

}
