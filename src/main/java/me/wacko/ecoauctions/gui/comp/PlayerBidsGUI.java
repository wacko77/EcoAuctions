package me.wacko.ecoauctions.gui.comp;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.core.gui.AbstractGUI;
import me.wacko.ecoauctions.gui.AuctionGUI;
import me.wacko.ecoauctions.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class PlayerBidsGUI extends AbstractGUI {

    public PlayerBidsGUI(EcoAuctions plugin) {
        super(9*3, "Your Bids");

        ItemStack nothingYet = ItemStackUtil.getItem(ChatColor.RED + "Nothing Yet!", Material.BEDROCK, Collections.singletonList(""));
        setItem(13, nothingYet);

        ItemStack backButton = ItemStackUtil.getItem(ChatColor.DARK_RED + "Back", Material.BARRIER, Collections.singletonList(""));
        setItem(26, backButton, player -> {
            AuctionGUI aGUI = new AuctionGUI(plugin);
            aGUI.open(player);
        });
    }

}
