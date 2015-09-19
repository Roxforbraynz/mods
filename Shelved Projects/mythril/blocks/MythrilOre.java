package rox.mythril.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mythril.Info;
import rox.mythril.RoxMethods;

public class MythrilOre extends Block{
	protected MythrilOre(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public static Block mythril_ore;
	
	public static void MythrilOreStuff(){
		mythril_ore = new MythrilOre
			(Material.rock)
			.setHardness(15.0f)
			.setUnlocalizedName("mythril_ore")
			.setCreativeTab(CreativeTabs.tabBlock);
		
		RoxMethods.registerBlock(mythril_ore);
	}
}
