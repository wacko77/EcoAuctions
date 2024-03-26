package me.wacko.ecoauctions.gui.comp;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.gui.AuctionGUI;
import me.wacko.ecoauctions.model.Auction;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActiveAuctionsGUI extends AbstractGUI {

    public ActiveAuctionsGUI(EcoAuctions plugin) {
        super(9*6, "Active Auctions");
        int slotIndex = 0;
        List<Auction> activeAuctions = plugin.getActiveAuctions();


        ItemStack item = createItem();
        setItem(0, item);

        ItemStack backButton = ItemStackUtil.getItem(ChatColor.DARK_RED + "Back", Material.BARRIER, Collections.singletonList(""));
        setItem(53, backButton, player -> {
            AuctionGUI aGUI = new AuctionGUI(plugin);
            aGUI.open(player);
        });
    }

    private ItemStack createItem() {
        List<String> lore = getLore();
        ItemStack item = ItemStackUtil.getItem(ChatColor.AQUA + "Placeholder Auction", Material.DIAMOND_CHESTPLATE, lore);

        return item;
    }

    private List<String> getLore() {
        List<String> lore = new ArrayList<>();

        //ItemStack item = auction.getItem();
        //Player host = auction.getHost();

        lore.add("");
        lore.add(ChatColor.DARK_GREEN + "Seller: " + ChatColor.GRAY + "wacko__");
        lore.add(ChatColor.DARK_GREEN + "Bids: " + ChatColor.GRAY + "0");
        lore.add("");
        lore.add(ChatColor.DARK_GREEN + "Bid Price: " + ChatColor.GRAY + "$5,000");
        lore.add(ChatColor.DARK_GREEN + "Bid Holder: " + ChatColor.GRAY + "Xx_anonymous_xX");
        lore.add("");
        lore.add(ChatColor.DARK_GREEN + "Buy it Now Price: " + ChatColor.GRAY + "$10,000");
        lore.add("");
        lore.add(ChatColor.DARK_GREEN + "Time Left: " + ChatColor.GRAY + "1m");
        lore.add("");
        lore.add(ChatColor.GOLD + "Click to bid on auction!");

        return lore;
    }

}
