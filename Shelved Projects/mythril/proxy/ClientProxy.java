package rox.mythril.proxy;

import rox.mythril.Armory;
import rox.mythril.RoxMethods;
import rox.mythril.blocks.MythrilBlock;
import rox.mythril.blocks.MythrilOre;
import rox.mythril.items.MythrilIngot;

public class ClientProxy extends CommonProxy{
	@Override
	public void setRenders(){
		RoxMethods.renderBlock(MythrilOre.mythril_ore);
		RoxMethods.renderBlock(MythrilBlock.mythril_block);
		RoxMethods.renderItem(MythrilIngot.mythril_ingot);
		RoxMethods.renderItem(Armory.mythril_pickaxe);
		RoxMethods.renderItem(Armory.mythril_shovel);
		RoxMethods.renderItem(Armory.mythril_axe);
		RoxMethods.renderItem(Armory.mythril_hoe);
		RoxMethods.renderItem(Armory.mythril_sword);
		RoxMethods.renderItem(Armory.mythril_helm);
		RoxMethods.renderItem(Armory.mythril_plate);
		RoxMethods.renderItem(Armory.mythril_legs);
		RoxMethods.renderItem(Armory.mythril_boots);
	}
}
