package com.rox.gunpowder.init;

import com.rox.gunpowder.core;
import com.rox.gunpowder.reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoxItems {
	
	public static Item sulfur;
	public static Item potassium;
	public static Item salt;
	
	public static void init() {
		sulfur = new Item().setUnlocalizedName("sulfur").setCreativeTab(core.gunpowderTab);
		potassium = new Item().setUnlocalizedName("potassium").setCreativeTab(core.gunpowderTab);
		salt = new Item().setUnlocalizedName("salt").setCreativeTab(core.gunpowderTab);
	}
	
	public static void register() {
		GameRegistry.registerItem(sulfur, sulfur.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(potassium, potassium.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(salt, salt.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(sulfur);
		registerRender(potassium);
		registerRender(salt);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
