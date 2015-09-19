package rox.mythril.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MythrilBlock extends Block{
	protected MythrilBlock(Material materialIn){
		super(materialIn);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	public static Block mythril_block;
	
	public static void MythrilBlockStuff(){
		mythril_block = new MythrilBlock(Material.iron)
			.setHardness(5.0f)
			.setUnlocalizedName("mythril_block")
			.setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerBlock(mythril_block, mythril_block.getUnlocalizedName().substring(5));
	}
}
