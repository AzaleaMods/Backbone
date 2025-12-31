package dev.jade.backbone;

import dev.jade.backbone.client.SextantOverlayRenderer;
import dev.jade.backbone.entity.renderer.DeepZombieRenderer;
import dev.jade.backbone.registry.BackboneEntities;
import dev.jade.backbone.registry.BackboneModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

import static dev.jade.backbone.BackboneMod.*;

public class BackboneClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BackboneModelLayers.register();

        HudElementRegistry.addLast(id("sextant"), new SextantOverlayRenderer());

        EntityRenderers.register(BackboneEntities.DEEP_ZOMBIE, DeepZombieRenderer::new);

    }

}
