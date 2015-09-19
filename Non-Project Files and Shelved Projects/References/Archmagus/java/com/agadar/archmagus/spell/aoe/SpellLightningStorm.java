package com.agadar.archmagus.spell.aoe;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** Lightning strikes all non-allied creatures in the area. */
public class SpellLightningStorm extends SpellAoE {

	public SpellLightningStorm(int par1) 
	{
		super(par1);
		this.setName("lightningstorm");
	}
	
	@Override
	public int getManaCost()
    {
    	return 8;
    }
	
	@Override
	public void castSpell(short par1Level, World par2World, EntityPlayer par3EntityPlayer) 
	{
		par2World.playSoundAtEntity(par3EntityPlayer, this.getSoundName(), 1.0F, 1.0F);
		super.castSpell(par1Level, par2World, par3EntityPlayer);
	}

	@Override
	protected void affectEntity(World par1World, EntityLivingBase par2EntityLivingBase) 
	{
		par1World.addWeatherEffect(new EntityLightningBolt(par1World, par2EntityLivingBase.posX, par2EntityLivingBase.posY, par2EntityLivingBase.posZ));
		par2EntityLivingBase.knockBack(par2EntityLivingBase, 0F, 1F, 0F);
	}
}
