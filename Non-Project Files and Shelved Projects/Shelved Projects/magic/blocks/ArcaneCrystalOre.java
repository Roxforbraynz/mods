package rox.magic.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.magic.Info;
import rox.magic.items.ArcaneCrystal;

public class ArcaneCrystalOre extends Block {
	public ArcaneCrystalOre(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.5f);
		this.setLightOpacity(0);
		this.setStepSound(this.soundTypeGlass);
		this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 0.84375F, 0.75F);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}
	public boolean isSolidFullCube() {
		return false;
	}
	public boolean isFullCube() {
		return false;
	}
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.TRANSLUCENT;
	}
	public boolean isTranslucent() {
		return true;
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ArcaneCrystal.arcane_crystal;
	}
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(3);
	}

	public static Block arcane_crystal_ore;
	
	public static void ArcaneCrystalOreStuff() {
		arcane_crystal_ore = new ArcaneCrystalOre
			(Material.rock)
			.setHardness(10F)
			.setUnlocalizedName("arcane_crystal_ore")
			.setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerBlock(arcane_crystal_ore, arcane_crystal_ore.getUnlocalizedName().substring(5));
	}
	
	public static void blockRender(Block block) { //Render a block
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Info.MODID + ":arcane_crystal_ore", "inventory"));
	}
}
