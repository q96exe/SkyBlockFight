package de.marv.sbf.countdowns;

import de.marv.sbf.gamestates.GameState;
import de.marv.sbf.gamestates.GameStateManager;
import de.marv.sbf.gamestates.LobbyState;
import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountdown extends Countdown {

    private static final int countdownTime = 60, idleTime = 15;;
    private int remaining;
    private int idleID;
    private boolean isIdle;
    private boolean isRunning;
    private final GameStateManager gameStateManager;

    public LobbyCountdown(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        remaining = countdownTime;
    }

    public void startIdle() {
        isIdle = true;
        idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(Data.prefix + "Es fehlen noch §a" + (LobbyState.minPlayers - Data.getPlayers().size() +
                                        " §7Spieler."));
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
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                switch(remaining) {
                    case 60: case 30: case 10: case 5: case 4: case 3: case 2:
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §a" + remaining + " §7Sekunden.");
                        for(Player all : Bukkit.getOnlinePlayers())
                            all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 2, 2);
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §aeiner §7Sekunde.");
                        for(Player all : Bukkit.getOnlinePlayers())
                            all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 2, 2);
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

    public int getSeconds() {
        return remaining;
    }

    public int setSeconds(int seconds) {
        return this.remaining = seconds;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
