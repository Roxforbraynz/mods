package rox.lootpiles;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.lootpiles.proxy.CommonProxy;

@Mod (
	modid = Info.ID,
	name = Info.Name,
	version = Info.Vers
)

public class Core {
	
	@SidedProxy (
		clientSide = "rox.lootpiles.proxy.ClientProxy",
		serverSide = "rox.lootpiles.proxy.CommonProxy"
	)
	//This MUST remain static. Game will crash if it's not.
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
