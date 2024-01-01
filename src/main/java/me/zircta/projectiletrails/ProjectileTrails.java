package me.zircta.projectiletrails;

import com.gitlab.candicey.zenithloader.ZenithLoader;
import com.gitlab.candicey.zenithloader.dependency.Dependencies;
import me.zircta.projectiletrails.config.ProjectileTrailsConfig;
import me.zircta.projectiletrails.listener.TickListener;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.StartGameEvent;

public class ProjectileTrails implements ModInitializer {
    public static ProjectileTrailsConfig config;

    @Override
    public void preInit() {
        ZenithLoader.INSTANCE.loadDependencies(
                Dependencies.INSTANCE.getConcentra().invoke(
                        // projectiletrails.versions.json
                        "projectiletrails"
                )
        );

        EventBus.subscribe(StartGameEvent.Post.class, (event) -> config = new ProjectileTrailsConfig());
        EventBus.subscribe(StartGameEvent.Post.class, (event) -> EventBus.subscribe(new TickListener()));
    }
}
