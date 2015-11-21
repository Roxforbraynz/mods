package rox.mystic;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.mystic.proxy.CommonProxy;

@Mod(
	name = Info.name,
	modid = Info.id,
	version = Info.vers
)

public class Core {
	@SidedProxy(
		clientSide = Info.client,
		serverSide = Info.server
	)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.setRenders();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
