package me.bluetree.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BukkitCommandHandler implements CommandExecutor {
    private me.bluetree.core.Command command;
    public BukkitCommandHandler(String cmd, me.bluetree.core.Command command) {
        this.command = command;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            this.command.onCommand((CmdSender) User.from((Player) command), s, strings);
        } else {
            this.command.onCommand((CmdSender) new ConsoleSender(), s, strings);
        }
        return true;
    }
}
