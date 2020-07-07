package me.cristike.hotwparticles.events;

import me.cristike.hotwparticles.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuit implements Listener {

    @EventHandler
    public void QuitEvent (PlayerQuitEvent e) {
        if (Main.hasparticle.contains(e.getPlayer().getUniqueId())) {
            Main.hasparticle.remove(e.getPlayer().getUniqueId());
        }
    }
}
