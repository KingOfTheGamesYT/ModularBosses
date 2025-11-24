package com.splosions.mb.entity;

import com.splosions.mb.MBSounds;
import com.splosions.mb.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Tracks limbo and knockdown state per player.
 */
public class MBExtendedPlayer {

    public int limboTime = 0;
    public int preLimbo = 0;
    public int limbo = 0;
    public int knockdownTime = 0;
    private EntityPlayer player;

    public MBExtendedPlayer() {
    }

    public MBExtendedPlayer(EntityPlayer player) {
        this.player = player;
    }

    /**
     * Called every tick to update player states.
     */
    public void onUpdate() {
        if (player.world.isRemote) {
            // Client-side: update visual effects
            if (preLimbo != limbo && player == Minecraft.getMinecraft().player) {
                if (limbo == 1) {
                    ClientProxy.sobelShader();
                    Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    player.playSound(MBSounds.LIMBO, 20F, 1.0F);
                } else {
                    ClientProxy.clearShader();
                }
            }
            preLimbo = limbo;

            if (knockdownTime >= 2 && player == Minecraft.getMinecraft().player) {
                player.setInWeb();
                player.setVelocity(0, 0, 0);
                Minecraft.getMinecraft().gameSettings.thirdPersonView = 1;
            } else if (knockdownTime == 1 && player == Minecraft.getMinecraft().player) {
                Minecraft.getMinecraft().gameSettings.thirdPersonView = 0;
            }
        }

        // Tick timers
        knockdownTime = Math.max(knockdownTime - 1, 0);
        limboTime = Math.max(limboTime - 1, 0);
        limbo = limboTime > 0 ? 1 : 0;
    }

    /** ---------------------- NBT Serialization ---------------------- */
    public void saveNBTData(NBTTagCompound compound) {
        compound.setInteger("limboTime", limboTime);
        compound.setInteger("preLimbo", preLimbo);
        compound.setInteger("limbo", limbo);
        compound.setInteger("knockdownTime", knockdownTime);
    }

    public void loadNBTData(NBTTagCompound compound) {
        limboTime = compound.getInteger("limboTime");
        preLimbo = compound.getInteger("preLimbo");
        limbo = compound.getInteger("limbo");
        knockdownTime = compound.getInteger("knockdownTime");
    }

    /** ---------------------- Capability ---------------------- */
    @CapabilityInject(MBExtendedPlayer.class)
    public static Capability<MBExtendedPlayer> MB_CAP = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(
                MBExtendedPlayer.class,
                new MBExtendedPlayerStorage(),
                MBExtendedPlayer::new
        );
    }

    /** Convenience static getter, replaces old getExtendedProperties */
    public static MBExtendedPlayer get(EntityPlayer player) {
        return player.getCapability(MB_CAP, null);
    }

    /** ---------------------- Capability Provider ---------------------- */
    public static class MBExtendedPlayerProvider implements ICapabilitySerializable<NBTTagCompound> {

        private MBExtendedPlayer instance;

        public MBExtendedPlayerProvider(EntityPlayer player) {
            this.instance = new MBExtendedPlayer(player);
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
            return capability == MB_CAP ? MB_CAP.cast(instance) : null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            NBTTagCompound tag = new NBTTagCompound();
            instance.saveNBTData(tag);
            return tag;
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {
            instance.loadNBTData(nbt);
        }

        @Override
        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
            return capability == MB_CAP;
        }
    }

    /** ---------------------- Attach Event ---------------------- */
    public static class CapabilityHandler {
        @SubscribeEvent
        public void attachCapabilities(AttachCapabilitiesEvent<EntityPlayer> event) {
            event.addCapability(
                    new ResourceLocation("yourmodid", "mbdata"),
                    new MBExtendedPlayerProvider(event.getObject())
            );
        }
    }

    /** ---------------------- Storage Class ---------------------- */
    public static class MBExtendedPlayerStorage implements Capability.IStorage<MBExtendedPlayer> {

        @Override
        public NBTTagCompound writeNBT(Capability<MBExtendedPlayer> capability, MBExtendedPlayer instance, EnumFacing side) {
            NBTTagCompound tag = new NBTTagCompound();
            instance.saveNBTData(tag);
            return tag;
        }

        @Override
        public void readNBT(Capability<MBExtendedPlayer> capability, MBExtendedPlayer instance, EnumFacing side, net.minecraft.nbt.NBTBase nbt) {
            if (nbt instanceof NBTTagCompound) {
                instance.loadNBTData((NBTTagCompound) nbt);
            }
        }
    }
}