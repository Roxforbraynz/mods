package rox.arcvol;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.arcvol.items.InertEssence;
import rox.arcvol.items.WeakEnderEssence;
import rox.arcvol.items.WeakFireEssence;

public class Crafting{
	public static void setCrafting(){
		GameRegistry.addShapelessRecipe(new ItemStack(InertEssence.inert_essence, 2), Items.redstone, Items.glowstone_dust);
		GameRegistry.addShapelessRecipe(new ItemStack(WeakFireEssence.weak_fire_essence), InertEssence.inert_essence, Items.coal);
		GameRegistry.addShapelessRecipe(new ItemStack(WeakEnderEssence.weak_ender_essence), InertEssence.inert_essence, Items.ender_pearl);
	}
}
