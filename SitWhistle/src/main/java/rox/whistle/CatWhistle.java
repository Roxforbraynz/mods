package rox.whistle;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CatWhistle extends Item{
	public static Item cat_whistle;
	
	public static void init(){
		cat_whistle = new CatWhistle()
			.setUnlocalizedName("cat_whistle")
			.setMaxStackSize(1)
			.setCreativeTab(CreativeTabs.tabTools);
		
		GameRegistry.registerItem(cat_whistle, cat_whistle.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		@SuppressWarnings("unchecked")
		List<EntityOcelot> e = player.worldObj.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.fromBounds(player.posX - 6, player.posY - 3, player.posZ - 6, player.posX + 6, player.posY + 3, player.posZ + 6));
		
		if(e.isEmpty()){
			if(!player.worldObj.isRemote){
				player.addChatMessage(new ChatComponentText("No cats within range."));
			}
		}
		else if(!player.isSneaking()){
			world.playSoundAtEntity(player, Info.id + ":item.whistle", 1.0F, 1.0F);
			for(EntityOcelot cat : e){
				if(cat.isTamed() && cat.isOwner(player) && cat.isSitting()){
					cat.setSitting(false);
				}
			}
		}
		else if(player.isSneaking()){
			world.playSoundAtEntity(player, Info.id + ":item.whistle", 1.0F, 1.0F);
			for(EntityOcelot cat : e){
				if(cat.isTamed() && cat.isOwner(player) && !cat.isSitting()){
					cat.setSitting(true);
				}
			}
		}
		
		return stack;
	}
}
