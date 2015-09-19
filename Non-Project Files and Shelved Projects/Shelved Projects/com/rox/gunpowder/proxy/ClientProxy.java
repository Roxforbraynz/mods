package com.rox.gunpowder.proxy;

import com.rox.gunpowder.init.RoxBlocks;
import com.rox.gunpowder.init.RoxItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		RoxBlocks.registerRenders();
		RoxItems.registerRenders();
	}
}
