package de.marv.sbf.utils;

import de.omel.api.file.FileBuilder;

public class ConfigManager {

    public static FileBuilder fb;

    public ConfigManager() {
        fb = new FileBuilder("plugins/SkyBlockFight", "config.yml");
    }

    public void addDefaults() {
        fb.setValue("Lobby.Spawn", false);
        fb.setValue("Rot.Spawn", false);
        fb.setValue("Grün.Spawn", false);
        fb.setValue("Gelb.Spawn", false);
        fb.setValue("Blau.Spawn", false);

        fb.save();
    }
}
