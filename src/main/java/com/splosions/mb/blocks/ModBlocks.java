package com.splosions.mb.blocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.splosions.mb.Reference;
import com.splosions.mb.blocks.tileentity.*;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block INVISIBLE_BLOCK = new BlockInvisible("invisible_block");
	public static final Block CONTROL_BLOCK = new BlockControlBlock("control_block");
	public static final Block PORTAL_BLOCK = new BlockPortalBlock("portal_block");//.setLightLevel(1)
	public static final Block PORTAL_LANDING = new BlockPortalLanding("portal_landing");//.setLightLevel(1)
	public static final Block DUNGEON_EXIT_PORTAL = new BlockReturnPortal("portal_return_block");//.setLightLevel(1)
	public static final Block PHASE_FIRE = new BlockPhaseFire("phase_fire");//.setLightLevel(0.3F)
	public static final Block FORCE_FIELD_GENERATOR = new BlockForceFieldGen("force_field_gen");
	public static final Block FORCE_FIELD = new BlockForceFieldBlue("force_field_blue");
	public static final Block WORM_GUTS_1 = new BlockWormGuts("worm_guts_1");
	public static final Block WORM_GUTS_2 = new BlockWormGuts2("worm_guts_2");
	public static final Block WORM_TUMOR = new BlockWormTumor("worm_tumor");//.setLightLevel(1)

}