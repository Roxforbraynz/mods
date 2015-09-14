package rox.warpstone;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Methods{
	//Used to render a block.
	public static void renderBlock(Block block, String ModID){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	//Used to render an item.
	public static void renderItem(Item item, String ModID){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	//Used to register a block.
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	//Used to register an item.
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	//Sends the player a message.
	public static void tellPlayer(EntityPlayer player, String message){
		//This if statement is needed, else it sends the message twice.
		//This is unexplainable code wizardry. Don't question it.
		if(!player.worldObj.isRemote){
			player.addChatMessage(new ChatComponentText(message));
		}
	}
}
