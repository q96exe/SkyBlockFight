package de.marv.sbf.main;

import de.marv.sbf.commands.Setup;
import de.marv.sbf.commands.Start;
import de.marv.sbf.gamestates.GameState;
import de.marv.sbf.gamestates.GameStateManager;
import de.marv.sbf.listener.JQListener;
import de.marv.sbf.listener.SetupListener;
import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Main getInstance() {
        return instance;
    }
    private GameStateManager gameStateManager;

    @Override
    public void onEnable() {
        instance = this;
        init();
        gameStateManager = new GameStateManager(this);
        gameStateManager.setGameState(GameState.LOBBY_STATE);
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "Das Plugin wurde §aerfolgreich aktiviert");
        Bukkit.getConsoleSender().sendMessage("§bAktueller GameState: " + gameStateManager.getCurrentGameState());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "Das Plugin wurde §cerfolgreich deaktiviert");
    }

    private void init() {
        PluginManager pm = Bukkit.getPluginManager();
        //COMMANDS
        getCommand("setup").setExecutor(new Setup());
        getCommand("start").setExecutor(new Start());
        //EVENTS
        pm.registerEvents(new JQListener(), this);
        pm.registerEvents(new SetupListener(), this);
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }
}
