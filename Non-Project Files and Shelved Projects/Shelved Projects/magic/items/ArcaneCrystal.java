package rox.magic.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.magic.Info;

public class ArcaneCrystal extends Item {
	public static Item arcane_crystal;
	
	public static void ArcaneCrystalStuff() {
		//Sets properties for the item
		arcane_crystal = new Item()
			.setUnlocalizedName("arcane_crystal")
			.setMaxStackSize(64)
			.setCreativeTab(CreativeTabs.tabMaterials);
		
		//Registers the item into the game
		GameRegistry.registerItem(arcane_crystal, arcane_crystal.getUnlocalizedName().substring(5));
	}
	
	public static void itemRender(Item item) { //Render an item
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Info.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
