package me.wacko.ecoauctions.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.ChatPaginator;

import java.util.Arrays;
import java.util.List;

public class ItemStackUtil {

    public static ItemStack setItemMeta(String name, Material mat, String lore) {

        ItemStack i = new ItemStack(mat);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        meta.setLore(Arrays.asList(ChatPaginator.wordWrap(lore, 35)));

        i.setItemMeta(meta);

        return i;

    }

    public static ItemStack getItem(String name, Material mat, List<String> lore){

        ItemStack i = new ItemStack(mat);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setLore(lore);

        i.setItemMeta(meta);

        return i;
    }

    public static ItemStack getItem(String name, Material mat, int amount, List<String> lore) {
        ItemStack i = new ItemStack(mat, amount);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        meta.setLore(lore);

        i.setItemMeta(meta);

        return i;
    }

}
