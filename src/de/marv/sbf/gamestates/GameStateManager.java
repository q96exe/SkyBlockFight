package de.marv.sbf.gamestates;

import de.marv.sbf.main.Main;

public class GameStateManager {

    private Main instance;
    private GameState[] gameState;
    private GameState currentGameState;

    public GameStateManager(Main plugin) {
        instance = plugin;
        gameState = new GameState[3];

        gameState[GameState.LOBBY_STATE] = new LobbyState(this);
        gameState[GameState.INGAME_STATE] = new IngameState();
        gameState[GameState.ENDING_STATE] = new EndingState();
    }

    public void setGameState(int GameStateID) {
        if(currentGameState != null) {
            currentGameState.stop();
        }
        currentGameState = gameState[GameStateID];
        currentGameState.start();
    }

    public void stopCurrentGameState() {
        if(currentGameState != null)
            currentGameState.stop();
        currentGameState = null;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
