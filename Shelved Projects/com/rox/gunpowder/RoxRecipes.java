package com.rox.gunpowder;

import com.rox.gunpowder.init.RoxItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoxRecipes {
	public static void setRecipes() {
		GameRegistry.addShapelessRecipe(
			//Result
			new ItemStack(Items.gunpowder,2),
			//Ingredients
			new ItemStack(RoxItems.sulfur),
			new ItemStack(RoxItems.potassium),
			new ItemStack(Items.coal)
		);
		GameRegistry.addShapedRecipe(
			//Result
			new ItemStack(Blocks.torch,4),
			//Ingredients
			"A ",
			"B ",
			'A',RoxItems.sulfur, 'B',Items.stick
		);
		GameRegistry.addSmelting(
			//Ingredients
			new ItemStack(Items.potionitem, 0),
			//Result
			new ItemStack(RoxItems.salt),
			//Experience
			0f
		);
		GameRegistry.addShapelessRecipe(
			//Result
			new ItemStack(Items.leather),
			//Ingredients
			new ItemStack(Items.rotten_flesh),
			new ItemStack(Items.rotten_flesh),
			new ItemStack(RoxItems.salt)
		);
	}
}
