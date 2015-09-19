package rox.arcvol.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.arcvol.Core;
import rox.base.Methods;

public class WeakEnderEssence extends Item{
	public static Item weak_ender_essence;
	
	public static void init(){
		weak_ender_essence = new WeakEnderEssence()
			.setUnlocalizedName("weak_ender_essence")
			.setMaxStackSize(1)
			.setMaxDamage(7)
			.setCreativeTab(Core.tabArcvol);
		
		Methods.registerItem(weak_ender_essence);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		Minecraft mc = Minecraft.getMinecraft();
		
		if(player.isSneaking()){
			if(stack.getTagCompound() == null){
				stack.setTagCompound(new NBTTagCompound());
			}
			
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("dim", player.dimension);
			nbt.setInteger("posX", pos.getX());
			nbt.setInteger("posY", pos.getY());
			nbt.setInteger("posZ", pos.getZ());
			stack.getTagCompound().setTag("coords", nbt);
			
			Methods.tellPlayer(player, (EnumChatFormatting.GREEN + "Location marked!"));
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced){
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("coords")){
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
				int dim = nbt.getInteger("dim");
				int posX = nbt.getInteger("posX");
				int posY = nbt.getInteger("posY");
				int posZ = nbt.getInteger("posZ");
				
				String dimname = null;
				switch(dim){
				case -1:
					dimname = "The Nether";
					break;
				case 0:
					dimname = "The Overworld";
					break;
				case 1:
					dimname = "The End";
					break;
				default:
					dimname = null;
				}
				
				if(dimname != null){
					tooltip.add(EnumChatFormatting.YELLOW + "Dimension: " + EnumChatFormatting.RESET + dimname);
					tooltip.add(EnumChatFormatting.YELLOW + "X: " + EnumChatFormatting.RESET + posX + EnumChatFormatting.YELLOW + " Y: " + EnumChatFormatting.RESET + posY + EnumChatFormatting.YELLOW + " Z: " + EnumChatFormatting.RESET + posZ);
				}
				else{
					tooltip.add(EnumChatFormatting.RED + "Unknown Dimension." + EnumChatFormatting.YELLOW + " ID: " + EnumChatFormatting.RESET + dim);
					tooltip.add(EnumChatFormatting.YELLOW + "X: " + EnumChatFormatting.RESET + posX + EnumChatFormatting.YELLOW + " Y: " + EnumChatFormatting.RESET + posY + EnumChatFormatting.YELLOW + " Z: " + EnumChatFormatting.RESET + posZ);
				}
			}
		} else {
			tooltip.add(EnumChatFormatting.YELLOW + "No location bound.");
		}
		
		//Below is old code, don't use. Crashes. Kept for reference.
		
				/*NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
				int dim = nbt.getInteger("dim");
				int posX = nbt.getInteger("posX");
				int posY = nbt.getInteger("posY");
				int posZ = nbt.getInteger("posZ");
				String dimname;
				switch(dim){
					case -1: dimname = "Nether"; break;
					case  0: dimname = "Overworld"; break;
					case  1: dimname = "The End"; break;
					default: dimname = "This shouldn't show"; break;
				}
				if(dimname != "This shouldn't show"){
					tooltip.add("Dimension: " + dimname);
					tooltip.add("Location: " + posX + ", " + posY + ", " + posZ);
				}
				if(dimname == "This shouldn't show"){
					tooltip.add("Dimension: " + dim);
					tooltip.add("Location: " + posX + ", " + posY + ", " + posZ);
				}
				else{
					tooltip.add("No location stored.");
				}*/
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!player.isSneaking()){
			if(stack.getTagCompound() != null){
				if(stack.getTagCompound().hasKey("coords")){
					NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
					int dim = nbt.getInteger("dim");
					int posX = nbt.getInteger("posX");
					int posY = nbt.getInteger("posY");
					int posZ = nbt.getInteger("posZ");
				
					if(dim == player.worldObj.provider.getDimensionId()){
						player.setPositionAndUpdate((posX+0.5), (posY+1), (posZ+0.5));
						world.playSoundEffect((posX+0.5), (posY+0.5), (posZ+0.5), "mob.endermen.portal", 0.5F, 0.8F);
						stack.damageItem(1, player);
					} else {
						Methods.tellPlayer(player, (EnumChatFormatting.RED + "You cannot warp across dimensions!"));
					}
				}
			} else {
				Methods.tellPlayer(player, (EnumChatFormatting.YELLOW + "You haven't bound a location yet! Sneak and use the item on a"));
				Methods.tellPlayer(player, (EnumChatFormatting.YELLOW + "block to bind it to that block."));
			}
		}
		return stack;
	}
}
