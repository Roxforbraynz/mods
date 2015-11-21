package rox.mystic.tileentities;

import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mystic.tileentities.testtileentity.TestTileEntityData;

public class TileEntityRegistry {
	public static void init(){
		GameRegistry.registerTileEntity(TestTileEntityData.class, "test_tile_entity");
	}
}
