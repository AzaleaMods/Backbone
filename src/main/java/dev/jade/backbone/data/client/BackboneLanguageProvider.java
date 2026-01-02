package dev.jade.backbone.data.client;

import dev.jade.backbone.registry.BackboneEntities;
import dev.jade.backbone.registry.BackboneItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

@Environment(EnvType.CLIENT)
public class BackboneLanguageProvider extends FabricLanguageProvider {

    public BackboneLanguageProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {

        builder.add(BackboneItems.SEXTANT, "Sextant");
        builder.add(BackboneEntities.DEEP_ZOMBIE, "Deep Zombie");

    }

}
