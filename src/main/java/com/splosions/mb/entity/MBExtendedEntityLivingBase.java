package com.splosions.mb.entity;

import net.minecraft.entity.EntityLivingBase;

import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;

/**
 * Base class to hold "limbo" data for entities.
 */
public class MBExtendedEntityLivingBase {

    public EntityLivingBase entity;
    public int limboTime;
    public int limbo;

    public static DataParameter<Integer> LIMBO_WATCHER;

    public MBExtendedEntityLivingBase(EntityLivingBase entity) {
        this.entity = entity;
    }

    /** Call this in the entity's entityInit() */
    public static void initWatcher(EntityLivingBase entity) {
        if (LIMBO_WATCHER == null) {
            LIMBO_WATCHER = EntityDataManager.createKey(
                    entity.getClass(), DataSerializers.VARINT
            );
        }
        entity.getDataManager().register(LIMBO_WATCHER, 0);
    }

    public static MBExtendedEntityLivingBase get(EntityLivingBase entity) {

        if (entity instanceof IHasMBData) {
            return ((IHasMBData) entity).getMBData();
        }
        return null;
    }

    public void onUpdate() {
        if (entity.world.isRemote) {
            this.limbo = entity.getDataManager().get(LIMBO_WATCHER);
        } else {
            entity.getDataManager().set(LIMBO_WATCHER, this.limboTime > 0 ? 1 : 0);
            this.limbo = this.limboTime > 0 ? 1 : 0;
        }
        this.limboTime -= (this.limboTime > 0 ? 1 : 0);
    }

    /** Interface to implement in entities that extend this base class */
    public interface IHasMBData {
        MBExtendedEntityLivingBase getMBData();
    }
}