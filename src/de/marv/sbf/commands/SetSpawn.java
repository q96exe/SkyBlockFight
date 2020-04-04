package de.marv.sbf.commands;

import de.marv.sbf.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setspawn")) {
            if(p.hasPermission("sbf.admin") || p.hasPermission("sbf.*")) {
                if(args.length == 1) {

                } else {
                    p.sendMessage(Data.use + "setspawn <Rot, Gelb, Grün, Blau>");
                }
            }
        }
        return false;
    }
}
