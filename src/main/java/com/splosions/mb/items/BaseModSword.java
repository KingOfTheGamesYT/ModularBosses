package com.splosions.mb.items;

import com.splosions.mb.ModularBosses;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.item.ItemSword;


/**
 * 
 * Same as {@link BaseModItem}, but with an ItemSword base.
 *
 */
public class BaseModSword extends ItemSword implements IModItem {

	public BaseModSword(ToolMaterial material) {
		super(material);
		setCreativeTab(ModularBosses.tabTools);
	}

	@Override
	public String[] getVariants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerVariants() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerRenderers(ItemModelMesher mesher) {
		// TODO Auto-generated method stub
		
	}

}
