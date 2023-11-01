package io.github.ruanosena.essencial.comandos;

import io.github.ruanosena.essencial.Essencial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InicioComando implements CommandExecutor {
    private final Essencial plugin;
    public InicioComando(Essencial plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender invocador, Command comando, String s, String[] strings) {
        if (invocador instanceof Player jogador) {
            if (comando.getName().equalsIgnoreCase("inicio")) {
                Location local = plugin.getConfig().getLocation("inicio");

                if (local != null) {
                    jogador.teleport(local);
                    jogador.sendMessage("%sVocê foi teleportado para o início".formatted(ChatColor.YELLOW));
                } else {
                    plugin.getLogger().info("Não há local de início definido, utilize o comando /definicio");
                }
            }
        } else {
            plugin.getLogger().info("É preciso estar jogando para utilizar esse comando");
        }
        return false;
    }
}
