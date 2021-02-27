package me.bluetree.core;

import org.bukkit.plugin.Plugin;

import java.io.File;

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
    public void registerCommand(Command command, String cmd) {
        if (serverType != ServerType.Server) {
            throw new IllegalArgumentException("Not a bukkit plugin!");
        } else {
            MainClassBukkit.getServer().getPluginCommand(cmd).setExecutor(new BukkitCommandHandler(cmd, command));
        }
    }
    public void registerCommand(Command command, String cmd, String permission, String... aliases) {
        if (serverType != ServerType.Proxy) {
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
    public File getDataFolder() {
        if (serverType != ServerType.Server) {
            return MainClassBungee.getDataFolder();
        } else {
            return MainClassBukkit.getDataFolder();
        }
    }

    public String getName() {
        if (serverType == ServerType.Server) {
            return MainClassBukkit.getName();
        } else {
            return MainClassBungee.getDescription().getName();
        }
    }
    public String getVersion() {
        if (serverType == ServerType.Server) {
            return MainClassBukkit.getDescription().getVersion();
        } else {
            return MainClassBungee.getDescription().getVersion();
        }
    }




}
