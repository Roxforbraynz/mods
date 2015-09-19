package com.agadar.archmagus.potion;

import com.agadar.archmagus.Archmagus;
import com.agadar.archmagus.misc.ManaProperties;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionBase extends Potion 
{
	/** The location of our custom potion effect icons. */
	private static final ResourceLocation resourceLoc = new ResourceLocation(Archmagus.MODID + ":textures/status_icons.png");

	public PotionBase(int par1Id, boolean par2IsBadEffect, int par3LiquidColor) 
	{
		super(par1Id, par2IsBadEffect, par3LiquidColor);
	}
	
	@Override
    public void performEffect(EntityLivingBase affected, int amplifier)
    {
		if (affected instanceof EntityPlayer)
		{
			if (this.id == ModPotions.manaRegen.id)
	        {
				ManaProperties prop = ManaProperties.get((EntityPlayer) affected);
				
				if (prop != null)
					prop.replenishMana(1);
	        }
			else if (this.id == ModPotions.mana.id)
			{
				ManaProperties prop = ManaProperties.get((EntityPlayer) affected);
				
				if (prop != null)
					prop.replenishMana(Math.max(4 << amplifier, 0));
			}
		}
		else
		{
			super.performEffect(affected, amplifier);
		}
    }
	
	@Override
    public void affectEntity(EntityLivingBase thrower, EntityLivingBase victim, int amplifier, double distanceModifier)
    {
		if (victim instanceof EntityPlayer)
		{
			if (this.id == ModPotions.mana.id)
			{
				ManaProperties prop = ManaProperties.get((EntityPlayer) victim);
				
				if (prop != null)
					prop.replenishMana((int)(distanceModifier * (double)(4 << amplifier) + 0.5D));
			}
		}
		else
		{
			super.affectEntity(thrower, victim, amplifier, distanceModifier);
		}
    }
	
	@Override
    public boolean isReady(int duration, int amplifier)
    {
		if (this.id == ModPotions.manaRegen.id)
        {
            int k = 50 >> amplifier;
            return k > 0 ? duration % k == 0 : true;
        }
		else if (this.id == ModPotions.mana.id)
		{
			return duration >= 1;
		}
		
		return super.isReady(duration, amplifier);
    }
	
	@Override
    public boolean isInstant()
    {
        return this.id == ModPotions.mana.id;
    }

	@Override
	public Potion setIconIndex(int par1, int par2) 
	{
		super.setIconIndex(par1, par2);
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() 
	{
	    Minecraft.getMinecraft().renderEngine.bindTexture(resourceLoc);
	    return true;
	}
}
