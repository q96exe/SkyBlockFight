package de.marv.sbf.utils;

import de.omel.api.file.FileBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class LocationManager extends Thread {

    private FileBuilder fb;

    public LocationManager() {
        fb = new FileBuilder("plugins/SkyBlockFight", "spawns.yml");
    }

    public void setLocation(String name, Location location) {
        fb.setValue(name + ".world", location.getWorld().getName());
        fb.setValue(name + ".x", location.getX());
        fb.setValue(name + ".y", location.getY());
        fb.setValue(name + ".z", location.getZ());
        fb.setValue(name + ".yaw", location.getYaw());
        fb.setValue(name + ".pitch", location.getPitch());

        fb.save();
    }

    public void setSpawn(Location location) {
        fb.setValue("Spawn.world", location.getWorld().getName());
        fb.setValue("Spawn.x", location.getX());
        fb.setValue("Spawn.y", location.getY());
        fb.setValue("Spawn.z", location.getZ());
        fb.setValue("Spawn.yaw", location.getYaw());
        fb.setValue("Spawn.pitch", location.getPitch());

        fb.save();
    }

    public void removeLocation(String name) {
        fb.setValue(name, null);
        fb.setValue(name + ".world", null);
        fb.setValue(name + ".x", null);
        fb.setValue(name + ".y", null);
        fb.setValue(name + ".z", null);
        fb.setValue(name + ".yaw", null);
        fb.setValue(name + ".pitch", null);
        fb.setValue(name + ".item", null);
        fb.setValue(name + ".position", null);

        fb.save();
    }

    public Location getLocation(String name) {
        return new Location(Bukkit.getWorld(fb.getString(name + ".world")),
                fb.getDouble(name + ".x"), fb.getDouble(name + ".y"), fb.getDouble(name + ".z"),
                (float) fb.getDouble(name + ".yaw"), (float) fb.getDouble(name + ".pitch"));
    }

    public Location getSpawn() {
        return new Location(Bukkit.getWorld(fb.getString("Spawn.world")),
                fb.getDouble("Spawn.x"), fb.getDouble("Spawn.y"), fb.getDouble("Spawn.z"),
                (float) fb.getDouble("Spawn.yaw"), (float) fb.getDouble("Spawn.pitch"));
    }

    public String getName(String name) {
        return fb.getString(fb.getString(name));
    }

    public boolean exists(String name) {
        return fb.getString(name) != null;
    }
}
