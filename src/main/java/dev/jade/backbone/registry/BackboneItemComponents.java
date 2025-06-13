package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.List;

public class BackboneItemComponents {

    public static final ComponentType<List<ItemStack>> CHARM_BAG = ComponentType.<List<ItemStack>>builder()
            .codec(ItemStack.CODEC.listOf().fieldOf("charm_bag").codec())
            .build();

    public static void register() {

        registerComponent("charm_bag", CHARM_BAG);

    }

    public static <T> void registerComponent(String name, ComponentType<T> component) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, BackboneMod.id(name), component);
    }

}
