package com.wyvernhelm.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class MenuPlugin extends JavaPlugin {

    public static final String MENU_TITLE = "My Menu";

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!command.getName().equalsIgnoreCase("menu")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players!");
            return true;
        }

        Player player = (Player) sender;

        openMenu(player);
        return true;
    }

    public void openMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, MENU_TITLE);

        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aSay Hello");
        meta.setLore(Arrays.asList("§7Click me"));
        item.setItemMeta(meta);

        gui.setItem(22, item);

        player.openInventory(gui);
    }
}