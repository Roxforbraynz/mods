package rox.warpstone;

import java.util.HashMap;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.warpstone.proxy.CommonProxy;

@Mod(
	modid = "warpstone",
	name = "Rox's Warp Stones",
	version = "v1"
)

public class Core {
	@SidedProxy (
		clientSide = "rox.warpstone.proxy.ClientProxy",
		serverSide = "rox.warpstone.proxy.CommonProxy"
	)
	public static CommonProxy proxy;
	
	//Our little collection of custom items for quick lookup.
	public HashMap<String,Item> customItems;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Initialize our custom item
		customItems.put("warp_stone", new ItemWarpStone());

		
		//Registering the item.
		GameRegistry.registerItem(customItems.get("warp_stone"), "warp_stone");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Sets the item's model and texture.
		//This is done after the item has been initialized.
		proxy.setRenders(customItems);
		//Sets the crafting recipes.
		GameRegistry.addShapelessRecipe(
				//This is the output, the Warp Stone.
				new ItemStack(customItems.get("warp_stone")),
				
				//These are the ingredients for it.
				Items.ender_pearl,
				Items.redstone,
				Items.glowstone_dust);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//There's nothing to do here. This remains blank.
	}
}
