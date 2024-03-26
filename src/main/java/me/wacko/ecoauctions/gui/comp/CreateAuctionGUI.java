package me.wacko.ecoauctions.gui.comp;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.gui.AuctionGUI;
import me.wacko.ecoauctions.manager.AuctionManager;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreateAuctionGUI extends AbstractGUI {

    public CreateAuctionGUI(EcoAuctions plugin) {
        super(9*6, "Auction Creation");
        AuctionManager am = plugin.getAuctionManager();

        //setItem(13, new ItemStack(Material.STONE_BUTTON));
        //setItem(29, new ItemStack(Material.RED_WOOL));

        //setItem(13, clickedItemFromInventory, player -> {
        // todo: remove from gui back into player inv
        //});
        ItemStack startAuction = ItemStackUtil.setItemMeta(ChatColor.RED + "Nothing Yet!", Material.BEDROCK, "");
        setItem(13, startAuction);

        ItemStack backButton = ItemStackUtil.getItem(ChatColor.DARK_RED + "Back", Material.BARRIER, Collections.singletonList(""));
        setItem(53, backButton, player -> {
            AuctionGUI aGUI = new AuctionGUI(plugin);
            aGUI.open(player);
        });


    }

}
