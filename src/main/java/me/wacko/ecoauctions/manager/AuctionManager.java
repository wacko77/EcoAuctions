package me.wacko.ecoauctions.manager;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.model.Auction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class AuctionManager {

    private final EcoAuctions plugin;
    private int nextId;
    private final List<Auction> activeAuctions;

    public AuctionManager(EcoAuctions plugin, List<Auction> activeAuctions) {
        this.plugin = plugin;
        this.activeAuctions = activeAuctions;
    }

    public void createAuction(ItemStack item, Player host, long duration) {
        Auction auction = new Auction(item, nextId++, host, duration);

        activeAuctions.add(auction);
        // todo: save to file

        auction.start();

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> end(auction), duration * 20);
    }



    public void end(Auction auction) {
        // todo: give host their item back if no bids were made
    }

}
