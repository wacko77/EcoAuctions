package me.wacko.ecoauctions.gui.comp;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.manager.AuctionManager;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.atomic.AtomicBoolean;

public class CreateAuctionGUI extends AbstractGUI {

    public CreateAuctionGUI(EcoAuctions plugin) {
        super(9*6, "Auction Creation");
        AtomicBoolean itemSet = new AtomicBoolean(true);
        AuctionManager am = plugin.getAuctionManager();

        if (!itemSet.get()) {
            setItem(13, new ItemStack(Material.STONE_BUTTON));
            setItem(29, new ItemStack(Material.RED_WOOL));



        } else {
            //setItem(13, clickedItemFromInventory, player -> {
            // todo: remove from gui back into player inv
            //});

            ItemStack startAuction = ItemStackUtil.setItemMeta(ChatColor.GREEN + "Start the Auction!", Material.GREEN_WOOL, "Click on the green wool block to start your auction!\nMake sure your auction details are what you want.");

            setItem(29, startAuction, player -> {
                am.createAuction(new ItemStack(Material.GOLDEN_CARROT), player, 60);
                //itemSet.set(true);
            });
        }

    }

}
