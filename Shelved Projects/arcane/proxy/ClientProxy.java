package rox.arcane.proxy;

import rox.arcane.blocks.ArcaneOre;

public class ClientProxy extends CommonProxy {
	@Override
	public void setRenders() {
		ArcaneOre.blockRender(ArcaneOre.arcane_ore);
	}
}
