package dev.jade.backbone;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static net.minecraft.item.ArmorMaterials.*;

public class BackboneMod implements ModInitializer {

    public static final String NAME = "Backbone";
    public static final String ID = "backbone";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final Map<RegistryEntry<ArmorMaterial>, Double> HEAVY_MATERIALS = Map.of(
            IRON,      -0.100,
            GOLD,      -0.150,
            NETHERITE, -0.200
    );

    @Override
    public void onInitialize() {

        LOGGER.info("Loaded successfully");

    }

    public static Identifier id(String path) {
        return Identifier.of(ID, path);
    }

}
