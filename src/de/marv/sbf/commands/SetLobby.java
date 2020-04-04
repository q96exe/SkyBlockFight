package de.marv.sbf.commands;

import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.LocationManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLobby implements CommandExecutor {

    private LocationManager locationManager = Main.getInstance().getLocationManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setlobby")) {
            if(p.hasPermission("sbf.admin") || p.hasPermission("sbf.*")) {
                if(args.length == 0) {
                    locationManager.setSpawn(p.getLocation());
                    p.sendMessage(Data.prefix + "Du hast die §aLobby §7erfolgreich gesetzt");
                    p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 3, 3);
                }
            }
        }
        return false;
    }
}
