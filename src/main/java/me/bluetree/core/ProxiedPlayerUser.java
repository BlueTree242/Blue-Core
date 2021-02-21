package me.bluetree.core;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ProxiedPlayerUser extends User{
    private ProxiedPlayer player;
    public ProxiedPlayerUser(ProxiedPlayer p) {
        player = p;
    }
    @Override
    public void sendMessage(String msg) {
        player.sendMessage(msg);
    }

    @Override
    public void chat(String msg) {
        player.chat(msg);
    }

    @Override
    public String getDisplayName() {
        return player.getDisplayName();
    }
}
