package dev.jade.backbone.entity.renderer;

import com.google.common.collect.ImmutableList;
import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.registry.BackboneModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class DeepZombieRenderer extends ZombieRenderer {

    private static final List<Identifier> TEXTURES = ImmutableList.of(
            BackboneMod.id("textures/entity/zombie/deep1.png")
    );

    public DeepZombieRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                BackboneModelLayers.DEEP_ZOMBIE,
                BackboneModelLayers.DEEP_ZOMBIE_BABY,
                BackboneModelLayers.DEEP_ZOMBIE_ARMOR,
                BackboneModelLayers.DEEP_ZOMBIE_BABY_ARMOR
        );
    }

    @Override
    public Identifier getTextureLocation(ZombieRenderState state) {
        return TEXTURES.getFirst();
    }

}
