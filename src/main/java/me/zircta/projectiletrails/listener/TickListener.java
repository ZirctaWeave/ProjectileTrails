package me.zircta.projectiletrails.listener;

import me.zircta.projectiletrails.ProjectileTrails;
import me.zircta.projectiletrails.utils.ParticleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityThrowable;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class TickListener {
    @SubscribeEvent
    public void onTick(TickEvent.Pre ev) {
        if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().thePlayer != null) {
            if (Minecraft.getMinecraft().theWorld != null) {
                WorldClient world = Minecraft.getMinecraft().theWorld;
                for (Entity en : world.entityList) {
                    if (en != null) {
                        if ((en instanceof EntityArrow || en instanceof EntityFishHook || en instanceof EntityThrowable) && isMoving(en)) {
                            for (int i = 1; i <= ProjectileTrails.config.amount; i++) {
                                world.spawnParticle(ParticleUtils.getParticle(), en.prevPosX, en.prevPosY, en.prevPosZ, 0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isMoving(Entity en) {
        return en.posX != en.prevPosX || en.posY != en.prevPosY || en.posZ != en.prevPosZ;
    }
}
