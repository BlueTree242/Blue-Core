package me.bluetree.core;

import org.bukkit.command.CommandExecutor;

public abstract class Command {
    public abstract void onCommand(CmdSender user, String label, String[] args);
}
