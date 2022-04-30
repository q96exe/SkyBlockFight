package de.marv.sbf.listener;

import de.marv.sbf.utils.Data;
import de.marv.sbf.utils.LocationManager;
import de.marv.sbf.utils.SetupManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SetupListener implements Listener {

    SetupManager setupManager = new SetupManager();
    LocationManager locationManager = new LocationManager();
    String mapName;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().getDisplayName().startsWith("§c§lMAP")) {
                String mapItemName = event.getItem().getItemMeta().getDisplayName();
                String[] parts = mapItemName.split(" ");
                mapName = parts[parts.length - 1];
                setupManager.openSetupGUI(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(event.getClickedInventory().getName().startsWith("§a§lSETUP"))
            event.setCancelled(true);

        if(event.getClickedInventory().getName().equalsIgnoreCase("§e§lTeams setzen"))
            event.setCancelled(true);

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lLobby setzen")) {
            event.setCancelled(true);
            locationManager.setLocation("Lobby.spawn", event.getWhoClicked().getLocation());
            event.getWhoClicked().sendMessage(Data.prefix + "Du hast die §eLobby §7erfolgreich gesetzt.");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lTeams setzen")) {
            event.setCancelled(true);
            setupManager.openTeamSetupGUI(player);
        }

        // Team Spawns
        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRot") &&
                event.getCurrentItem().getType() == Material.WOOL) {
            event.setCancelled(true);
            locationManager.setLocation(mapName + ".rot.spawn", player.getLocation());
            player.sendMessage(Data.prefix + "Du hast den Spawn für " + event.getCurrentItem().getItemMeta().getDisplayName() + " §7gesetzt");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelb") &&
                event.getCurrentItem().getType() == Material.WOOL) {
            event.setCancelled(true);
            locationManager.setLocation(mapName + ".gelb.spawn", player.getLocation());
            player.sendMessage(Data.prefix + "Du hast den Spawn für " + event.getCurrentItem().getItemMeta().getDisplayName() + " §7gesetzt");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrün") &&
                event.getCurrentItem().getType() == Material.WOOL) {
            event.setCancelled(true);
            locationManager.setLocation(mapName + ".grün.spawn", player.getLocation());
            player.sendMessage(Data.prefix + "Du hast den Spawn für " + event.getCurrentItem().getItemMeta().getDisplayName() + " §7gesetzt");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Blau") &&
                event.getCurrentItem().getType() == Material.WOOL) {
            event.setCancelled(true);
            locationManager.setLocation(mapName + ".blau.spawn", player.getLocation());
            player.sendMessage(Data.prefix + "Du hast den Spawn für " + event.getCurrentItem().getItemMeta().getDisplayName() + " §7gesetzt");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
        }
    }
}
