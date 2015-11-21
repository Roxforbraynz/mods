package rox.orechunks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.orechunks.proxy.CommonProxy;

@Mod(
	modid = "orechunks",
	name = "Ore Chunks",
	version = "v1"
)

public class Core {
	@SidedProxy (
		clientSide = "rox.orechunks.proxy.ClientProxy",
		serverSide = "rox.orechunks.proxy.CommonProxy"
	)
	//Keep this static
	private static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
