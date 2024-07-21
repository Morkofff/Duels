package org.morkofff.duels;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.bukkit.Bukkit.*;

public class Events implements Listener {
    public static List<Player> players = new ArrayList<>();

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType() == Material.RED_BED) {
            player.getInventory().setItem(0, null);
            player.getInventory().setItem(1, null);
            player.getInventory().setItem(8, null);
            player.getInventory().setItem(36, null);
            player.getInventory().setItem(37, null);
            player.getInventory().setItem(38, null);
            player.getInventory().setItem(39, null);
            player.getInventory().setItem(40, null);

            World world = getWorld("world");
            player.teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            getServer().dispatchCommand(getServer().getConsoleSender(), "lobbyitems " + player.getName() + " world");
            Events.players.clear();

        }
    }

    @EventHandler
    public void check_leave(PlayerQuitEvent event) throws InterruptedException {
        if (players.contains(event.getPlayer())) {
            players.getFirst().getInventory().setItem(0, null);
            players.getFirst().getInventory().setItem(1, null);
            players.getFirst().getInventory().setItem(36, null);
            players.getFirst().getInventory().setItem(37, null);
            players.getFirst().getInventory().setItem(38, null);
            players.getFirst().getInventory().setItem(39, null);
            players.getFirst().getInventory().setItem(40, null);

            players.getLast().getInventory().setItem(0, null);
            players.getLast().getInventory().setItem(1, null);
            players.getLast().getInventory().setItem(36, null);
            players.getLast().getInventory().setItem(37, null);
            players.getLast().getInventory().setItem(38, null);
            players.getLast().getInventory().setItem(39, null);
            players.getLast().getInventory().setItem(40, null);

            World world = getWorld("world");

            players.getFirst().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getLast().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getFirst().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getLast().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));

            TimeUnit.MILLISECONDS.sleep(5);
            getServer().dispatchCommand(getServer().getConsoleSender(), "lobbyitems " + players.getFirst().getName() + " world");
//            TimeUnit.MILLISECONDS.sleep(5);
            getServer().dispatchCommand(getServer().getConsoleSender(), "lobbyitems " + players.getLast().getName() + " world");
//            getServer().dispatchCommand(getServer().getConsoleSender(), "give @a diamond");
//            TimeUnit.MILLISECONDS.sleep(5);
            players.clear();
        }
    }


    @EventHandler
    public void DeathInDuel(PlayerDeathEvent event) throws InterruptedException {
//        System.out.println(event.getEntity().getPlayer());
        if (players.contains(event.getEntity().getPlayer())) {
            World world = getWorld("world");
//            players.getLast().getPlayer().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
//            players.getFirst().getPlayer().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
//            System.out.println(players.get(0));
//            System.out.println(players);
//            TimeUnit.SECONDS.sleep(5);
//            TimeUnit.MILLISECONDS.sleep(5);
            players.getFirst().getInventory().setItem(0, null);
            players.getFirst().getInventory().setItem(1, null);
            players.getFirst().getInventory().setItem(36, null);
            players.getFirst().getInventory().setItem(37, null);
            players.getFirst().getInventory().setItem(38, null);
            players.getFirst().getInventory().setItem(39, null);
            players.getFirst().getInventory().setItem(40, null);

            players.getLast().getInventory().setItem(0, null);
            players.getLast().getInventory().setItem(1, null);
            players.getLast().getInventory().setItem(36, null);
            players.getLast().getInventory().setItem(37, null);
            players.getLast().getInventory().setItem(38, null);
            players.getLast().getInventory().setItem(39, null);
            players.getLast().getInventory().setItem(40, null);
//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + players.getFirst().getName() + " 0 90 0");
//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + players.getLast().getName() + " 0 90 0");

//            TimeUnit.MILLISECONDS.sleep(5);
            players.getFirst().getInventory().setItem(0, null);
            players.getFirst().getInventory().setItem(1, null);
            players.getFirst().getInventory().setItem(36, null);
            players.getFirst().getInventory().setItem(37, null);
            players.getFirst().getInventory().setItem(38, null);
            players.getFirst().getInventory().setItem(39, null);
            players.getFirst().getInventory().setItem(40, null);

            players.getLast().getInventory().setItem(0, null);
            players.getLast().getInventory().setItem(1, null);
            players.getLast().getInventory().setItem(36, null);
            players.getLast().getInventory().setItem(37, null);
            players.getLast().getInventory().setItem(38, null);
            players.getLast().getInventory().setItem(39, null);
            players.getLast().getInventory().setItem(40, null);

            TimeUnit.MILLISECONDS.sleep(5);
            getServer().dispatchCommand(getServer().getConsoleSender(), "lobbyitems " + players.getFirst().getName() + " world");
//            TimeUnit.MILLISECONDS.sleep(5);
            getServer().dispatchCommand(getServer().getConsoleSender(), "lobbyitems " + players.getLast().getName() + " world");

            players.getFirst().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getLast().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getFirst().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.getLast().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
            players.clear();

//            getServer().dispatchCommand(getServer().getConsoleSender(), "give @a diamond");
//            TimeUnit.MILLISECONDS.sleep(5);

//            System.out.println("tp " + players.getLast().getName() + " 0 90 0");
//            System.out.println("tp " + players.getFirst().getName() + " 0 90 0");
        }
    }

//    @EventHandler
//    public void Respawn(PlayerRespawnEvent event) throws InterruptedException {
//        if (players.contains(event.getPlayer())) {
//            World world = getWorld("world");
////            players.getFirst().teleport(new Location(world, 0.5, 90, 0.5, -90, 0));
////            System.out.println(players.getFirst());
////            System.out.println(players.get(0));
////            System.out.println(players);
//            TimeUnit.SECONDS.sleep(1);
//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + players.getFirst().getName() + " 0 90 0");
//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + players.getLast().getName() + " 0 90 0");
//            System.out.println("tp " + players.getLast().getName() + " 0 90 0");
//        }
//    }
}
