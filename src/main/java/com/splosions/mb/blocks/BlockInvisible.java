
package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;

import com.splosions.mb.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.BlockRenderLayer;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockInvisible extends Block
{
	public BlockInvisible() {
        super(Material.BARRIER);
        setRegistryName(Reference.MOD_ID, "invisible_block");
        setTranslationKey(Reference.MOD_ID + "." + "invisible_block");
		setHardness(-1.0F);
		setHarvestLevel("pickaxe", 2);
		this.fullBlock = false;
		setCreativeTab(ModularBosses.tabBlocks);
	}

/*	@Override
	@SideOnly(Side.CLIENT)
	public IStateMapper getCustomStateMap() {
		return new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("mb:invisible_block");
			}
		};
	}*/
	
	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}