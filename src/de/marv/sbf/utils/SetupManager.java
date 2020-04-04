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
        Inventory inventory = Bukkit.createInventory(null, 9*4, "§a§lSETUP");
        setPlaceHolder(inventory);

        //

        player.openInventory(inventory);
    }
}
