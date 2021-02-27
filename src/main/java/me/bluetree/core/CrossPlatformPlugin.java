package me.bluetree.core;

import org.bukkit.plugin.Plugin;

public abstract class CrossPlatformPlugin {
    private static ServerType serverType;
    private Plugin MainClassBukkit;
    private net.md_5.bungee.api.plugin.Plugin MainClassBungee;
    public void register(Plugin plugin) {
        serverType = ServerType.Server;
        MainClassBukkit = plugin;
        onStart();
    }
    public void register(net.md_5.bungee.api.plugin.Plugin plugin) {
        serverType = ServerType.Proxy;
        MainClassBungee = plugin;
        onStart();
    }
    public void onStart() {

    }
    public void onStop() {

    }
    public void regiterCommand(Command command, String cmd) {
        if (MainClassBukkit == null) {
            throw new IllegalArgumentException("Not a bukkit plugin!");
        } else {

        }
    }
    public void registerCommand(Command command, String cmd, String permission, String... aliases) {
        if (MainClassBungee == null) {
            throw new IllegalArgumentException("Not a bungee plugin!");
        } else {
            new BungeeCommandHandler(command, cmd, permission, aliases);
        }
    }
    private static ServerType getServerType() {
        return serverType;
    }
    public Plugin getMainClassBukkit() {
        return MainClassBukkit;
    }
    public net.md_5.bungee.api.plugin.Plugin getMainClassBungee() {
        return MainClassBungee;
    }


}
