package me.bluetree.core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.Console;

public class ConsoleSender extends CmdSender {
    private CommandSender ex;
    private net.md_5.bungee.api.CommandSender sender;
    public ConsoleSender(CommandSender ex) {
        this.ex = ex;
    }
    public ConsoleSender(net.md_5.bungee.api.CommandSender sender) {
        this.sender = sender;
    }
    public void sendMessage(String msg) {
        if (sender == null) {
            ex.sendMessage(msg);
        } else {
            sender.sendMessage(msg);
        }
    }
}
