package rox.warpstone;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWarpPillar extends Block{
	//Note to self: finish this later when it can be registered and tested.
	
	//Some basic block stuff.
	protected BlockWarpPillar(Material material){
		super(material);
		//Harvest level of the block. 0 = wood/gold, 1 = stone, 2 = iron, 3 = diamond.
		//Setting this to 99 so it's only breakable in creative.
		this.setHarvestLevel("pickaxe", 99);
		//Block hitbox. Currently one full block. For reference, 1/16th of a block is 0.0625F
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.1875F, 1F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSolidFullCube(){
		return false;
	}
}
