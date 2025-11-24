package com.splosions.mb.blocks;

import java.util.HashSet;
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

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final Block INVISIBLE_BLOCK = new BlockInvisible();
	public static final Block CONTROL_BLOCK = new BlockControlBlock();
	public static final Block PORTAL_BLOCK = new BlockPortalBlock();//.setLightLevel(1)
	public static final Block PORTAL_LANDING = new BlockPortalLanding();//.setLightLevel(1)
	public static final Block DUNGEON_EXIT_PORTAL = new BlockReturnPortal();//.setLightLevel(1)
	public static final Block PHASE_FIRE = new BlockPhaseFire();//.setLightLevel(0.3F)
	public static final Block FORCE_FIELD_GENERATOR = new BlockForceFieldGen();
	public static final Block FORCE_FIELD = new BlockForceFieldBlue();
	public static final Block WORM_GUTS_1 = new BlockWormGuts();
	public static final Block WORM_GUTS_2 = new BlockWormGuts2();
	public static final Block WORM_TUMOR = new BlockWormTumor();//.setLightLevel(1)

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					CONTROL_BLOCK,
					PORTAL_BLOCK,
					PORTAL_LANDING,
					FORCE_FIELD_GENERATOR,
					FORCE_FIELD,
					WORM_GUTS_1,
					WORM_GUTS_2,
					WORM_TUMOR,
					PHASE_FIRE,
					INVISIBLE_BLOCK,
                    DUNGEON_EXIT_PORTAL
				};
			registry.registerAll(blocks);
		}

		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                    new ItemBlock(CONTROL_BLOCK),
                    new ItemBlock(PORTAL_LANDING),
                    new ItemBlock(PORTAL_BLOCK),
                    new ItemBlock(FORCE_FIELD_GENERATOR),
                    new ItemBlock(FORCE_FIELD),
                    new ItemBlock(WORM_GUTS_1),
                    new ItemBlock(WORM_GUTS_2),
                    new ItemBlock(WORM_TUMOR),
                    new ItemBlock(PHASE_FIRE),
                    new ItemBlock(INVISIBLE_BLOCK),
                    new ItemBlock(DUNGEON_EXIT_PORTAL)
            };


            final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			registerTileEntities();
		}
	}

	private static void registerTileEntities() {
		registerTileEntity(TileEntityControlBlock.class, "tileEntityControlBlock");
		registerTileEntity(TileEntityPortalBlock.class, "tileEntityPortalBlock");
		registerTileEntity(TileEntityReturnPortalBlock.class, "tileEntityReturnPortalBlock");
		registerTileEntity(TileEntityTempWormBlood.class, "tileEntityTempWormBlood");
		registerTileEntity(TileEntityTempWormAcid.class, "tileEntityTempWormAcid");
	}

	private static void registerTileEntity(final Class<? extends TileEntity> tileEntityClass, final String name) {
		GameRegistry.registerTileEntity(tileEntityClass, Reference.MOD_ID + ":" + name);
	}
	  
	  @SideOnly(Side.CLIENT)
	  @SubscribeEvent
	  public static void registerModels(ModelRegistryEvent event) {
	    //ModelLoader.setCustomModelResourceLocation(CONTROL_BLOCK_ITEM, 0, new ModelResourceLocation("mb:control_block", "inventory"));
	  }
}