package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.Explosion;

public class BlockWormGuts2 extends Block {

    public BlockWormGuts2() {
            super(Material.BARRIER);
            setRegistryName("worm_guts_2");
            setTranslationKey("worm_guts_2");
			setHardness(-1.0F);
			setHarvestLevel("pickaxe", 100);
			setSoundType(SoundType.SLIME);
			setCreativeTab(ModularBosses.tabBlocks);
		}
	
	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return false;
	}
}