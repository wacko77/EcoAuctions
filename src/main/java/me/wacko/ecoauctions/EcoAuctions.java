package me.wacko.ecoauctions;

import me.wacko.ecoauctions.command.AuctionCommand;
import me.wacko.ecoauctions.core.listener.AbstractListener;
import me.wacko.ecoauctions.manager.AuctionManager;
import me.wacko.ecoauctions.model.Auction;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class EcoAuctions extends JavaPlugin {

    private final List<Auction> activeAuctions = new ArrayList<>();
    private final AuctionManager am = new AuctionManager(this, activeAuctions);


    @Override
    public void onEnable() {

        getCommand("auctions").setExecutor(new AuctionCommand(this));

        getServer().getPluginManager().registerEvents(new AbstractListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public List<Auction> getActiveAuctions(){return activeAuctions;}

    public AuctionManager getAuctionManager(){return am;}
}
