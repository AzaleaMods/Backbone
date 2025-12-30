package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.entity.DeepZombieEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BackboneEntities {

    public static final EntityType<DeepZombieEntity> DEEP_ZOMBIE = EntityType.Builder
            .create(DeepZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.95F)
            .eyeHeight(1.74F)
            .passengerAttachments(2.0125F)
            .vehicleAttachment(-0.7F)
            .maxTrackingRange(8)
            .build("deep_zombie");

    public static void register() {
        registerType("deep_zombie", DEEP_ZOMBIE);
    }

    public static <T extends Entity> void registerType(String id, EntityType<T> type) {
        Registry.register(Registries.ENTITY_TYPE, BackboneMod.id(id), type);
    }

}
