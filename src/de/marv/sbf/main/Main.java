package de.marv.sbf.main;

import de.marv.sbf.commands.SetLobby;
import de.marv.sbf.commands.SetSpawn;
import de.marv.sbf.listener.JQListener;
import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main getInstance() {
        return instance;
    }
    public static Main instance;

    public LocationManager getLocationManager() {
        return locationManager;
    }
    public LocationManager locationManager = new LocationManager();

    @Override
    public void onEnable() {
        instance = this;
        init();
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "Das Plugin wurde §aerfolgreich aktiviert");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "Das Plugin wurde §cerfolgreich deaktiviert");
    }

    private void init() {
        PluginManager pm = Bukkit.getPluginManager();
        //COMMANDS
        getCommand("setlobby").setExecutor(new SetLobby());
        getCommand("setspawn").setExecutor(new SetSpawn());
        //EVENTS
        pm.registerEvents(new JQListener(), this);
    }
}
