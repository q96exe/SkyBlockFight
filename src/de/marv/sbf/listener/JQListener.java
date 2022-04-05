package de.marv.sbf.listener;

import de.marv.sbf.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JQListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(Data.prefix + "§a§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §abetreten");
    }

    @EventHandler
    public void QuitListener(PlayerQuitEvent e) {
        e.setQuitMessage(Data.prefix + "§c§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §cverlassen");
    }
}
