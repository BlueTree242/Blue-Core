package me.bluetree.core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.Console;

public class ConsoleSender extends CmdSender {
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
