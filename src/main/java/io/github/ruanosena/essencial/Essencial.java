package io.github.ruanosena.essencial;

import io.github.ruanosena.essencial.comandos.DefInicioComando;
import io.github.ruanosena.essencial.comandos.InicioComando;
import io.github.ruanosena.essencial.ouvintes.InicioOuvinte;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Essencial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Objects.requireNonNull(this.getCommand("definicio")).setExecutor(new DefInicioComando(this));
        Objects.requireNonNull(this.getCommand("inicio")).setExecutor(new InicioComando(this));

        getServer().getPluginManager().registerEvents(new InicioOuvinte(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
