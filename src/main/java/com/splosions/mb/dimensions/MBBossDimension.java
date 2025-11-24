package com.splosions.mb.dimensions;



import com.splosions.mb.Config;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class MBBossDimension
{
	public static final DimensionType BOSS_DIMENSION = DimensionType.register("BOSS", "_BOSS", Config.bossDimension, MBBossWorldProvider.class, false);
	
	
	public static void init()
	{		
		DimensionManager.registerDimension(Config.bossDimension, BOSS_DIMENSION);
	}
}
