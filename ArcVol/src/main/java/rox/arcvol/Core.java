package rox.arcvol;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.arcvol.items.InertEssence;
import rox.arcvol.items.WeakEnderEssence;
import rox.arcvol.items.WeakFireEssence;
import rox.arcvol.proxy.CommonProxy;

@Mod(
	name = "Essentia Arcanum",
	modid = "arcvol",
	version = "Alpha 1"
)

public class Core{
	@SidedProxy(
		clientSide="rox.arcvol.proxy.ClientProxy",
		serverSide="rox.arcvol.proxy.CommonProxy"
	)
	public static CommonProxy proxy;
	
	public static final ArcvolTab tabArcvol = new ArcvolTab("tabArcvol");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		InertEssence.init();
		WeakFireEssence.init();
		WeakEnderEssence.init();
	}
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		Crafting.setCrafting();
		proxy.setRenders();
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
