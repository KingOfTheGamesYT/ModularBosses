package com.splosions.mb.client.render.items;


import com.splosions.mb.ModularBosses;
import com.splosions.mb.client.models.item.ModelLegendsSword;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SuppressWarnings("deprecation")
@SideOnly(Side.CLIENT)
public class RenderItemLegendsSword
{
	protected final ModelLegendsSword swordModel;
	private final IBakedModel baseModel;
	private final IBakedModel emptyModel;
	
	private final ResourceLocation loc = new ResourceLocation("mb:textures/items/LegendsSword.png");

	public RenderItemLegendsSword(IBakedModel baseModel) {
		swordModel = new ModelLegendsSword();
		this.baseModel = baseModel;
		ModelResourceLocation resource = new ModelResourceLocation("mb:invisible_block", "inventory");
		this.emptyModel = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getModel(resource);
		if (emptyModel == null) {
			ModularBosses.logger.warn("Failed to retrieve model for resource location: " + resource);
		}
	}


	
	private ResourceLocation getTexture1() {
		return loc;
	}

}