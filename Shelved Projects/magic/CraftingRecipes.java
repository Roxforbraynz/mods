package rox.magic;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.magic.items.ArcaneCrystal;

public class CraftingRecipes {
	public static void setRecipies() {
		GameRegistry.addRecipe(
			new ItemStack(Items.experience_bottle),
			"C ",
			"B ",
			'C', ArcaneCrystal.arcane_crystal,
			'B', Items.glass_bottle);
	}
}
