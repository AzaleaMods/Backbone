package dev.jade.backbone;

import dev.jade.backbone.client.SextantOverlayRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

import static dev.jade.backbone.BackboneMod.*;

public class BackboneClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new SextantOverlayRenderer());
    }

}
