package de.marv.sbf.countdowns;

import de.marv.sbf.gamestates.GameState;
import de.marv.sbf.gamestates.GameStateManager;
import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import org.bukkit.Bukkit;

public class LobbyCountdown extends Countdown {

    private static final int countdownTime = 60, idleTime = 15;;
    private int remaining;
    private int idleID;
    private boolean isIdle;
    private boolean isRunning;
    private Main instance;
    private GameStateManager gameStateManager;

    public LobbyCountdown(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public void startIdle() {
        isIdle = true;
        idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(gameStateManager.getInstance(), new Runnable() {
            @Override
            public void run() {

            }
        }, 0, 20 * idleTime);
    }

    public void stopIdle() {
        if(isIdle) {
            Bukkit.getScheduler().cancelTask(idleID);
            isIdle = false;
        }
    }

    @Override
    public void start() {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(gameStateManager.getInstance(), new Runnable() {
            @Override
            public void run() {
                switch(remaining) {
                    case 60: case 30: case 10: case 5: case 3: case 2:
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §a " + remaining + " §7Sekunden.");
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §aeiner §7Sekunde.");
                        break;
                    case 0:
                        gameStateManager.setGameState(GameState.INGAME_STATE);
                        break;
                    default:
                        break;
                }
                remaining--;
            }
        }, 0, 20);
    }

    @Override
    public void stop() {
        if(isRunning) {
            Bukkit.getScheduler().cancelTask(taskID);
            isRunning = false;
            remaining = countdownTime;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}
