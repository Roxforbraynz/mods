package rox.leather.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import rox.leather.Info;
import rox.leather.StitchedFlesh;

public class ClientProxy extends CommonProxy {
	public void setRenders(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StitchedFlesh.stitched_flesh, 0, new ModelResourceLocation(Info.id + ":" + StitchedFlesh.stitched_flesh.getUnlocalizedName().substring(5), "inventory"));
	}
}
