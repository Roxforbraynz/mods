package rox.warpstone.proxy;

import rox.warpstone.ItemWarpStone;
import rox.warpstone.Methods;

public class ClientProxy extends CommonProxy{
	@Override
	//This method is run in the Core class.
	public void setRenders(){
		//Render items and blocks here using Methods.renderItem() and Methods.renderBlock().
		//This should only be client-side.
		
		//Rendering the Warp Stone.
		Methods.renderItem(ItemWarpStone.warp_stone, "warpstone");
	}
}
