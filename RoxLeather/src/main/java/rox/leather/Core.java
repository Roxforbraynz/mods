package rox.leather;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.leather.proxy.CommonProxy;

@Mod(name = Info.name,
	 modid = Info.id,
	 version = Info.vers)

public class Core {
	@SidedProxy(
		clientSide = Info.client,
		serverSide = Info.server
	)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		StitchedFlesh.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.setRenders();
		GameRegistry.addRecipe(
			new ItemStack(StitchedFlesh.stitched_flesh), //Result
			" F ",
			"FSF",
			" F ",
			'F', Items.rotten_flesh,
			'S', Items.string
		);
		GameRegistry.addSmelting(
			new ItemStack(StitchedFlesh.stitched_flesh), //Input
			new ItemStack(Items.leather), //Result
			0.1F //XP given. Iron Ore is 0.7F.
		);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
