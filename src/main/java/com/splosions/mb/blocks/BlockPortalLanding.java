
package com.splosions.mb.blocks;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.Reference;
import com.splosions.mb.blocks.BlockRotationData.Rotation;
import com.splosions.mb.items.ModularBossesItems;
import com.splosions.mb.util.IHasModel;
import com.splosions.mb.world.PortalLandingWorldData;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class BlockPortalLanding extends Block implements IHasModel {

	public BlockPortalLanding(String name) {
        super(Material.BARRIER);
        setRegistryName(name);
        setTranslationKey(Reference.MOD_ID + "." + name);
		setHardness(-1.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setCreativeTab(ModularBosses.tabBlocks);
        ModBlocks.BLOCKS.add(this);
        ModularBossesItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
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
    public void registerModels() {
        ModularBosses.proxy.registerModel(Item.getItemFromBlock(this), 0);
    }
}