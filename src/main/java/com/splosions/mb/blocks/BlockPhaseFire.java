package com.splosions.mb.blocks;

import java.util.Random;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.entity.MBExtendedEntityLivingBase;
import com.splosions.mb.entity.MBExtendedPlayer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPhaseFire extends Block

{
	//world.scheduleBlockUpdate(wx, wy, wz, block, ticks);
	
	public BlockPhaseFire() {
        super(Material.BARRIER);
        setRegistryName("phase_fire");
        setTranslationKey("phase_fire");
		disableStats();
		setBlockUnbreakable();
		setCreativeTab(ModularBosses.tabBlocks);
		this.setTickRandomly(true);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, 200);		
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		worldIn.setBlockToAir(pos);
	}
	
    /**
     * Called When an Entity Collided with the Block
     */
	@Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (entityIn instanceof EntityPlayer && !worldIn.isRemote){
        	MBExtendedPlayer.get((EntityPlayer)entityIn).limboTime = 200;
        }

        if (entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityPlayer) && !worldIn.isRemote){
        	MBExtendedEntityLivingBase.get((EntityLivingBase)entityIn).limboTime = 200;
        }
        worldIn.setBlockToAir(pos);
    }
	
    /**
	@Override
	public boolean isCollidable() {
		return false;
	}
     */

	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

	/**
	 * Extinguishes the flames at this location, setting the block to air if flames are not renewable
	 */
	protected void extinguishFlame(World world, BlockPos pos) {
			world.setBlockToAir(pos);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		return world.isSideSolid(pos.down(), EnumFacing.UP);
	}
}