package rox.arcvol.items;

import net.minecraft.item.Item;
import rox.arcvol.Core;
import rox.base.Methods;

public class InertEssence extends Item{
	public static Item inert_essence;
	
	public static void init(){
		inert_essence = new Item()
			.setUnlocalizedName("inert_essence")
			.setMaxStackSize(64)
			.setCreativeTab(Core.tabArcvol);
		
		Methods.registerItem(inert_essence);
	}
}
