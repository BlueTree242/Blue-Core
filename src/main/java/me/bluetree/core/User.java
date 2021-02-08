package me.bluetree.core;

import org.bukkit.entity.Player;

public class User extends CmdSender{
    private Player player;
    public User(Player player) {
        this.player = player;
    }
}
