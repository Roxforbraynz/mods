package rox.whistle;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DogWhistle extends Item {
	//Item object reference.
	public static Item dog_whistle;
	
	//Initialization method.
	public static void init(){
		//Assigning object to the object reference.
		dog_whistle = new DogWhistle()
			.setUnlocalizedName("dog_whistle")
			.setMaxStackSize(1)
			.setCreativeTab(CreativeTabs.tabTools);
		
		//Registering the item as this is called in Forge's preInit.
		GameRegistry.registerItem(dog_whistle, dog_whistle.getUnlocalizedName().substring(5));
	}
	
	//Overriding super's right click.
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		//Getting a list of wolves within six blocks of the player.
		@SuppressWarnings("unchecked")
		List<EntityWolf> e = player.worldObj.getEntitiesWithinAABB(EntityWolf.class, AxisAlignedBB.fromBounds(player.posX - 6, player.posY - 3, player.posZ - 6, player.posX + 6, player.posY + 3, player.posZ + 6));
		
		//If the list is empty, I want to catch it and tell the player that no wolves are in range.
		if(e.isEmpty()){
			if(!player.worldObj.isRemote){
				player.addChatMessage(new ChatComponentText("No wolves within range."));
			}
		}
		//If the list is not empty, I want to check if the player is not sneaking.
		else if(!player.isSneaking()){
			//If they aren't sneaking, I want to tell all wolves around him/her to stand up.
			world.playSoundAtEntity(player, Info.id + ":item.whistle", 1.0F, 1.0F);
			for(EntityWolf wolf : e){
				if(wolf.isTamed() && wolf.isOwner(player) && wolf.isSitting()){
					wolf.setSitting(false);
				}
			}
		}
		//If they're not standing, then check if they're sneaking.
		else if(player.isSneaking()){
			//If they're sneaking, I want to tell all wolves to sit.
			world.playSoundAtEntity(player, Info.id + ":item.whistle", 1.0F, 1.0F);
			for(EntityWolf wolf : e){
				if(wolf.isTamed() && wolf.isOwner(player) && !wolf.isSitting()){
					wolf.setSitting(true);
				}
			}
		}
		
		//Return the item in it's original state since onItemRightClick needs a return statement.
		return stack;
	}
}
