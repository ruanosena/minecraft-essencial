package io.github.ruanosena.essencial.comandos;

import io.github.ruanosena.essencial.Essencial;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefBoasVindasComando implements CommandExecutor {
    private final Essencial plugin;
    public DefBoasVindasComando(Essencial plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender invocador, Command comando, String s, String[] strings) {
        if (invocador instanceof Player) {
            if (comando.getName().equalsIgnoreCase("defboasvindas")) {
                if (strings.length > 0) {
                    StringBuilder mensagem = new StringBuilder();
                    for (String string : strings) {
                        mensagem.append(string).append(" ");
                    }
                    this.plugin.getConfig().set("boas-vindas", mensagem.toString().trim());
                    this.plugin.saveConfig();
                    return true;
                }
            }
        } else {
            plugin.getLogger().info("É preciso estar jogando para utilizar esse comando");
        }
        return false;
    }
}
