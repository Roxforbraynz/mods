package rox.arcane;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.arcane.blocks.ArcaneOre;
import rox.arcane.proxy.CommonProxy;

@Mod(modid = Info.modid, name = Info.name, version = Info.version)

public class Core {
	
	@SidedProxy(clientSide = Info.clientProxy, serverSide = Info.serverProxy)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ArcaneOre.ArcaneOreSetup();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
