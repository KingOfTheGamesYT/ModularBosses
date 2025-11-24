
package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.blocks.BlockRotationData.Rotation;
import com.splosions.mb.world.PortalLandingWorldData;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPortalLanding extends Block implements IVanillaRotation {

	public BlockPortalLanding() {
        super(Material.BARRIER);
        setRegistryName("portal_landing");
        setTranslationKey("portal_landing");
		setHardness(-1.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setCreativeTab(ModularBosses.tabBlocks);
	}

	@Override
	 public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing face, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		if (!worldIn.isRemote) {
			PortalLandingWorldData roomData = (PortalLandingWorldData) worldIn.getPerWorldStorage().getOrLoadData(PortalLandingWorldData.class, "lobbyPortals");
			if (roomData == null) {
				ModularBosses.logger.info("No LobbyPortals Tag found in world, creating one");
				roomData = new PortalLandingWorldData("lobbyPortals");
				worldIn.getPerWorldStorage().setData("lobbyPortals", roomData);
			}
			roomData.addPortalLanding(0, pos.getX(), pos.getY(), pos.getZ());
			roomData.markDirty();
		}
		return this.getStateFromMeta(meta);
	}

	public static void makePortalLanding(World worldIn, BlockPos pos) {
		if (!worldIn.isRemote) {
			PortalLandingWorldData roomData = (PortalLandingWorldData) worldIn.getPerWorldStorage().getOrLoadData(PortalLandingWorldData.class, "lobbyPortals");
			if (roomData == null) {
				ModularBosses.logger.info("No LobbyPortals Tag found in world, creating one");
				roomData = new PortalLandingWorldData("lobbyPortals");
				worldIn.getPerWorldStorage().setData("lobbyPortals", roomData);
			}
			roomData.addPortalLanding(0, pos.getX(), pos.getY(), pos.getZ());
			roomData.markDirty();
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			PortalLandingWorldData roomData = (PortalLandingWorldData) worldIn.getPerWorldStorage().getOrLoadData(PortalLandingWorldData.class, "lobbyPortals");
			roomData.deletePortalLanding(0, pos.getX(), pos.getY(), pos.getZ());
		}
	}

	@Override
	public Rotation getRotationPattern() {
		// TODO Auto-generated method stub
		return null;
	}
}