package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.entity.DeepZombie;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class BackboneEntities {

    public static final EntityType<DeepZombie> DEEP_ZOMBIE = EntityType.Builder
            .of(DeepZombie::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .eyeHeight(1.74F)
            .passengerAttachments(2.0125F)
            .ridingOffset(-0.7F)
            .clientTrackingRange(8)
            .build(BackboneMod.key(Registries.ENTITY_TYPE, "deep_zombie"));

    public static void register() {
        registerType("deep_zombie", DEEP_ZOMBIE);
    }

    public static <T extends Entity> void registerType(String id, EntityType<T> type) {
        Registry.register(BuiltInRegistries.ENTITY_TYPE, BackboneMod.id(id), type);
    }

}
