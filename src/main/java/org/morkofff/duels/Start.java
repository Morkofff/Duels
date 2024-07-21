package org.morkofff.duels;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.bukkit.Bukkit.*;

public class Start implements CommandExecutor {
//    public List<String> players = new ArrayList<>();


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (commandSender instanceof Player && player.getWorld().getName().equalsIgnoreCase("world")) {


//            List<Location> locations = new ArrayList<>();
//            locations.add(new Location(world, -80, 75, 30));
//            locations.add(new Location(world, -80, 75, 35));
            World world = getWorld("world");
            if (Events.players.size() < 2) {
                Events.players.add(player.getPlayer());
                Events.players.getFirst().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                Events.players.getLast().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
//                player.teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                getItems(Events.players.getFirst());
                getItems(Events.players.getLast());

                ItemStack exit_duel = new ItemStack(Material.RED_BED);
                ItemMeta meta = exit_duel.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Вернуться на спавн");
                exit_duel.setItemMeta(meta);
                player.getInventory().setItem(8, exit_duel);

                player.setHealth(20);

                if (Events.players.size() == 2) {
                    Events.players.getFirst().getInventory().setItem(8, null);
                    Events.players.getLast().getInventory().setItem(8, null);
                    Events.players.getFirst().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                    Events.players.getLast().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                    Events.players.getFirst().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                    Events.players.getLast().teleport(new Location(world, 1.5, 103, -36.5, 0, 0));
                    System.out.println("----------");
//                    int timer = getScheduler().scheduleSyncRepeatingTask(Duels.duels, new Runnable() {
//                        @Override
//                        public void run() {
//                            getServer().broadcastMessage()
//                        }
//                    }, 0, 20);

                    getServer().dispatchCommand(getServer().getConsoleSender(), "gamemode survival " + Events.players.getFirst().getName());
                    getServer().dispatchCommand(getServer().getConsoleSender(), "gamemode survival " + Events.players.getLast().getName());

                    Events.players.getFirst().sendMessage("Дуэль начнется через 5 секунд!");
                    Events.players.getLast().sendMessage("Дуэль начнется через 5 секунд!");
                    int play = getScheduler().scheduleSyncDelayedTask(Duels.duels, new Runnable() {
                        @Override
                        public void run() {
//                            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + Events.players.getFirst().getName() + " -15 92 -52 -90 0");
//                            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + Events.players.getLast().getName() + " 16 92 -50 90 0");

                            Events.players.getFirst().getInventory().setItem(8, null);
                            Events.players.getLast().getInventory().setItem(8, null);

                            Events.players.getFirst().teleport(new Location(world, -14.5, 92, -37.5, -90, 0));
                            Events.players.getLast().teleport(new Location(world, 15.5, 92, -35.5, 90, 0));
                            Events.players.getFirst().teleport(new Location(world, -14.5, 92, -37.5, -90, 0));
                            Events.players.getLast().teleport(new Location(world, 15.5, 92, -35.5, 90, 0));


                        }
                    }, 100);
                    int test_void = getScheduler().scheduleSyncRepeatingTask(Duels.duels, new Runnable() {
                        @Override
                        public void run() {
                            if (Events.players.size() != 0) {
                                if (Events.players.getFirst().getLocation().getBlockY() < 75) {
                                    Events.players.getFirst().setHealth(0);
                                }
                                if (Events.players.getLast().getLocation().getBlockY() < 75) {
                                    Events.players.getLast().setHealth(0);
                                }
                            }
                        }
                    }, 0, 30);

//                    getServer().broadcastMessage("qqqq");
                }
            } else {
//                player.teleport(new Location(world, -15.5, 92, -51.5, -90, 0));
                player.sendMessage("Больше 2 игроков не могут участвовать! Ждите окончания битвы!");
            }

//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + Events.players.getFirst().getName() + " -15 92 -52");
//            getServer().dispatchCommand(getServer().getConsoleSender(), "tp " + Events.players.getLast().getName() + " 16 92 -50");

        }

        return true;
    }

    public static void getItems(Player player) {

//        getServer().dispatchCommand(getServer().getConsoleSender(), "clear " + player.getName());

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack shield = new ItemStack(Material.SHIELD);

        player.getInventory().setItem(0, null);
        player.getInventory().setItem(1, null);
        player.getInventory().setItem(3, null);
        player.getInventory().setItem(4, null);
        player.getInventory().setItem(8, null);

        player.getInventory().setItem(0, sword);
        player.getInventory().setItem(1, axe);
        player.getInventory().setItem(36, boots);
        player.getInventory().setItem(37, leggings);
        player.getInventory().setItem(38, chestplate);
        player.getInventory().setItem(39, helmet);
        player.getInventory().setItem(40, shield);

    }
}
