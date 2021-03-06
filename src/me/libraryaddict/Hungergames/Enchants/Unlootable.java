package me.libraryaddict.Hungergames.Enchants;

import me.libraryaddict.Hungergames.Types.HungergamesApi;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Unlootable extends Enchantment {

    public Unlootable(int id) {
        super(id);
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public String getName() {
        return HungergamesApi.getChatManager().getEnchantNameUnlootable();
    }

    @Override
    public int getStartLevel() {
        return 1;
    }
}
