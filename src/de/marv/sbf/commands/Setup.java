package de.marv.sbf.commands;

import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.SetupManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setup implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;
        SetupManager setupManager = new SetupManager();

        if(cmd.getName().equalsIgnoreCase("setup")) {
            if(p.hasPermission("sbf.admin") || p.hasPermission("sbf.*")) {
                if(args.length == 0) {
                    setupManager.openSetupGUI(p);
                } else {
                    p.sendMessage(Data.use + "setup");
                }
            } else {
                p.sendMessage(Data.noperms);
            }
        }
        return false;
    }
}
