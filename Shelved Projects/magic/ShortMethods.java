package rox.magic;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ShortMethods {
	public static void itemRender(Item item) { //Render an item
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Info.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void blockRender(Block block) { //Render a block
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Info.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
