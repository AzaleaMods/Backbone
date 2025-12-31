package dev.jade.backbone;

import dev.jade.backbone.data.client.BackboneLanguageProvider;
import dev.jade.backbone.data.client.BackboneModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BackboneDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {

        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(BackboneLanguageProvider::new);
        pack.addProvider(BackboneModelProvider::new);

    }

}
