package dev.jade.backbone;

import dev.jade.backbone.registry.BackboneEntities;
import dev.jade.backbone.registry.BackboneItemComponents;
import dev.jade.backbone.registry.BackboneItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static net.minecraft.world.item.equipment.ArmorMaterials.*;

public class BackboneMod implements ModInitializer {

    public static final String NAME = "Backbone";
    public static final String ID = "backbone";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final Map<ArmorMaterial, Double> HEAVY_MATERIALS = Map.of(
            IRON,      -0.100,
            GOLD,      -0.150,
            NETHERITE, -0.200
    );

    public static final Map<EntityType<?>, EntityType<?>> DEEP_MOBS = Map.of(
        EntityType.ZOMBIE, BackboneEntities.DEEP_ZOMBIE
    );

    @Override
    public void onInitialize() {

        BackboneEntities.register();
        BackboneItemComponents.register();
        BackboneItems.register();

        LOGGER.info("Loaded successfully");

    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(ID, path);
    }

    public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registry, String path) {
        return ResourceKey.create(registry, id(path));
    }

}
