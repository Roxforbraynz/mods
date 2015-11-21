package rox.lootpiles;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LootPileTemplate extends Block {
	
	//List of drops.
	private ArrayList<ItemStack> drops;

	public LootPileTemplate(String unlocalizedName, Material material, String toolUsed) {
		//I'll define the material when creating a new loot pile.
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setHarvestLevel(toolUsed, 0);
		//I want the hardness and resistance to be the same across the board.
		//These are piles of loose items after all.
		this.setHardness(1.5f);
		this.setResistance(25);
		//Block hitbox. For reference, 1/16th of a block is 0.0625F
		//The Loot pile hitbox will always be the size of a half slab.
		this.setBlockBounds(0f, 0f, 0f, 1f, 0.5f, 1f);
	}
	
	//This overrides the normal list of drops with my custom ArrayList of drops.
	public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
		return drops;
	}
	
	//Adds a block to the drop list.
	public void addBlockDrop(Block dropToAdd, int count) {
		Item convert = Item.getItemFromBlock(dropToAdd);
		ItemStack theDrop = new ItemStack(convert, count);
		drops.add(theDrop);
	}
	
	//Adds an item to the drop list.
	public void addItemDrop(Item dropToAdd, int count) {
		ItemStack theDrop = new ItemStack(dropToAdd, count);
		drops.add(theDrop);
	}
	
	//Drops getter method.
	public ArrayList<ItemStack> getDrops() {
		return drops;
	}
	
	//Register method.
	public void register() {
		Block LootPile = this;
		GameRegistry.registerBlock(LootPile, LootPile.getUnlocalizedName().substring(5));
	}
	
	//Texturing method. This should only be called in ClientProxy.
	public void render() {
		Item LootPile = Item.getItemFromBlock(this);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(LootPile, 0, new ModelResourceLocation(Info.ID + this.getUnlocalizedName().substring(5), "inventory"));
	}
}
