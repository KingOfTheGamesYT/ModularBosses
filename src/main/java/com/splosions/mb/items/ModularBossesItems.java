package com.splosions.mb.items;


import com.splosions.mb.ModularBosses;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;


public class ModularBossesItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

        //================ TOOLS TAB ================//
    public static final Item itemScythe = new ItemScythe(ToolMaterial.DIAMOND).setTranslationKey("itemScythe");
    public static final Item itemLegendsBow = new ItemLegendsBow(ToolMaterial.DIAMOND).setTranslationKey("Legends_Bow");
    public static final	Item itemLegendsSword = new ItemLegendsSword(ToolMaterial.DIAMOND).setTranslationKey("Legends_Sword");
    public static final	Item itemBait = new ItemBait(ToolMaterial.WOOD).setTranslationKey("itemBait");
    public static final	Item itemNote = new ItemNote(ToolMaterial.DIAMOND).setTranslationKey("itemNote");

        //================ NO TAB ================//
    public static final Item slimeblob = new Item().setTranslationKey("slimeblob").setMaxStackSize(16); //.setTextureName("ModularBosses:SlimeBlob")

        //================ SPAWN EGGS TAB ================//
    public static final Item spawn_egg = new ItemCustomEgg().setTranslationKey("spawn_egg");
}