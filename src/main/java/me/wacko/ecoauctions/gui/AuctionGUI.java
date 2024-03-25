package me.wacko.ecoauctions.gui;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.gui.comp.ActiveAuctionsGUI;
import me.wacko.ecoauctions.gui.comp.CreateAuctionGUI;
import me.wacko.ecoauctions.gui.comp.PlayerBidsGUI;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AuctionGUI extends AbstractGUI {

    public AuctionGUI(EcoAuctions plugin) {
        super(9*3, "Auctions");

        List<String> aaLore = getAALore();
        ItemStack aaItem = ItemStackUtil.setItemMeta(ChatColor.GOLD + "Active Auctions", Material.GOLD_BLOCK, aaLore.toString());
        setItem(11, aaItem, player -> {
            ActiveAuctionsGUI aaGUI = new ActiveAuctionsGUI(plugin);
            aaGUI.open(player);
        });

        List<String> pbLore = getPBLore();
        ItemStack pbItem = ItemStackUtil.setItemMeta(ChatColor.GREEN + "View your bids!", Material.GOLDEN_CARROT, pbLore.toString());
        setItem(13, pbItem, player -> {
            PlayerBidsGUI pbGUI = new PlayerBidsGUI();
            pbGUI.open(player);
        });

        List<String> caLore = getCALore();
        ItemStack caItem = ItemStackUtil.setItemMeta(ChatColor.GREEN + "Create Auction!", Material.GOLDEN_HORSE_ARMOR, caLore.toString());
        setItem(15, caItem, player -> {
            CreateAuctionGUI caGUI = new CreateAuctionGUI(plugin);
            caGUI.open(player);
        });

    }

    private List<String> getAALore() {
        List<String> lore = new ArrayList<>();

        lore.add("Find items for sale in Active Auctions!");
        lore.add("\n\n");
        lore.add("Auctions you find here are created");
        lore.add("by players and you need to win the");
        lore.add("top bid to obtain the item!");
        lore.add(ChatColor.GOLD + "Click to Browse!");

        return lore;
    }

    private List<String> getPBLore() {
        List<String> lore = new ArrayList<>();

        lore.add("View and manage your bids.");
        lore.add("\n\n");
        lore.add(ChatColor.YELLOW + "Click to view!");

        return lore;
    }

    private List<String> getCALore() {
        List<String> lore = new ArrayList<>();

        lore.add("Create your own auction to put");
        lore.add("in active auctions.");
        lore.add("\n\n");
        lore.add(ChatColor.YELLOW + "Click to create an auction!");

        return lore;
    }

}
