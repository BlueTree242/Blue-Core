package me.bluetree.core;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeCommandHandler extends Command {
    private me.bluetree.core.Command cmd;
    public BungeeCommandHandler(me.bluetree.core.Command command, String cmd, String permission, String... aliases) {
        super(cmd, permission, aliases);
    }
    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            cmd.onCommand((CmdSender) User.from((ProxiedPlayer) commandSender), getName(), strings);
        }else {
            cmd.onCommand((CmdSender) new ConsoleSender(), getName(), strings);
        }
    }
}
