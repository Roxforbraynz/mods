package rox.warpstone;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting{
	//In here, I add all the crafting recipes.
	public static void setCrafting(){
		//Register a shapeless recipe.
		GameRegistry.addShapelessRecipe(
			//This is the output, the Warp Stone.
			new ItemStack(ItemWarpStone.warp_stone),
			
			//These are the ingredients for it.
			Items.ender_pearl,
			Items.redstone,
			Items.glowstone_dust);
	}
}
