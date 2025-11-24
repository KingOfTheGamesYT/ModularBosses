package com.splosions.mb.items;


import com.splosions.mb.ModularBosses;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;


public class ModularBossesItems {
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	//================ TOOLS TAB ================//
	public static Item 
	itemScythe,
	itemLegendsBow,
	itemLegendsSword,
	itemBait,
	itemNote;
	
	
	
	//================ SPAWN EGGS TAB ================//
	public static Item
	spawn_egg;
	
	
	//================ NO TAB ================//
	public static Item
	slimeblob;
	
	
	public static void init() {
		
		itemScythe = new ItemScythe(ToolMaterial.DIAMOND).setTranslationKey("itemScythe");
		itemLegendsBow = new ItemLegendsBow(ToolMaterial.DIAMOND).setTranslationKey("Legends_Bow");
		itemLegendsSword = new ItemLegendsSword(ToolMaterial.DIAMOND).setTranslationKey("Legends_Sword");
		itemBait = new ItemBait(ToolMaterial.WOOD).setTranslationKey("itemBait");
		itemNote = new ItemNote(ToolMaterial.DIAMOND).setTranslationKey("itemNote");
	
		slimeblob = new Item().setTranslationKey("slimeblob").setMaxStackSize(16); //.setTextureName("ModularBosses:SlimeBlob")
		spawn_egg = new ItemCustomEgg().setTranslationKey("spawn_egg");
	}


	public static void registerItems() {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
