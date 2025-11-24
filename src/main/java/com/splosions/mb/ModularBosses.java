package com.splosions.mb;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.splosions.mb.blocks.ModBlocks;
import com.splosions.mb.handler.*;
import com.splosions.mb.handler.commands.CommandItemInfo;
import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.network.PacketDispatcher;
import com.splosions.mb.proxy.CommonProxy;
import com.splosions.mb.util.schematic.Dungeon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ModularBosses {

    public ArrayList<Dungeon> dungeonList = new ArrayList<Dungeon>();
    public Entity playerTarget;
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Instance(Reference.MOD_ID)
    public static ModularBosses INSTANCE;

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandItemInfo());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new TickHandler());
        PacketDispatcher.preInit();
        Config.preInit(event);
        proxy.preInit();
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        //MBBossDimension.init();
        proxy.registerItemRenderers();
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Config.postInit();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new MBEventHandler());
    }


    public static CreativeTabs tabBlocks = new CreativeTabs("mb.blocks") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CONTROL_BLOCK);
        }
    };

    public static CreativeTabs tabTools = new CreativeTabs("mb.tools") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModularBossesItems.itemLegendsSword);
        }
    };

        public static CreativeTabs tabEggs = new CreativeTabs("mb.eggs") {

            @Override
            public ItemStack createIcon() {
                return new ItemStack(ModularBossesItems.spawn_egg);
            }
        };
    }