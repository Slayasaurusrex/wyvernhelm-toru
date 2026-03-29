package com.wyvernhelm.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(MenuPlugin.MENU_TITLE)) return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null) return;

        ItemStack item = event.getCurrentItem();

        if (item.getItemMeta() == null) return;

        Player player = (Player) event.getWhoClicked();

        if (item.getItemMeta().getDisplayName().equals("§aSay Hello")) {

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "broadcast hello");

            player.closeInventory();
        }
    }
}