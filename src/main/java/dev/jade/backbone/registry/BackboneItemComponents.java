package dev.jade.backbone.registry;

import com.mojang.serialization.Codec;
import dev.jade.backbone.BackboneMod;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.ChunkPos;

import java.util.List;

public class BackboneItemComponents {

    public static final ComponentType<Integer> TIME = ComponentType.<Integer>builder()
            .codec(Codec.INT.fieldOf("time").codec())
            .build();

    public static void register() {

        registerComponent("time", TIME);

    }

    public static <T> void registerComponent(String name, ComponentType<T> component) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, BackboneMod.id(name), component);
    }

}
