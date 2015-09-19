package com.rox.gunpowder.init;

import com.rox.gunpowder.core;
import com.rox.gunpowder.reference;
import com.rox.gunpowder.blocks.roxBlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoxBlocks {
	
	public static Block sulfur_ore;
	public static Block potassium_ore;
	
	public static void init() {
		sulfur_ore = new roxBlockBase(Material.rock).setUnlocalizedName("sulfur_ore").setCreativeTab(core.gunpowderTab);
		potassium_ore = new roxBlockBase(Material.rock).setUnlocalizedName("potassium_ore").setCreativeTab(core.gunpowderTab);
	}
	
	public static void register() {
		GameRegistry.registerBlock(sulfur_ore, sulfur_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(potassium_ore, potassium_ore.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(sulfur_ore);
		registerRender(potassium_ore);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
