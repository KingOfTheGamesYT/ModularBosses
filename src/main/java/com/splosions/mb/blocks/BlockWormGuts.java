package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.Reference;
import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.Explosion;

import java.util.Objects;

public class BlockWormGuts extends Block implements IHasModel {

	public BlockWormGuts(String name) {
            super(Material.BARRIER);
            setRegistryName(name);
            setTranslationKey(Reference.MOD_ID + "." + name);
			setHardness(-1.0F);
			setHarvestLevel("pickaxe", 100);
			setSoundType(SoundType.SLIME);
			setCreativeTab(ModularBosses.tabBlocks);
            ModBlocks.BLOCKS.add(this);
            ModularBossesItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
    }
	
	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return false;
	}

    @Override
    public void registerModels() {
        ModularBosses.proxy.registerModel(Item.getItemFromBlock(this), 0);
    }
}