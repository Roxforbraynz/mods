package rox.leather;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StitchedFlesh extends Item {
	public static Item stitched_flesh;
	
	public static void init(){
		stitched_flesh = new Item()
			.setUnlocalizedName("stitched_flesh")
			.setMaxStackSize(64)
			.setCreativeTab(CreativeTabs.tabMaterials);
		
		GameRegistry.registerItem(stitched_flesh, stitched_flesh.getUnlocalizedName().substring(5));
	}
}
