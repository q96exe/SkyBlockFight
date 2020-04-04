package de.marv.sbf.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JQListener implements Listener {

    public static void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("§a§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §abetreten");
    }

    public static void QuitListener(PlayerQuitEvent e) {
        e.setQuitMessage("§c§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §cverlassen");
    }
}
