package me.wacko.ecoauctions.gui.comp;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.model.Auction;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ActiveAuctionsGUI extends AbstractGUI {

    public ActiveAuctionsGUI(EcoAuctions plugin) {
        super(9*6, "Active Auctions");
        int slotIndex = 0;
        List<Auction> activeAuctions = plugin.getActiveAuctions();

        if (activeAuctions != null) {
            for (Auction auction : activeAuctions) {
                ItemStack item = createItem(auction);
                setItem(slotIndex++, item, player -> {
                    player.sendMessage("Entered Auction!");
                });
            }
        }
    }

    private ItemStack createItem(Auction auction) {
        List<String> lore = getLore(auction);
        ItemStack item = ItemStackUtil.setItemMeta(auction.getItem().getType().toString(), auction.getItem().getType(), lore.toString());

        return item;
    }

    private List<String> getLore(Auction auction) {
        List<String> lore = new ArrayList<>();

        ItemStack item = auction.getItem();
        Player host = auction.getHost();

        lore.add("Item for auction: " + item);
        lore.add("Auction host: " + host);

        return lore;
    }

}
