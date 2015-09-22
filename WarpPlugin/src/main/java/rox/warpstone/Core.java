package rox.warpstone;

import com.google.inject.Inject;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.warpstone.proxy.CommonProxy;
import rox.warpstone.services.ItemService;

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
	private CommonProxy proxy;
	
	@Inject
	ItemService is;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		//Initialize and register our custom item
		is.registerItem("warp_stone", new ItemWarpStone());

		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Sets the item's model and texture.
		//This is done after the item has been initialized.
		proxy.setRenders();
		//Sets the crafting recipes.
		GameRegistry.addShapelessRecipe(
				//This is the output, the Warp Stone.
				new ItemStack(is.getItem("warp_stone")),
				
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
