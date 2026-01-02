package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityModelLayerImpl;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
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

    public static void register() {

        addDefinition(DEEP_ZOMBIE, humanoidBody());
        addDefinition(DEEP_ZOMBIE_BABY, humanoidBody().apply(HumanoidModel.BABY_TRANSFORMER));
        addDefinition(DEEP_ZOMBIE_ARMOR, humanoidArmor(false));
        addDefinition(DEEP_ZOMBIE_BABY_ARMOR, humanoidArmor(true));

    }

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

    public static void addDefinition(ModelLayerLocation location, LayerDefinition definition) {
        EntityModelLayerRegistry.registerModelLayer(location, () -> definition);
    }

    public static void addDefinition(ArmorModelSet<ModelLayerLocation> location, ArmorModelSet<LayerDefinition> definition) {
        EntityModelLayerRegistry.registerEquipmentModelLayers(location, () -> definition);
    }

    private static LayerDefinition humanoidBody() {
        return LayerDefinition.create(
                HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F),
                64, 64
        );
    }

    private static ArmorModelSet<LayerDefinition> humanoidArmor(boolean baby) {
        return HumanoidModel.createArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F))
                .map(mesh -> LayerDefinition.create(mesh, 64, 32))
                .map(layer -> baby ? layer.apply(HumanoidModel.BABY_TRANSFORMER) : layer);
    }

}
