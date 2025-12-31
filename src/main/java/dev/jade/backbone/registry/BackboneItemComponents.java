package dev.jade.backbone.registry;

import com.mojang.serialization.Codec;
import dev.jade.backbone.BackboneMod;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class BackboneItemComponents {

    public static final DataComponentType<Integer> TIME = DataComponentType.<Integer>builder()
            .persistent(Codec.INT.orElse(0).fieldOf("time").codec())
            .build();
    public static final DataComponentType<Boolean> DEATH_PROTECTION = DataComponentType.<Boolean>builder()
            .persistent(Codec.BOOL.orElse(false).fieldOf("death_protection").codec())
            .build();


    public static void register() {
        registerComponent("time", TIME);
        registerComponent("death_protection", DEATH_PROTECTION);
    }

    public static <T> void registerComponent(String name, DataComponentType<T> component) {
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, BackboneMod.id(name), component);
    }

}
