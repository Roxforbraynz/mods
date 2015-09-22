package pnb.orp;

import java.util.HashMap;

import javax.annotation.Resource;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import pnb.orp.proxy.CommonProxy;

@Mod(
	modid = "orpcore",
	name = "OpenRP Core",
	version = "0.1.0a"
)

public class Core {
	@SidedProxy (
		clientSide = "pnb.orp.proxy.ClientProxy",
		serverSide = "pnb.orp.proxy.CommonProxy"
	)
	public CommonProxy proxy;
	
	//Our little collection of custom items for quick lookup.
	@Resource
	public HashMap<String,Item> customItems;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
