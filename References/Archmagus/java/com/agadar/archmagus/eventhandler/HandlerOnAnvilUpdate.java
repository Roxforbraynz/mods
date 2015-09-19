package com.agadar.archmagus.eventhandler;

import com.agadar.archmagus.itemblock.ItemSpellBook;
import com.agadar.archmagus.itemblock.ModItemsBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.AnvilUpdateEvent;

/** For making spell books combineable in anvils. */
public class HandlerOnAnvilUpdate 
{
	@SubscribeEvent
	public void OnAnvilUpdate(AnvilUpdateEvent event)
	{
		if (event.left.getItem().equals(ModItemsBlocks.spell_book) && event.right.getItem().equals(ModItemsBlocks.spell_book))
		{
			event.output = ((ItemSpellBook) ModItemsBlocks.spell_book).tryCombine(event.left, event.right);
			event.cost = 10;
		}
	}
}
