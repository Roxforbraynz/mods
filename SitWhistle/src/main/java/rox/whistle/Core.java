package rox.whistle;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.whistle.proxy.CommonProxy;

@Mod(name = Info.name,
	 modid = Info.id,
	 version = Info.vers)

public class Core {
	@SidedProxy(clientSide = Info.client, serverSide = Info.server)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		DogWhistle.init();
		CatWhistle.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.setRenders();
		GameRegistry.addShapelessRecipe(new ItemStack(DogWhistle.dog_whistle), Items.bone, Items.iron_ingot, Blocks.wooden_button);
		GameRegistry.addShapelessRecipe(new ItemStack(CatWhistle.cat_whistle), Items.fish, Items.iron_ingot, Blocks.wooden_button);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
