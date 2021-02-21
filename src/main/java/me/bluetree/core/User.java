package me.bluetree.core;


import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

public abstract class User extends CmdSender{
    public static ProxiedPlayerUser from(ProxiedPlayer p) {
        return new ProxiedPlayerUser(p);
    }
    public static PlayerUser from(Player p) {
        return new PlayerUser(p);
    }

    public abstract void sendMessage(String msg);
    public abstract void chat(String msg);
    public abstract String getDisplayName();
}
