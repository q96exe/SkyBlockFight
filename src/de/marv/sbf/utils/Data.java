package de.marv.sbf.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Data {

    public static final String prefix = "§a§lSkyBlockFight §7✖ ";
    public static final String noperms = prefix + "§cDu hast dafür keine Berechtigung";
    public static final String use = prefix + "Butte benutze: §a/";

    private ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
