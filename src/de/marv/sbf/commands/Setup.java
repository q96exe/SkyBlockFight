package de.marv.sbf.commands;

import de.marv.sbf.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setup implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setup")) {
            if(p.hasPermission("bsf.admin") || p.hasPermission("sbf.*")) {
                if(args.length == 0) {
                    
                } else {
                    p.sendMessage(Data.use + "/setup");
                }
            }
        }
        return false;
    }
}
