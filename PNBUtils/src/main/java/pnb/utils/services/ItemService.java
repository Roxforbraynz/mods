package pnb.utils.services;

import java.util.HashMap;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Singleton
public class ItemService {
	//Our little collection of custom items for quick lookup.
	private final HashMap<String,Item> customItems;
	
	@Inject
	public ItemService() {
		customItems = new HashMap<String,Item>();
	}
	
	public void registerItem(String name, Item item) {
		//Registering the item.
		GameRegistry.registerItem(item, name);
		
		//Initialize our custom item
		customItems.put(name, item);
	}
	
	public Item getItem(String name) {
		return customItems.get(name);
	}
}
