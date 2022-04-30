package de.marv.sbf.listener;

import de.marv.sbf.countdowns.LobbyCountdown;
import de.marv.sbf.gamestates.LobbyState;
import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JQListener implements Listener {

    private final Main instance = Main.getInstance();

    LocationManager locationManager = new LocationManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(!(instance.getGameStateManager().getCurrentGameState() instanceof LobbyState)) return;
        Player player = e.getPlayer();
        Data.getPlayers().add(player);
        e.setJoinMessage(Data.prefix + "§a§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §abetreten");

        if(locationManager.exists("Lobby.spawn")) {
            player.teleport(locationManager.getLocation("Lobby.spawn"));
        } else {
            player.sendMessage(Data.prefix + "§cDie Lobby wurde noch nicht gesetzt!");
        }

        LobbyState lobbyState = (LobbyState) instance.getGameStateManager().getCurrentGameState();
        LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();
        if(Data.getPlayers().size() >= LobbyState.minPlayers) {
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
        Data.getPlayers().remove(player);
        e.setQuitMessage(Data.prefix + "§c§l" + e.getPlayer().getDisplayName() + " §7hat das Spiel §cverlassen");

        LobbyState lobbyState = (LobbyState) instance.getGameStateManager().getCurrentGameState();
        LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();
        if (Data.getPlayers().size() < LobbyState.minPlayers) {
            if(lobbyCountdown.isRunning()) {
                lobbyCountdown.stop();
                lobbyCountdown.startIdle();

            }
        }
    }
}
