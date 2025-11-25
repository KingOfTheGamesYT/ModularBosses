
package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;

import com.splosions.mb.Reference;
import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

public class BlockInvisible extends Block implements IHasModel
{
	public BlockInvisible(String name) {
        super(Material.BARRIER);
        setRegistryName(name);
        setTranslationKey(Reference.MOD_ID + "." + name);
		setHardness(-1.0F);
		setHarvestLevel("pickaxe", 2);
		this.fullBlock = false;
		setCreativeTab(ModularBosses.tabBlocks);
        ModBlocks.BLOCKS.add(this);
        ModularBossesItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));

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

    @Override
    public void registerModels() {
        ModularBosses.proxy.registerModel(Item.getItemFromBlock(this), 0);
    }
}