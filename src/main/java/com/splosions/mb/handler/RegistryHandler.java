package com.splosions.mb.handler;

import com.splosions.mb.Reference;
import com.splosions.mb.blocks.ModBlocks;
import com.splosions.mb.blocks.tileentity.*;
import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ModularBossesItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        for(Item item : ModularBossesItems.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }

        for(Block block : ModBlocks.BLOCKS)
        {
            if(block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void registerTileEntities() {
        registerTileEntity(TileEntityControlBlock.class, "tileEntityControlBlock");
        registerTileEntity(TileEntityPortalBlock.class, "tileEntityPortalBlock");
        registerTileEntity(TileEntityReturnPortalBlock.class, "tileEntityReturnPortalBlock");
        registerTileEntity(TileEntityTempWormBlood.class, "tileEntityTempWormBlood");
        registerTileEntity(TileEntityTempWormAcid.class, "tileEntityTempWormAcid");
    }

    private static void registerTileEntity(final Class<? extends TileEntity> tileEntityClass, final String name) {
        GameRegistry.registerTileEntity(tileEntityClass, Reference.MOD_ID + ":" + name);
    }
}
