package rox.mythril;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.mythril.items.MythrilArmor;
import rox.mythril.items.MythrilAxe;
import rox.mythril.items.MythrilHoe;
import rox.mythril.items.MythrilPickaxe;
import rox.mythril.items.MythrilShovel;
import rox.mythril.items.MythrilSword;

public class Armory {
	public static ToolMaterial Mythril = EnumHelper.addToolMaterial("Mythril", 4, 2560, 12.0f, 4.0f, 30);
	public static ArmorMaterial ArmorMythril = EnumHelper.addArmorMaterial("ArmorMythril", "mythril", 50, new int[]{4,6,6,4}, 25);
	
	public static Item mythril_pickaxe = new MythrilPickaxe(Mythril).setUnlocalizedName("mythril_pickaxe");
	public static Item mythril_shovel = new MythrilShovel(Mythril).setUnlocalizedName("mythril_shovel");
	public static Item mythril_axe = new MythrilAxe(Mythril).setUnlocalizedName("mythril_axe");
	public static Item mythril_sword = new MythrilSword(Mythril).setUnlocalizedName("mythril_sword");
	public static Item mythril_hoe = new MythrilHoe(Mythril).setUnlocalizedName("mythril_hoe");

	public static Item mythril_helm = new MythrilArmor(ArmorMythril, 1, 0).setUnlocalizedName("mythril_helm");
	public static Item mythril_plate = new MythrilArmor(ArmorMythril, 1, 1).setUnlocalizedName("mythril_plate");
	public static Item mythril_legs = new MythrilArmor(ArmorMythril, 2, 2).setUnlocalizedName("mythril_legs");
	public static Item mythril_boots = new MythrilArmor(ArmorMythril, 1, 3).setUnlocalizedName("mythril_boots");
	
	public static void MythrilStuff(){
		RoxMethods.registerItem(mythril_pickaxe);
		RoxMethods.registerItem(mythril_shovel);
		RoxMethods.registerItem(mythril_axe);
		RoxMethods.registerItem(mythril_sword);
		RoxMethods.registerItem(mythril_hoe);
		RoxMethods.registerItem(mythril_helm);
		RoxMethods.registerItem(mythril_plate);
		RoxMethods.registerItem(mythril_legs);
		RoxMethods.registerItem(mythril_boots);
	}
}
