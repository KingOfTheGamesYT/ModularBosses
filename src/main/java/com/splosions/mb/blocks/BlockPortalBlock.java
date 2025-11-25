package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.Reference;
import com.splosions.mb.blocks.tileentity.TileEntityPortalBlock;

import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Objects;

public class BlockPortalBlock extends Block implements IHasModel
{
	public BlockPortalBlock(String name) {
        super(Material.BARRIER);
        setRegistryName(name);
        setTranslationKey(Reference.MOD_ID + "." + name);
		setHardness(10.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setCreativeTab(ModularBosses.tabBlocks);
        ModBlocks.BLOCKS.add(this);
        ModularBossesItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));

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

    @Override
    public void registerModels() {
        ModularBosses.proxy.registerModel(Item.getItemFromBlock(this), 0);
    }
}