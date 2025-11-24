package com.splosions.mb.dimensions;

import com.splosions.mb.Config;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;


public class MBBossWorldProvider extends WorldProvider
{

	

	
    /**
     * Returns a new chunk provider which generates chunks for this world
     */
	@Override
    public IChunkGenerator createChunkGenerator()
    {
        return new BossChunkProvider(world, world.getSeed(), true);
    }
	
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return 0;
		
	}
	


	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
