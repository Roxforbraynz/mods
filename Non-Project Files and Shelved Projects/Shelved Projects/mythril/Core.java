package rox.mythril;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mythril.blocks.MythrilBlock;
import rox.mythril.blocks.MythrilOre;
import rox.mythril.items.MythrilIngot;
import rox.mythril.proxy.CommonProxy;

@Mod(modid=Info.modid,name=Info.name,version=Info.version)

public class Core {
	@SidedProxy(clientSide=Info.client,serverSide=Info.server)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		MythrilOre.MythrilOreStuff();
		MythrilBlock.MythrilBlockStuff();
		MythrilIngot.MythrilIngotStuff();
		Armory.MythrilStuff();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		Recipies.setRecipies();
		proxy.setRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
