package io.github.ruanosena.essencial.comandos;

import io.github.ruanosena.essencial.Essencial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class DefInicioComando implements CommandExecutor {
    private final Essencial plugin;
    public DefInicioComando(Essencial plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender invocador, Command comando, String s, String[] strings) {
        if (invocador instanceof Player jogador) {
            if (comando.getName().equalsIgnoreCase("definicio")) {
                if (strings.length == 0) {
                    Location local = jogador.getLocation();
                    plugin.getConfig().set("inicio", local);
                    plugin.saveConfig();
                    jogador.sendMessage("%sLocal de início definido!".formatted(ChatColor.LIGHT_PURPLE));
                    return true;
                }
            }
        } else {
            plugin.getLogger().info("É preciso estar jogando para utilizar esse comando");
        }
        return false;
    }
}
