package com.splosions.mb.client.render.items;


import com.splosions.mb.ModularBosses;
import com.splosions.mb.client.models.projectiles.ModelScythe;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class RenderItemScythe extends RenderItemBase
{
	
	private final static ResourceLocation TEXTURE = new ResourceLocation("mb:textures/items/Scythe.png");


	public RenderItemScythe() {
		super(new ModelScythe(), TEXTURE);
		this.scale_ground=this.scale_thirdp;
	}
}