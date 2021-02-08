package me.bluetree.core;

import org.bukkit.plugin.Plugin;

public class CrossPlatformPlugin {
    private ServerType serverType;
    private Plugin MainClassBukkit;
    private net.md_5.bungee.api.plugin.Plugin MainClassBungee;
    public void register(Plugin plugin) {
        serverType = ServerType.Server;
        MainClassBukkit = plugin;
    }
    public void register(net.md_5.bungee.api.plugin.Plugin plugin) {
        serverType = ServerType.Proxy;
        MainClassBungee = plugin;
    }
}
