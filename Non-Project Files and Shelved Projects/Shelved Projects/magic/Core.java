package rox.magic;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.magic.blocks.ArcaneCrystalOre;
import rox.magic.items.ArcaneCrystal;
import rox.magic.proxy.CommonProxy;

@Mod(modid = Info.MODID, name = Info.NAME, version = Info.VERSION)

public class Core {
	
	@SidedProxy(clientSide = Info.CLIENTPROXY, serverSide = Info.SERVERPROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item functions; Removing an item here will stop it from loading into the game
		ArcaneCrystal.ArcaneCrystalStuff();
		//Block functions; see above
		ArcaneCrystalOre.ArcaneCrystalOreStuff();
		//Crafting recipes
		CraftingRecipes.setRecipies();
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.setRenders();
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
