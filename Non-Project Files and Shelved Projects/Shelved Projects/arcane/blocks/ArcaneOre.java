package rox.arcane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.arcane.Info;

public class ArcaneOre extends Block {
	public ArcaneOre(Material materialIn) {
		super(materialIn);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}
	
	public static Block arcane_ore;
	public static void ArcaneOreSetup() {
		arcane_ore = new ArcaneOre
			(Material.rock)
			.setHardness(10)
			.setUnlocalizedName("arcane_ore")
			.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(arcane_ore, arcane_ore.getUnlocalizedName().substring(5));
	}
	
	public static void blockRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Info.modid + ":arcane_ore", "inventory"));
	}
}
