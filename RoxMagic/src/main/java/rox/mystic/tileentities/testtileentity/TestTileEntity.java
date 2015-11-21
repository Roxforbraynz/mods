package rox.mystic.tileentities.testtileentity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestTileEntity extends BlockContainer{

	protected TestTileEntity(){
		super(Material.ground);
		this.setUnlocalizedName("test_tile_entity");
		this.setHardness(2.0F);
		this.setResistance(6.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new TestTileEntityData();
	}

}
