package rox.arcvol;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.arcvol.items.InertEssence;

public class ArcvolTab extends CreativeTabs{

	public ArcvolTab(String label){
		super(label);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		return InertEssence.inert_essence;
	}
}
