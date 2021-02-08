package me.bluetree.core;


import org.bukkit.plugin.Plugin;

public abstract class Cmd {

    private String BukkitCommand;
    private String BungeeCommand;
    private String[] BungeeArgs;
    private Plugin BukkitPlugin;
    private net.md_5.bungee.api.plugin.Plugin BungeePlugin;


    public Cmd(String BukkitCommand, Plugin plugin) {
        this.BukkitCommand = BukkitCommand;
    }
    public Cmd(String BungeeCommand, String[] BungeeArgs, net.md_5.bungee.api.plugin.Plugin plugin) {
        this.BukkitCommand = BungeeCommand;
        this.BungeeArgs = BungeeArgs;
    }

    public abstract boolean execute(CmdSender sender, String[] args, String label);
}
