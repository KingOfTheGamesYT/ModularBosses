package com.splosions.mb.client.render.items;


import com.splosions.mb.ModularBosses;
import com.splosions.mb.client.models.item.ModelBait;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class RenderItemBait extends RenderItemBase
{
	private final static ResourceLocation TEXTURE = new ResourceLocation("mb:textures/items/Bait.png");

	public RenderItemBait() {
		super(new ModelBait(), TEXTURE);
		this.scale_ground=this.scale_thirdp;
	}

}