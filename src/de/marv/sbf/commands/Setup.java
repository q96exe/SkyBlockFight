package de.marv.sbf.commands;

import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.SetupManager;
import de.omel.api.itemstack.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setup implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player p = (Player) sender;
        SetupManager setupManager = new SetupManager();
        String mapName = "";

        if(cmd.getName().equalsIgnoreCase("setup")) {
            if(p.hasPermission("sbf.admin") || p.hasPermission("sbf.*")) {
                if(args.length == 1) {
                    mapName = args[0];
                    p.getInventory().addItem(new ItemBuilder(Material.STICK).setDisplayname("§c§lMAP: §e§l" + mapName).build());
                    setupManager.openSetupGUI(p);
                } else {
                    p.sendMessage(Data.use + "setup <Mapname>");
                }
            } else {
                p.sendMessage(Data.noperms);
            }
        }
        return false;
    }
}
