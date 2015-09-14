package rox.warpstone;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.warpstone.proxy.CommonProxy;

@Mod(
	modid = "warpstone",
	name = "Rox's Warp Stones",
	version = "v1"
)

public class Core{
	@SidedProxy(
		clientSide = "rox.warpstone.proxy.ClientProxy",
		serverSide = "rox.warpstone.proxy.CommonProxy"
	)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Initializes the item.
		ItemWarpStone.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//Sets the item's model and texture.
		//This is done after the item has been initialized.
		proxy.setRenders();
		//Sets the crafting recipes.
		Crafting.setCrafting();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//There's nothing to do here. This remains blank.
	}
}
