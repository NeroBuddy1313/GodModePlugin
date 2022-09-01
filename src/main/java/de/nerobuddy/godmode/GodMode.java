package de.nerobuddy.godmode;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GodMode extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("god")).setExecutor(new GodModeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
