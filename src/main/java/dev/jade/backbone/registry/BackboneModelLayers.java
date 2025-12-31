package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ArmorModelSet;

@Environment(EnvType.CLIENT)
public class BackboneModelLayers {

    public static final ModelLayerLocation DEEP_ZOMBIE =
            registerLayer("deep_zombie");
    public static final ModelLayerLocation DEEP_ZOMBIE_BABY =
            registerLayer("deep_zombie_baby");
    public static final ArmorModelSet<ModelLayerLocation> DEEP_ZOMBIE_ARMOR =
            registerArmor("deep_zombie");
    public static final ArmorModelSet<ModelLayerLocation> DEEP_ZOMBIE_BABY_ARMOR =
            registerArmor("deep_zombie_baby");

    public static void register() {}

    public static ModelLayerLocation registerLayer(String model) {
        return registerLayer(model, "main");
    }

    public static ModelLayerLocation registerLayer(String model, String layer) {
        return new ModelLayerLocation(BackboneMod.id(model), layer);
    }

    public static ArmorModelSet<ModelLayerLocation> registerArmor(String model) {
        return new ArmorModelSet<>(
                registerLayer(model, "helmet"),
                registerLayer(model, "chestplate"),
                registerLayer(model, "leggings"),
                registerLayer(model, "boots")
        );
    }

}
