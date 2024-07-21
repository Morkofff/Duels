package org.morkofff.duels;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Duels extends JavaPlugin {

    public static Plugin duels;
    @Override
    public void onEnable() {
        // Plugin startup logic
        duels = this;
        this.getCommand("start").setExecutor(new Start());
        this.getCommand("test").setExecutor(new Test());
        getServer().getPluginManager().registerEvents(new Events(), duels);
//        int id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
//            @Override
//            public void run() {
//                getServer().broadcastMessage("qqq");
//            }
//        }, 0, 30);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Events.players.clear();
    }
}
