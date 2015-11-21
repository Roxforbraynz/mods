package rox.whistle.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import rox.whistle.Info;
import rox.whistle.CatWhistle;
import rox.whistle.DogWhistle;

public class ClientProxy extends CommonProxy {
	public void setRenders(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DogWhistle.dog_whistle, 0, new ModelResourceLocation(Info.id + ":" + DogWhistle.dog_whistle.getUnlocalizedName().substring(5), "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CatWhistle.cat_whistle, 0, new ModelResourceLocation(Info.id + ":" + CatWhistle.cat_whistle.getUnlocalizedName().substring(5), "inventory"));
	}
}
