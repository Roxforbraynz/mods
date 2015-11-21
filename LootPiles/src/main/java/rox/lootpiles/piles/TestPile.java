package rox.lootpiles.piles;

import net.minecraft.block.material.Material;
import rox.lootpiles.LootPileTemplate;

public class TestPile extends LootPileTemplate {

	public TestPile(String unlocalizedName, Material material, String toolUsed) {
		super("test_pile", Material.wood, "axe");
	}

}
