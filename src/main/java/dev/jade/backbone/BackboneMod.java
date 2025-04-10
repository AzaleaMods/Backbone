package dev.jade.backbone;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackboneMod implements ModInitializer {

    public static final String NAME = "Backbone";
    public static final String ID = "backbone";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {

        LOGGER.info("Loaded successfully");

    }

    public static Identifier id(String path) {
        return Identifier.of(ID, path);
    }

}
