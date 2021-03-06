package rox.arcvol.proxy;

import rox.arcvol.items.InertEssence;
import rox.arcvol.items.WeakEnderEssence;
import rox.arcvol.items.WeakFireEssence;
import rox.base.Methods;

public class ClientProxy extends CommonProxy{
	@Override
	public void setRenders(){
		Methods.renderItem(InertEssence.inert_essence, "arcvol");
		Methods.renderItem(WeakFireEssence.weak_fire_essence, "arcvol");
		Methods.renderItem(WeakEnderEssence.weak_ender_essence, "arcvol");
	}
}
