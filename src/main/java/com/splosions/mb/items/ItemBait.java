package com.splosions.mb.items;

import java.util.List;

import javax.annotation.Nullable;

import com.splosions.mb.ModularBosses;
import com.splosions.mb.client.render.items.IItemMBRenderer;
import com.splosions.mb.entity.projectile.EntityBait;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBait extends BaseModItem implements IItemMBRenderer {

	public ItemBait(ToolMaterial material) {
		setCreativeTab(ModularBosses.tabTools);
		setMaxStackSize(1);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		ItemStack stack = playerIn.getHeldItem(handIn);
	
		if (!playerIn.capabilities.isCreativeMode) {
			stack.shrink(1);
		}
		
		if (!worldIn.isRemote) {
			Entity projectile = new EntityBait(worldIn, playerIn);
			worldIn.spawnEntity(projectile);
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

		
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
	tooltip.add("Smelly bait to lure out Sand Worms");
	}
	
}
