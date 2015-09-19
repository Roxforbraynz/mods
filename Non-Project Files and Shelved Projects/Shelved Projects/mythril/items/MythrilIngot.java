package rox.mythril.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mythril.Info;
import rox.mythril.RoxMethods;

public class MythrilIngot extends Item{
	public static Item mythril_ingot;
	
	public static void MythrilIngotStuff(){
		mythril_ingot = new Item()
			.setUnlocalizedName("mythril_ingot")
			.setMaxStackSize(64)
			.setCreativeTab(CreativeTabs.tabMaterials);
		
		RoxMethods.registerItem(mythril_ingot);
	}
}
