package rox.arcvol.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import rox.arcvol.Core;
import rox.base.Methods;

public class WeakFireEssence extends Item{
	public static Item weak_fire_essence;
	
	public static void init(){
		weak_fire_essence = new WeakFireEssence()
			.setUnlocalizedName("weak_fire_essence")
			.setMaxStackSize(1)
			.setMaxDamage(15)
			.setCreativeTab(Core.tabArcvol);
		
		Methods.registerItem(weak_fire_essence);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		pos = pos.offset(side);
		
		//Fix this later. It currently only does the center block.
		for(int z = -1; z <= 1; z++){
			for(int y = -1; y <= 1; y++){
				for(int x = -1; x <= 1; x++){
					BlockPos curPos = pos;
					curPos.add(x, y, z);
					
					if(world.isAirBlock(curPos)){
						world.setBlockState(curPos, Blocks.fire.getDefaultState());
					}
				}
			}
		}
		
		
		stack.damageItem(1, player);
		return true;
		
		//This is an abomination and I should be ashamed. I'm leaving this here as a monument to my sins.
		/*pos = pos.offset(side);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		IBlockState fire = Blocks.fire.getDefaultState();
		
		if(world.isAirBlock(pos)){
			world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.fire", 1F, 0.4F);
			world.setBlockState(pos, fire);
			if(world.isAirBlock(pos.up())){
				world.setBlockState(pos.up(), fire);
			}
			if(world.isAirBlock(pos.up().north())){
				world.setBlockState(pos.up().north(), fire);
			}
			if(world.isAirBlock(pos.up().north().east())){
				world.setBlockState(pos.up().north().east(), fire);
			}
			if(world.isAirBlock(pos.up().north().west())){
				world.setBlockState(pos.up().north().west(), fire);
			}
			if(world.isAirBlock(pos.up().east())){
				world.setBlockState(pos.up().east(), fire);
			}
			if(world.isAirBlock(pos.up().west())){
				world.setBlockState(pos.up().west(), fire);
			}
			if(world.isAirBlock(pos.up().south())){
				world.setBlockState(pos.up().south(), fire);
			}
			if(world.isAirBlock(pos.up().south().east())){
				world.setBlockState(pos.up().south().east(), fire);
			}
			if(world.isAirBlock(pos.up().south().west())){
				world.setBlockState(pos.up().south().west(), fire);
			}
			if(world.isAirBlock(pos.down())){
				world.setBlockState(pos.down(), fire);
			}
			if(world.isAirBlock(pos.down().north())){
				world.setBlockState(pos.down().north(), fire);
			}
			if(world.isAirBlock(pos.down().north().east())){
				world.setBlockState(pos.down().north().east(), fire);
			}
			if(world.isAirBlock(pos.down().north().west())){
				world.setBlockState(pos.down().north().west(), fire);
			}
			if(world.isAirBlock(pos.down().east())){
				world.setBlockState(pos.down().east(), fire);
			}
			if(world.isAirBlock(pos.down().west())){
				world.setBlockState(pos.down().west(), fire);
			}
			if(world.isAirBlock(pos.down().south())){
				world.setBlockState(pos.down().south(), fire);
			}
			if(world.isAirBlock(pos.down().south().east())){
				world.setBlockState(pos.down().south().east(), fire);
			}
			if(world.isAirBlock(pos.down().south().west())){
				world.setBlockState(pos.down().south().west(), fire);
			}
			if(world.isAirBlock(pos.north())){
				world.setBlockState(pos.north(), fire);
			}
			if(world.isAirBlock(pos.north().east())){
				world.setBlockState(pos.north().east(), fire);
			}
			if(world.isAirBlock(pos.north().west())){
				world.setBlockState(pos.north().west(), fire);
			}
			if(world.isAirBlock(pos.south())){
				world.setBlockState(pos.south(), fire);
			}
			if(world.isAirBlock(pos.south().east())){
				world.setBlockState(pos.south().east(), fire);
			}
			if(world.isAirBlock(pos.south().west())){
				world.setBlockState(pos.south().west(), fire);
			}
			if(world.isAirBlock(pos.east())){
				world.setBlockState(pos.east(), fire);
			}
			if(world.isAirBlock(pos.west())){
				world.setBlockState(pos.west(), fire);
			}
		}*/
	}
}
