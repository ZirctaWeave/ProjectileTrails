package me.zircta.projectiletrails.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class ProjectileTrailsConfig extends Config {
    @Dropdown(
            name = "Particle",
            options = {"Explosion", "Firework", "Critical", "Sharpness", "Smoke", "Spell", "Note", "Portal", "Enchantment", "Flame", "Lava", "Cloud", "Snow", "Slime", "Heart"},
            description = "Allows you to choose the particle."
    )
    public int particle = 3;

    @Slider(
            name = "Amount",
            min = 1.0f,
            max = 5.0f,
            step = 1,
            description = "Allows you to change the amount of particles."
    )
    public float amount = 1.0f;

    public ProjectileTrailsConfig() {
        super(new Mod("Projectile Trails", ModType.PVP), "projectile-trails.json");
        this.initialize();
    }
}
