package rox.warpstone.proxy;

import com.google.inject.Inject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import pnb.utils.services.ItemService;

public class ClientProxy extends CommonProxy{
	
	@Inject
	ItemService is;
	
	@Override
	//This method is run in the Core class.
	public void setRenders(){
		//Render items and blocks here using Methods.renderItem() and Methods.renderBlock().
		//This should only be client-side.
		
		//Rendering the Warp Stone.
		Item warpStone = is.getItem("warp_stone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				warpStone, 
				0, 
				new ModelResourceLocation("warpstone:" + warpStone.getUnlocalizedName().substring(5), "inventory"));
	}
}
