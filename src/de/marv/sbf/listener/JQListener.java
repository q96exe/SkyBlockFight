package de.marv.sbf.listener;

import de.marv.sbf.countdowns.LobbyCountdown;
import de.marv.sbf.gamestates.GameState;
import de.marv.sbf.gamestates.LobbyState;
import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JQListener implements Listener {

    private Main instance;
    private Data data;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(!(instance.getGameStateManager().getCurrentGameState() instanceof LobbyState)) return;
        Player player = e.getPlayer();
        data.getPlayers().add(player);
        e.setJoinMessage(Data.prefix + "§a§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §abetreten");

        LobbyState lobbyState = (LobbyState) instance.getGameStateManager().getCurrentGameState();
        LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();
        if(data.getPlayers().size() >= LobbyState.minPlayers) {
            if (!lobbyCountdown.isRunning()) {
                lobbyCountdown.stopIdle();
                lobbyCountdown.start();
            }
        }
    }

    @EventHandler
    public void QuitListener(PlayerQuitEvent e) {
        if(!(instance.getGameStateManager().getCurrentGameState() instanceof LobbyState)) return;
        Player player = e.getPlayer();
        data.getPlayers().remove(player);
        e.setQuitMessage(Data.prefix + "§c§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §cverlassen");

        LobbyState lobbyState = (LobbyState) instance.getGameStateManager().getCurrentGameState();
        LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();
        if (data.getPlayers().size() < LobbyState.minPlayers) {
            if(lobbyCountdown.isRunning()) {
                lobbyCountdown.stop();
                lobbyCountdown.startIdle();

            }
        }
    }
}
