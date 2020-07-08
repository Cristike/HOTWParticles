package me.cristike.hotwparticles;

import me.cristike.hotwparticles.commands.particleremove;
import me.cristike.hotwparticles.commands.particleset;
import me.cristike.hotwparticles.events.onDeath;
import me.cristike.hotwparticles.events.onQuit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static ArrayList<UUID> hasparticle = new ArrayList<>();

    public static HashMap<UUID, Particle> lastParticle = new HashMap<>();
    public static HashMap<UUID, Color> LastColor = new HashMap<>();
    public static HashMap<String, Color> getColors() {
        HashMap<String, Color> colors = new HashMap<>();
        colors.put("AQUA", Color.AQUA);
        colors.put("BLUE", Color.BLUE);
        colors.put("BLACK", Color.BLACK);
        colors.put("FUCHSIA", Color.FUCHSIA);
        colors.put("GRAY", Color.GRAY);
        colors.put("GREEN", Color.GREEN);
        colors.put("LIME", Color.LIME);
        colors.put("MAROON", Color.MAROON);
        colors.put("NAVY", Color.NAVY);
        colors.put("OLIVE", Color.OLIVE);
        colors.put("ORANGE", Color.ORANGE);
        colors.put("PURPLE", Color.PURPLE);
        colors.put("RED", Color.RED);
        colors.put("SILVER", Color.SILVER);
        colors.put("TEAL", Color.TEAL);
        colors.put("WHITE", Color.WHITE);
        colors.put("YELLOW", Color.YELLOW);
        return colors;
    }

    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        saveDefaultConfig();
        Bukkit.getServer().getConsoleSender().sendMessage(c("&7[&bHOTWParticles&7] &fThe plugin has been &aenabled"));
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(c("&7[&bHOTWParticles&7] &fThe plugin has been &cdisabled"));
    }

    private void loadCommands() {
        this.getCommand("particleset").setExecutor(new particleset());
        this.getCommand("particleremove").setExecutor(new particleremove());
    }

    private void loadEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new onDeath(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new onQuit(), this);
    }

    public static String c (String mess) {
        return ChatColor.translateAlternateColorCodes('&', mess);
    }
}
