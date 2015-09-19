package rox.mythril;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mythril.blocks.MythrilBlock;
import rox.mythril.blocks.MythrilOre;
import rox.mythril.items.MythrilIngot;

public class Recipies {
	public static void setRecipies(){
		GameRegistry.addSmelting(MythrilOre.mythril_ore, new ItemStack(MythrilIngot.mythril_ingot), 1.5f);
		GameRegistry.addShapedRecipe(new ItemStack(Armory.mythril_pickaxe), new Object[] {"MMM"," S "," S ",'M',MythrilIngot.mythril_ingot,'S',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(Armory.mythril_axe), new Object[] {"MM ","MS "," S ",'M',MythrilIngot.mythril_ingot,'S',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(Armory.mythril_shovel), new Object[] {" M "," S "," S ",'M',MythrilIngot.mythril_ingot,'S',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(Armory.mythril_hoe), new Object[] {"MM "," S "," S ",'M',MythrilIngot.mythril_ingot,'S',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(Armory.mythril_sword), new Object[] {" M "," M "," S ",'M',MythrilIngot.mythril_ingot,'S',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(MythrilBlock.mythril_block), new Object[] {"MMM","MMM","MMM",'M',MythrilIngot.mythril_ingot});
		GameRegistry.addShapelessRecipe(new ItemStack(MythrilIngot.mythril_ingot, 9), MythrilBlock.mythril_block);
	}
}
