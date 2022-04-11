package de.marv.sbf.utils;

import de.omel.api.file.FileBuilder;
import de.omel.api.itemstack.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SetupManager {

    FileBuilder fb = ConfigManager.fb;

    public SetupManager() {

    }

    public void setPlaceHolder(Inventory inventory) {
        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15).setDisplayname(" ").build());
        }
    }

    public void openSetupGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, "§a§lSETUP");
        setPlaceHolder(inventory);

        //TODO: Add function to Setup
        inventory.setItem(1, new ItemBuilder(Material.NETHER_STAR).setDisplayname("§c§lLobby setzen").build());
        inventory.setItem(3, new ItemBuilder(Material.BED).setDisplayname("§e§lTeams setzen").build());
        inventory.setItem(5, new ItemBuilder(Material.BARRIER).setDisplayname("§cSoon").build());
        inventory.setItem(7, new ItemBuilder(Material.BARRIER).setDisplayname("§cSoon").build());

        player.openInventory(inventory);
    }

    public void openTeamSetupGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, "§e§lTeams setzen");
        setPlaceHolder(inventory);

        inventory.setItem(1, new ItemBuilder(Material.WOOL, 1, (short)14).setDisplayname("§cRot").build());
        inventory.setItem(3, new ItemBuilder(Material.WOOL, 1, (short)4).setDisplayname("§eGelb").build());
        inventory.setItem(5, new ItemBuilder(Material.WOOL, 1, (short)5).setDisplayname("§aGrün").build());
        inventory.setItem(7, new ItemBuilder(Material.WOOL, 1, (short)11).setDisplayname("§9Blau").build());

        player.openInventory(inventory);
    }
}
