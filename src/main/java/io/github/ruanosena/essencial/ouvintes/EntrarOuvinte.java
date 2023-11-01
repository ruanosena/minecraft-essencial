package io.github.ruanosena.essencial.ouvintes;

import io.github.ruanosena.essencial.Essencial;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EntrarOuvinte implements Listener {
    private final Essencial plugin;
    public EntrarOuvinte(Essencial plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void aoEntrar(PlayerJoinEvent evento) {
        String boasVindas = this.plugin.getConfig().getString("boas-vindas");
        if (boasVindas != null) {
            boasVindas = boasVindas.replace("[jogador]", evento.getPlayer().getDisplayName());
            evento.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', boasVindas));
        }
    }
}
