package rox.base;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Methods{
	public static void renderBlock(Block block, String ModID){
		//Used to render a block in the game world
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	public static void renderItem(Item item, String ModID){
		//Used to render an item in the inventory
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	public static void registerBlock(Block block){
		//Used to register a block
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	public static void registerItem(Item item){
		//Used to register an item
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	public static void tellPlayer(EntityPlayer player, String message){
		if(!player.worldObj.isRemote){
			player.addChatMessage(new ChatComponentText(message));
		}
	}
}
