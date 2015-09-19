package rox.magic.proxy;

import rox.magic.ShortMethods;
import rox.magic.blocks.ArcaneCrystalOre;
import rox.magic.items.ArcaneCrystal;

public class ClientProxy extends CommonProxy {
	@Override
	public void setRenders() {
		ArcaneCrystal.itemRender(ArcaneCrystal.arcane_crystal);
		ArcaneCrystalOre.blockRender(ArcaneCrystalOre.arcane_crystal_ore);
	}
}
