package com.rox.gunpowder;

import com.rox.gunpowder.init.RoxItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs {

	public Tab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return RoxItems.potassium;
	}
	
}
