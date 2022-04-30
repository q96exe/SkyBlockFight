package de.marv.sbf.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Data {

    public static final String prefix = "§a§lSkyBlockFight §7✖ ";
    public static final String noperms = prefix + "§cDu hast dafür keine Berechtigung";
    public static final String use = prefix + "Bitte benutze: §a/";

    private static ArrayList<Player> players = new ArrayList<>();

    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
