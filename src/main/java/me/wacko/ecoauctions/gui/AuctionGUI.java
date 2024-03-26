package me.wacko.ecoauctions.gui;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.gui.comp.ActiveAuctionsGUI;
import me.wacko.ecoauctions.gui.comp.CreateAuctionGUI;
import me.wacko.ecoauctions.gui.comp.PlayerBidsGUI;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AuctionGUI extends AbstractGUI {

    public AuctionGUI(EcoAuctions plugin) {
        super(InventoryType.HOPPER, "Auctions");

        List<String> aaLore = getAALore();
        ItemStack aaItem = ItemStackUtil.getItem(ChatColor.GREEN + "Active Auctions", Material.CLOCK, aaLore);
        setItem(0, aaItem, player -> {
            ActiveAuctionsGUI aaGUI = new ActiveAuctionsGUI(plugin);
            aaGUI.open(player);
        });

        List<String> pbLore = getPBLore();
        ItemStack pbItem = ItemStackUtil.getItem(ChatColor.GREEN + "View your bids!", Material.NAME_TAG, pbLore);
        setItem(2, pbItem, player -> {
            PlayerBidsGUI pbGUI = new PlayerBidsGUI(plugin);
            pbGUI.open(player);
        });

        List<String> caLore = getCALore();
        ItemStack caItem = ItemStackUtil.getItem(ChatColor.GREEN + "Create Auction!", Material.GOLDEN_AXE, caLore);
        setItem(4, caItem, player -> {
            CreateAuctionGUI caGUI = new CreateAuctionGUI(plugin);
            caGUI.open(player);
        });

    }

    private List<String> getAALore() {
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + "Find items for sale in Active Auctions!");
        lore.add("");
        lore.add(ChatColor.GRAY + "Auctions you find here are created");
        lore.add(ChatColor.GRAY + "by players and you need to win the");
        lore.add(ChatColor.GRAY + "top bid to obtain the item!");
        lore.add("");
        lore.add(ChatColor.GOLD + "Click to Browse!");

        return lore;
    }

    private List<String> getPBLore() {
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + "View and manage your bids.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Click to view!");

        return lore;
    }

    private List<String> getCALore() {
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + "Create your own auction to");
        lore.add(ChatColor.GRAY + "put in active auctions.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Click to create an auction!");

        return lore;
    }

}
