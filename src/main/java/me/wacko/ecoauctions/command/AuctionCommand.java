package me.wacko.ecoauctions.command;

import me.wacko.ecoauctions.EcoAuctions;
import me.wacko.ecoauctions.gui.AuctionGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor {

    private final EcoAuctions plugin;

    public AuctionCommand(EcoAuctions plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command!");
        }

        Player player = (Player) sender;

        AuctionGUI aGUI = new AuctionGUI(plugin);
        aGUI.open(player);

        return true;
    }

}
