package de.marv.sbf.gamestates;

import de.marv.sbf.countdowns.LobbyCountdown;

public class LobbyState extends GameState {

    public static final int minPlayers = 1;
    public static final int maxPlayers = 12;

    private LobbyCountdown lobbyCountdown;

    public LobbyState(GameStateManager gameStateManager) {
        lobbyCountdown = new LobbyCountdown(gameStateManager);
    }

    @Override
    public void start() {
        lobbyCountdown.startIdle();
    }

    @Override
    public void stop() {

    }

    public LobbyCountdown getLobbyCountdown() {
        return lobbyCountdown;
    }
}
