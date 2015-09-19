package rox.mythril;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RoxMethods {
	public static void renderBlock(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Info.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	public static void renderItem(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Info.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
}
