package com.splosions.mb.proxy;

import com.splosions.mb.client.render.items.*;
import com.splosions.mb.items.ModularBossesItems;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{
	

	
	
	public static void sobelShader(){
		try {
			//no more reflection needed
			Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/sobel.json"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public static void clearShader(){
		try{
			//no more reflection needed
			Minecraft.getMinecraft().entityRenderer.stopUseShader();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	

	
	@Override
	public void registerItemRenderers() {
		ItemRenderHack.registerItemRenderer(ModularBossesItems.itemBait, new RenderItemBait());
		ItemRenderHack.registerItemRenderer(ModularBossesItems.itemLegendsBow, new RenderItemBait());
		ItemRenderHack.registerItemRenderer(ModularBossesItems.itemLegendsSword, new RenderItemBait());
		ItemRenderHack.registerItemRenderer(ModularBossesItems.itemScythe, new RenderItemScythe());
	}

	
	@Override
	public void preInit() {
		super.preInit();

	}
	
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);


    }
	
}
