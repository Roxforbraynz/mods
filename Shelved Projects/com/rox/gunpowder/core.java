package com.rox.gunpowder;

import com.rox.gunpowder.init.RoxBlocks;
import com.rox.gunpowder.init.RoxItems;
import com.rox.gunpowder.proxy.CommonProxy;

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

@Mod(modid = reference.MODID, name = reference.MODNAME, version = reference.VERSION)

public class core {
	
	public static final Tab gunpowderTab = new Tab("gunpowderTab");
	
	@SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS, serverSide = reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RoxBlocks.init();
		RoxBlocks.register();
		RoxItems.init();
		RoxItems.register();
		RoxRecipes.setRecipes();
		RoxBlocks.sulfur_ore.setHarvestLevel("pickaxe", 1);
		RoxBlocks.potassium_ore.setHarvestLevel("pickaxe", 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
