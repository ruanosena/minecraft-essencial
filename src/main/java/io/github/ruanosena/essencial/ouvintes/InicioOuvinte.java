package io.github.ruanosena.essencial.ouvintes;

import io.github.ruanosena.essencial.Essencial;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class InicioOuvinte implements Listener {
    private final Essencial plugin;
    public InicioOuvinte(Essencial plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void aoJogadorEntrar(PlayerJoinEvent evento) {
        Player jogador = evento.getPlayer();

        if (!jogador.hasPlayedBefore()) {
            Location local = plugin.getConfig().getLocation("inicio");

            if (local != null) {
                jogador.teleport(local);
            }
        }
    }

    @EventHandler
    public void aoJogadorRenascer(PlayerRespawnEvent evento) {
        Location local = plugin.getConfig().getLocation("inicio");
        if (local != null) {
            evento.setRespawnLocation(local);
        }
    }
}
