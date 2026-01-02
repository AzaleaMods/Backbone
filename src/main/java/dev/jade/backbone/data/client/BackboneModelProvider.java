package dev.jade.backbone.data.client;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.registry.BackboneItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;

import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class BackboneModelProvider extends FabricModelProvider {

    private static final List<ItemDisplayContext> HANDHELD = List.of(
            ItemDisplayContext.FIRST_PERSON_LEFT_HAND,
            ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
            ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
            ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
            ItemDisplayContext.GROUND,
            ItemDisplayContext.HEAD
    );

    private static final List<ItemDisplayContext> GUI = List.of(
            ItemDisplayContext.GUI,
            ItemDisplayContext.FIXED,
            ItemDisplayContext.ON_SHELF
    );

    private static final ModelTemplate GREAT = itemModel("great", TextureSlot.LAYER0);

    public BackboneModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {

        generator.generateFlatItem(BackboneItems.SEXTANT, ModelTemplates.FLAT_ITEM);

        relicWeapon(BackboneItems.CLAYMORE, generator);

    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generators) {

    }

    @Override
    public String getName() {
        return "Backbone Model Definitions";
    }

    private static void relicWeapon(Item item, ItemModelGenerators generator) {

        ItemModel.Unbaked handheldModel = ItemModelUtils.plainModel(generator.createFlatItemModel(
                item,
                "_handheld",
                GREAT
        ));
        ItemModel.Unbaked guiModel = ItemModelUtils.plainModel(generator.createFlatItemModel(
                item,
                "_gui",
                ModelTemplates.FLAT_ITEM
        ));

        generator.itemModelOutput.accept(
                item,
                ItemModelUtils.select(new DisplayContext(),
                        ItemModelUtils.when(HANDHELD, handheldModel),
                        ItemModelUtils.when(GUI, guiModel)
                )
        );

    }

    private static ModelTemplate itemModel(String parent, TextureSlot keys) {
        return new ModelTemplate(
                Optional.of(BackboneMod.id("item/" + parent)),
                Optional.empty(),
                keys
        );
    }

}
