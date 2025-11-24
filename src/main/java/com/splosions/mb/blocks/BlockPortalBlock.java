package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.blocks.tileentity.TileEntityPortalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPortalBlock extends Block 
{
	public BlockPortalBlock() {
        super(Material.BARRIER);
        setRegistryName("portal_block");
        setTranslationKey("portal_block");
		setHardness(10.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setCreativeTab(ModularBosses.tabBlocks);
	}

	public int getRenderBlockPass()
	{
	return -1;
	}	

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityPortalBlock();
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}