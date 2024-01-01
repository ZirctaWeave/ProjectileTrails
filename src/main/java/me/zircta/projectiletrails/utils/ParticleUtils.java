package me.zircta.projectiletrails.utils;

import me.zircta.projectiletrails.ProjectileTrails;
import net.minecraft.util.EnumParticleTypes;

import java.util.HashMap;

public class ParticleUtils {
    public static HashMap<Integer, EnumParticleTypes> particles = new HashMap<>() {{
        put(0, EnumParticleTypes.EXPLOSION_NORMAL);
        put(1, EnumParticleTypes.FIREWORKS_SPARK);
        put(2, EnumParticleTypes.CRIT);
        put(3, EnumParticleTypes.CRIT_MAGIC);
        put(4, EnumParticleTypes.SMOKE_NORMAL);
        put(5, EnumParticleTypes.SPELL);
        put(6, EnumParticleTypes.NOTE);
        put(7, EnumParticleTypes.PORTAL);
        put(8, EnumParticleTypes.ENCHANTMENT_TABLE);
        put(9, EnumParticleTypes.FLAME);
        put(10, EnumParticleTypes.LAVA);
        put(11, EnumParticleTypes.CLOUD);
        put(12, EnumParticleTypes.SNOWBALL);
        put(13, EnumParticleTypes.SLIME);
        put(14, EnumParticleTypes.HEART);

    }};

    public static EnumParticleTypes getParticle() {
        int index = ProjectileTrails.config.particle;
        return particles.getOrDefault(index, EnumParticleTypes.EXPLOSION_NORMAL);
    }
}
