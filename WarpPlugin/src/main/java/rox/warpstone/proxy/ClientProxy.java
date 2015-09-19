package rox.warpstone.proxy;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy{
	@Override
	//This method is run in the Core class.
	public void setRenders(HashMap<String,Item> customItems){
		//Render items and blocks here using Methods.renderItem() and Methods.renderBlock().
		//This should only be client-side.
		
		//Rendering the Warp Stone.
		Item warpStone = customItems.get("warp_stone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				warpStone, 
				0, 
				new ModelResourceLocation("warpstone:" + warpStone.getUnlocalizedName().substring(5), "inventory"));
	}
}
